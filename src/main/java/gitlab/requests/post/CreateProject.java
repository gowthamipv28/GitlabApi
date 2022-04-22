package gitlab.requests.post;


import gitlb.payloads.PayloadAddMember;
import io.restassured.RestAssured;


import io.restassured.path.json.JsonPath;

import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeClass;


public class CreateProject {

    public static String token = "glpat-nJjUybBa8ZVmxtamHH_2";

    String userName = "Gowthami_test12";
    String path = "Gowthami_test12";


    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://gitlab.com";
    }


    public void createProjectGitLab() {
        RequestSpecification request = RestAssured.given();
        request.queryParam("name", userName).queryParam("path", path).
                header("Authorization", "Bearer " + token).
                header("Content-Type", "appilication/json");
        String response = request.post("/api/v4/projects").then().extract().asString();
        JsonPath jsonPath = new JsonPath(response);
        String projectId = jsonPath.getString("id");


    }

    public void addMember() {


        RequestSpecification request = RestAssured.given();
        request.
                header("Authorization", "Bearer " + token).header("Content-Type", "application/json").
                body(PayloadAddMember.addMember());
        String response = request.post("/api/v4/projects/35565159/members").then().extract().asString();
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        System.out.println(jsonPath.getString("username"));
        String getNewId = jsonPath.getString("id");
        System.out.println(getNewId);
    }


    public static String listOfMembers() {

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token);
        String response = request.get("/api/v4/projects/35565159/members").then().extract().asString();
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        String id = jsonPath.getString("id[0]");
        return id;


    }

    public void createVariable() {

        RequestSpecification request = RestAssured.given();
        request.
                header("Authorization", "Bearer " + token).header("Content-Type", "application/json").
                body(PayloadAddMember.createVariable());
        String response = request.post("api/v4/projects/35565159/variables").then().extract().asString();
        System.out.println(response);


    }


}
