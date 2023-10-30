package com.ait.tests.restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteAllContactsTestsRA extends TestBase{

    @Test
    public void deleteAllContactsSuccessTest() {

        given()
                .header("Authorization",TOKEN)
                .when()
                .delete("contacts/clear")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("message",equalTo("All contacts was deleted!"));
    }
}
