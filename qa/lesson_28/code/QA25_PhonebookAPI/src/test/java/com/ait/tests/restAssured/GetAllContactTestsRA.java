package com.ait.tests.restAssured;

import com.ait.dto.ContactDto;
import com.ait.dto.GetAllContactsDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetAllContactsTestsRA extends com.ait.tests.restAssured.TestBase {

    @Test
    public void getAllContactsSuccessTest() {

        GetAllContactsDto responseDto = given()
                .header("Authorization", TOKEN)
                .when()
                .get("contacts")
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(GetAllContactsDto.class);

        for (ContactDto contact: responseDto.getContacts()) {
            System.out.println(contact.getId() + "***" + contact.getName());
            System.out.println("===========================================");
        }
    }

    @Test
    public void getAllContactsErrorTest() {
        given()
                .header("Authorization","awkejf87")
                .when()
                .get("contacts")
                .then()
                .assertThat().statusCode(401)
                .assertThat().body("error",equalTo("Unauthorized"));

    }
}
