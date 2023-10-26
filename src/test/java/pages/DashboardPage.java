package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashboardPage extends CommonMethods {

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement empListOption;

    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement adminButton;
    @FindBy(id = "searchSystemUser_userName")
    public WebElement searchUserName;
    @FindBy(id = "searchBtn")
    public WebElement searchBtn;
    @FindBy(name = "chkSelectRow[]")
    public WebElement checkBox;

    @FindBy(id = "btnDelete")
    public WebElement deleteBtn;

    @FindBy(id = "dialogDeleteBtn")
    public WebElement confirmDelBtn;
    @FindBy(id = "menu_admin_Job")
    public WebElement adminJobButton;
    @FindBy(id = "menu_admin_viewJobTitleList")
    public WebElement adminJobJobTitleButton;

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

}