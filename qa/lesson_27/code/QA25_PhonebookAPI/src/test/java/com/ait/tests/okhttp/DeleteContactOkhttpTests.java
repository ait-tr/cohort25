package com.ait.tests.okhttp;

import com.ait.dto.ContactDto;
import com.ait.dto.MessageDto;
import com.google.gson.Gson;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteContactOkhttpTests {

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoibGVub0BnbWFpbC5jb20iLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTY5OTAwMTI2MiwiaWF0IjoxNjk4NDAxMjYyfQ.QTq-eRTPKJvP1pzL70buQAkI4bzInGkULa4YZuQXo7s";

    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();
    String id;

    @BeforeMethod
    public void precondition() throws IOException {
        //create contact
        ContactDto contactDto = ContactDto.builder()
                .name("Oliver")
                .lastName("Kan")
                .address("Berlin")
                .email("kan@gmail.com")
                .phone("1234567890")
                .description("goalkeeper")
                .build();

        RequestBody requestBody = RequestBody.create(gson.toJson(contactDto), JSON);
        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts")
                .post(requestBody)
                .addHeader("Authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        MessageDto messageDto = gson.fromJson(response.body().string(), MessageDto.class);
        String message = messageDto.getMessage();
        System.out.println(message);

        //get id from "message": "Contact was added! ID: a100e140-b87a-4690-895f-8e25ff9c6363"
        String[] all = message.split(": ");
        id = all[1];
    }

    @Test
    public void deleteContactByIdPositiveTest() throws IOException {
        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts/" + id)
                .delete()
                .addHeader("Authorization", token)
                .build();

        Response response = client.newCall(request).execute();
        Assert.assertEquals(response.code(),200);
        MessageDto messageDto = gson.fromJson(response.body().string(),MessageDto.class);
        System.out.println(messageDto.getMessage());
        Assert.assertEquals(messageDto.getMessage(),"Contact was deleted!");
    }
}
