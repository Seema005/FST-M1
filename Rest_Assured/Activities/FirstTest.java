package Examples;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class FirstTest {
    @Test
    public void getRequestWithQuery() {
        Response response =
                given().header("Content-type", "application/json").queryParam("status", "alive").
                        when().get("https://petstore.swagger.io/v2/pet/findByStatus");

        // System.out.println(response.getBody().asString());
        // System.out.println(response.getBody().asPrettyString());
        // System.out.println(response.getHeaders().asList());

        String param = response.then().extract().body().path("[0].name");

        response.then().body("[0].name", equalTo("Oreo"));

    }

    @Test
    public void getRequestWithPathParam() {
        given().header("Content-type", "application/json").pathParam("petId", 404472).log().all().
                when().get("https://petstore.swagger.io/v2/pet/{petId}").
        then().statusCode(200).body("name",equalTo("Hansel")).log().all();

        given()
                .header("Content-type", "application/json")
                .pathParam("petId", 404472)
                .log().all()
                .when()
                .delete("https://petstore.swagger.io/v2/pet/{petId}")
                .then()
                .statusCode(200);
    }
}
