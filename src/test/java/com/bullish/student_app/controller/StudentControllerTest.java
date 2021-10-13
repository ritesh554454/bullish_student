package com.bullish.student_app.controller;

import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.RestClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentControllerTest {

    private String appURL="http://localhost:8080/students";
    private Response response;
    private List<String> jsonResponse;
    int totalStudentCount=10;

    @Test(priority = 1)
    public void getStudents() {
        validateGet();
    }

    @Test(priority = 2)
    public void createStudent_Test1() throws JSONException{
        Map<String,String> testData=new HashMap();
        testData.put("firstName","test11");
        testData.put("lastName","lastName11");
        testData.put("class","1 A");
        testData.put("nationality","India");
        validatePost(11,testData);
    }

    @Test(priority = 3)
    public void createStudent_Test2() throws JSONException{
        Map<String,String> testData=new HashMap();
        testData.put("firstName","test12");
        testData.put("lastName","lastName12");
        testData.put("class","2 A");
        testData.put("nationality","India");
        validatePost(12,testData);
    }

    @Test(priority = 4)
    public void updateStudent_Test1()throws JSONException {
        Map<String,String> testData=new HashMap<>();
        testData.put("firstName","update1");
        validatePut(1,testData);
    }

    @Test(priority = 5)
    public void updateStudent_Test2()throws JSONException {
        Map<String,String> testData=new HashMap<>();
        testData.put("firstName","update1");
        validatePut(1,testData);
    }

    @Test(priority = 6)
    public void deleteStudent_Test1() throws JSONException{
        Map<String,String> testData=new HashMap<>();
        testData.put("id","11");
        validateDelete(testData);
    }

    @Test(priority = 7)
    public void deleteStudent_Test2() throws JSONException{
        Map<String,String> testData=new HashMap<>();
        testData.put("id","12");
        validateDelete(testData);
    }



    public void validateGet(){
        jsonResponse=null;
        response=RestClient.getRequest(appURL);
        jsonResponse = response.jsonPath().getList("$");
        validateResponseCode();
        validateTotalStudentCount(totalStudentCount);
    }


    public void validatePut(int id,Map<String,String> testData)throws JSONException {
        jsonResponse=null;
        response=null;
        JSONObject requestParams = new JSONObject();
        requestParams.put("id",id);
        for (Map.Entry<String, String> entry : testData.entrySet()) {
            requestParams.put(entry.getKey(),entry.getValue());
        }
        response=RestClient.putRequest(appURL,requestParams);
        validateResponseCode();
        validateGet();
        validateParam(id,testData);
    }


    public void validatePost(int id,Map<String,String> testData)throws JSONException {
        jsonResponse=null;
        response=null;
        JSONObject requestParams = new JSONObject();
        requestParams.put("id",id);
        for (Map.Entry<String, String> entry : testData.entrySet()) {
            requestParams.put(entry.getKey(),entry.getValue());
        }
        response=RestClient.postRequest(appURL,requestParams);
        validateResponseCode();
        ++totalStudentCount;
        validateGet();
    }


    public void validateDelete(Map<String,String> testData)throws JSONException{
        jsonResponse=null;
        response=null;
        JSONObject requestParams = new JSONObject();
        for (Map.Entry<String, String> entry : testData.entrySet()) {
            if(entry.getKey()=="id"){
                requestParams.put(entry.getKey(),Integer.parseInt(entry.getValue()));
            }
            requestParams.put(entry.getKey(),entry.getValue());
        }
        response=RestClient.deleteRequest(appURL,requestParams);
        validateResponseCode();
        --totalStudentCount;
        validateGet();
    }


    public void validateResponseCode(){
        Assert.assertEquals(response.getStatusCode(),200,"response code for api is 200 OK");
    }


    public void validateTotalStudentCount(int id){
        Assert.assertEquals(jsonResponse.size(),id,"Total student count is "+jsonResponse.size());
    }


    public void validateParam(int id,Map<String,String> testData){
        for (Map.Entry<String, String> entry : testData.entrySet()) {
            Assert.assertTrue(response.jsonPath().getString(entry.getKey()+"["+(id-1)+"]").equalsIgnoreCase(entry.getValue()),"Actual param value is : "+response.jsonPath().getString(entry.getKey()+"["+(id-1)+"]"));
        }
     }

}