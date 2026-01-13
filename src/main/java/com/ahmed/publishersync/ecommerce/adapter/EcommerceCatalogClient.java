package com.ahmed.publishersync.ecommerce.adapter;

import com.ahmed.publishersync.catalog.dto.BridgePublicationRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@Qualifier("bridgeRestTemplate")
public class EcommerceCatalogClient {

    private final RestTemplate restTemplate;
    private String jwtToken; // store JWT for reuse

    public EcommerceCatalogClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Method to login and fetch JWT token
    private void loginIfNeeded() {
        if (jwtToken != null) return; // already have token

        String loginUrl = "http://localhost:8081/api/auth/login";
        Map<String, String> loginRequest = Map.of(
                "email", "test@test.com",    // replace with your service account
                "password", "Test@123"
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(loginRequest, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(loginUrl, entity, Map.class);
        jwtToken = (String) response.getBody().get("token"); // assuming the JWT is in "token" field
    }

    public void pushPublication(BridgePublicationRequest publication) {
        loginIfNeeded(); // ensure we have a token

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(jwtToken); // attach JWT

        HttpEntity<BridgePublicationRequest> entity = new HttpEntity<>(publication, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                    "http://localhost:8081/api/products",
                    entity,
                    String.class
            );
            System.out.println("bridge got status: " + response.getStatusCode());
            System.out.println("bridge got body: " + response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
