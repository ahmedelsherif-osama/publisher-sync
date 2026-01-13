package com.ahmed.publishersync.inventory;

import com.ahmed.publishersync.inventory.dto.InventoryCheckRequest;
import com.ahmed.publishersync.inventory.dto.InventoryCheckResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class ErpInventoryClient {

    private final RestTemplate restTemplate;

    public ErpInventoryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean checkStock(UUID variantId, int quantity) {
        InventoryCheckRequest request =
                new InventoryCheckRequest(variantId, quantity);

        InventoryCheckResponse response =
                restTemplate.postForObject(
                        "http://erp-service/api/inventory/check",
                        request,
                        InventoryCheckResponse.class
                );

        return response != null && response.available();
    }
}
