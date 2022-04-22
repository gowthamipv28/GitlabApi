
package gitlab.requests.delete;


import gitlab.requests.post.CreateProject;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class DeleteRequests {
    CreateProject createProject = new CreateProject();


    public int deleteVariable() {
        createProject.setup();

        RequestSpecification request = RestAssured.given().log().all();
        request.
                header("Authorization", "Bearer " + createProject.token);
        int response = request.delete("api/v4/projects/35565159/variables/Test").then().extract().statusCode();

        return response;


    }


    public int deleteProject() {
        createProject.setup();
        RequestSpecification request = RestAssured.given().log().all();
        request.
                header("Authorization", "Bearer " + createProject.token);
        int deleteResponse = request.delete("api/v4/projects/35565159").then().extract().statusCode();

        return deleteResponse;
    }
}

