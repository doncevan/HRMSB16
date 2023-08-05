package utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Jacob\",\n" +
                "  \"emp_lastname\": \"Bronson\",\n" +
                "  \"emp_middle_name\": \"Van\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2003-03-20\",\n" +
                "  \"emp_status\": \"working\",\n" +
                "  \"emp_job_title\": \"QA\"\n" +
                "}";
        return createEmployeePayload;
    }
    public static String createEmployeeJsonPayload(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Jacob");
        obj.put("emp_lastname","Bronson");
        obj.put("emp_middle_name","Van");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2003-03-20");
        obj.put("emp_status","working");
        obj.put("emp_job_title","QA");
        return obj.toString();
    }
    public static String createEmployeeJsonPayloadDynamic
            (String f_n, String l_n, String m_n, String gender, String DOB, String status, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname",f_n);
        obj.put("emp_lastname",l_n);
        obj.put("emp_middle_name",m_n);
        obj.put("emp_gender",gender);
        obj.put("emp_birthday",DOB);
        obj.put("emp_status",status);
        obj.put("emp_job_title",jobTitle);
        return obj.toString();
    }
    public static String partiallyUpdateEmployeeJsonPayloadDynamic
            (String employee_id, String f_n){
        JSONObject obj = new JSONObject();
        obj.put("employee_id",employee_id);
        obj.put("emp_firstname",f_n);
        return obj.toString();
    }
}
