package com.ahmed.publishersync.ecommerce.adapter;

import com.ahmed.publishersync.ecommerce.dto.EcommerceOrderDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EcommerceOrderClient {

    private final RestTemplate restTemplate;

    public EcommerceOrderClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void pushOrder(EcommerceOrderDto order) {
        restTemplate.postForEntity(
                "http://ecommerce-service/api/orders/import",
                order,
                Void.class
        );
    }
}
