package com.ait.tests.okhttp;

import com.ait.dto.AuthRequestDto;
import com.ait.dto.AuthResponseDto;
import com.ait.dto.ErrorDto;
import com.google.gson.Gson;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginOkhttpTest {

    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");

    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();

    @Test
    public void loginPositiveTest() throws IOException {

        AuthRequestDto requestDto = AuthRequestDto.builder()
                .username("leno@gmail.com")
                .password("Bernd1234$")
                .build();

        RequestBody requestBody = RequestBody.create(gson.toJson(requestDto), JSON);

        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        String responseJson = response.body().string();

        if (response.isSuccessful()) {
            AuthResponseDto responseDto = gson.fromJson(responseJson, AuthResponseDto.class);
            System.out.println(responseDto.getToken());
        } else {
            ErrorDto errorDto = gson.fromJson(responseJson, ErrorDto.class);
            System.out.println(errorDto.getStatus());
            System.out.println(errorDto.getMessage());
        }
    }

    @Test
    public void loginNegativeWrongEmailTest() throws IOException {

        AuthRequestDto requestDto = AuthRequestDto.builder()
                .username("le@gm.com")
                .password("Bernd1234$")
                .build();

        RequestBody requestBody = RequestBody.create(gson.toJson(requestDto), JSON);

        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
//        Assert.assertFalse(response.isSuccessful());
//        Assert.assertEquals(response.code(),401);

        ErrorDto errorDto = gson.fromJson(response.body().string(),ErrorDto.class);
        Assert.assertEquals(errorDto.getStatus(),401);
        Assert.assertEquals(errorDto.getMessage(),"Login or Password incorrect");
        Assert.assertEquals(errorDto.getError(),"Unauthorized");
    }
}
