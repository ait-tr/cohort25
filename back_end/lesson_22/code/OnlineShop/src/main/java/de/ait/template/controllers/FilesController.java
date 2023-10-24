package de.ait.template.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * 10/24/2023
 * OnlineShop
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RestController
public class FilesController {

    @Value("${dropbox.api.host}")
    private String apiHost;

    @Value("${dropbox.api.token}")
    private String apiToken;

    private RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/files")
    public void upload() {
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", apiToken);
        headers.set("Content-type", MediaType.APPLICATION_JSON_VALUE);

        String response = restTemplate.exchange(apiHost + "/check/user", HttpMethod.POST, new HttpEntity("\n" +
                "{\n" +
                "  \"query\": \"simple\"\n" +
                "}", headers), String.class).getBody();

        System.out.println(response);
    }
}
