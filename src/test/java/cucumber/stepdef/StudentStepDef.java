package cucumber.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import util.RestClient;
import java.util.List;

public class StudentStepDef {

    private String appURL="http://localhost:8080/students";
    private Response response;
    private List<String> jsonResponse;

    @Given("Launch the get API")
    public void launchGetApi(){
        jsonResponse=null;
        response=RestClient.getRequest(appURL);
        jsonResponse = response.jsonPath().getList("$");
    }

    @Given("Launch the put API \"([^\"]*)\" \"([^\"]*)\"")
    public void launchPutApi(String id,String firstName)throws JSONException {
        jsonResponse=null;
        response=null;
        JSONObject requestParams = new JSONObject();
        requestParams.put("id",Integer.parseInt(id));
        requestParams.put("firstName",firstName);
        response=RestClient.putRequest(appURL,requestParams);

    }

    @Given("Launch the post API \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"")
    public void launchPostApi(String id,String firstName,String lastName,String studentClass,String nationality)throws JSONException {
        jsonResponse=null;
        response=null;
        JSONObject requestParams = new JSONObject();
        requestParams.put("id",Integer.parseInt(id));
        requestParams.put("firstName",firstName);
        requestParams.put("lastName",lastName);
        requestParams.put("class",studentClass);
        requestParams.put("nationality",nationality);
        response=RestClient.postRequest(appURL,requestParams);
    }

    @Given("Launch the delete API with id \"([^\"]*)\"")
    public void launchDeleteApi(String id)throws JSONException{
        jsonResponse=null;
        response=null;
        JSONObject requestParams = new JSONObject();
        requestParams.put("id",Integer.parseInt(id));
        response=RestClient.deleteRequest(appURL,requestParams);
    }

    @When("Response code is 200 OK")
    public void validateResponseCode(){
        Assert.assertEquals("response code for api is 200 OK",response.getStatusCode(),200);
    }

    @Then("Total student count in response is \"([^\"]*)\"")
    public void totalStudentCount(String id){
        Assert.assertEquals("Total student count is "+jsonResponse.size(),jsonResponse.size(),Integer.parseInt(id));
    }

    @Then("Validate given param value in get response \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"")
    public void validateParam(String param_name,String param_value,String id){
        Assert.assertTrue("Actual param value is : "+response.jsonPath().getString(param_name+"["+(Integer.parseInt(id)-1)+"]"),response.jsonPath().getString(param_name+"["+(Integer.parseInt(id)-1)+"]").equalsIgnoreCase(param_value));
    }


}
