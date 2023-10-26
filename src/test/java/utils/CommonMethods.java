package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import steps.PageInitializer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static void openBrowserAndNavigateToURL() {
        ConfigReader.readProperties(Constants.CONFIG_READER_PATH);
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                ChromeOptions ops = new ChromeOptions();
                //ops.addArguments("--no-sandbox");
                //ops.addArguments("--remote-allow-origins=*");
                ops.addArguments("--headless=new");
                driver = new ChromeDriver(ops);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //this method is going to initialize all the objects available inside this method
        initializePageObjects();
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void sendText(String text, WebElement element) {
        element.clear();
        element.sendKeys(text);
    }

    public static WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void waitForClickAbility(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementPresent(By locator) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static void click(WebElement element) {
        waitForClickAbility(element);
        element.click();
    }


    public static void selectFromDropdown(WebElement dropDown, String visibleText) {
        Select sel = new Select(dropDown);
        sel.selectByVisibleText(visibleText);
    }

    public static void selectFromDropdown(String value, WebElement dropDown) {
        Select sel = new Select(dropDown);
        sel.selectByValue(value);
    }

    public static void selectFromDropdown(WebElement dropDown, int index) {
        Select sel = new Select(dropDown);
        sel.selectByIndex(index);
    }

    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        //we write this line because cucumber accepts array of byte for screenshot
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File screenShot = ts.getScreenshotAs(OutputType.FILE);
        //in case if it doesn't find file name or path it will throw an exception

        try {
            FileUtils.copyFile(screenShot,
                    new File(Constants.SCREENSHOT_FILEPATH + fileName + " "
                            + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern) {
        //it returns the current date and time in java
        Date date = new Date();
        //this function sdf used to format the date as per the pattern we are passing
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        //this line is going to return the formatted date
        return sdf.format(date);
    }

    public static String randomAlphabets() {
        Random random = new Random();
        int alphabetCount = 26;
        char[] alphabets = new char[alphabetCount];
        for (int i = 0; i < alphabetCount; i++) {
            alphabets[i] = (char) ('a' + i);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(alphabetCount);
            char randomAlphabet = alphabets[index];
            result.append(randomAlphabet);
        }
        return result.toString();
    }
}