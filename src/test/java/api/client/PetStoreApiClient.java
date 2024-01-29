package api.client;

import api.data.Url;
import api.models.UserData;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PetStoreApiClient {

    public static Response createUser(UserData userData) {
        return RestAssured
                .given()
                    .baseUri(Url.API_BASE_URL)
                    .contentType("application/json")
                    .body(userData)
                .when()
                    // Prints request data
                    //.log().all()
                    .post("/user")
                .then()
                    // Prints response data
                    //.log().all()
                    .extract().response();
    }

    public static Response findPetByStatus(String status) {
        return RestAssured
                .given()
                    .baseUri(Url.API_BASE_URL)
                    .queryParam("status", status)
                .when()
                    .get("/pet/findByStatus")
                .then()
                    .extract().response();
    }
}
