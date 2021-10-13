package util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import static io.restassured.RestAssured.given;

public class RestClient {

    private HttpURLConnection conn;
    public int responseCode=0;

    public static Response getRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

    public static Response putRequest(String endpoint, JSONObject requestParams) {
        RestAssured.defaultParser = Parser.JSON;
        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        body(requestParams.toString()).
                        when().put(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

    public static Response postRequest(String endpoint, JSONObject requestParams) {
        RestAssured.defaultParser = Parser.JSON;
        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        body(requestParams.toString()).
                        when().post(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

    public static Response deleteRequest(String endpoint, JSONObject requestParams) {
        RestAssured.defaultParser = Parser.JSON;
        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        body(requestParams.toString()).
                        when().delete(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

}
