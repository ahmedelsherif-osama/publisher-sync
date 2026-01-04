package com.ahmed.publishersync.erp.adapter;

import com.ahmed.publishersync.erp.dto.ErpOrderDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ErpOrderClient {

    private final RestTemplate restTemplate;

    public ErpOrderClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ErpOrderDto> fetchNewOrders() {
        return restTemplate.exchange(
                "http://erp-service/api/orders?status=COMPLETED",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ErpOrderDto>>() {}
        ).getBody();
    }
}
