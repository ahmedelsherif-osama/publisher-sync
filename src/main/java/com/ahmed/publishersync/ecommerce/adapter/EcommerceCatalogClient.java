package com.ahmed.publishersync.ecommerce.adapter;

import com.ahmed.publishersync.catalog.dto.BridgePublicationRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EcommerceCatalogClient {

    private final RestTemplate restTemplate;

    public EcommerceCatalogClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void pushPublication(BridgePublicationRequest publication) {
        // Call E-Commerce API
        restTemplate.postForEntity(
                "http://localhost:8081/api/products", // adjust port as needed
                publication,
                Void.class
        );
    }
}
