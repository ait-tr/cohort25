package com.ait.tests.restAssured;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoibGVub0BnbWFpbC5jb20iLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTY5OTI1NjkwMSwiaWF0IjoxNjk4NjU2OTAxfQ.NGi9OngQxxk_EdaB84TS6arNZRi_7Ka-qyHvPmeQ_kY";

    @BeforeMethod
    public void init() {
        System.err.close();

        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
        RestAssured.basePath = "v1";
    }
}
