package com.ahmed.publishersync.inventory;

import com.ahmed.publishersync.inventory.dto.InventoryCheckRequest;
import com.ahmed.publishersync.inventory.dto.InventoryCheckResponse;
import org.springframework.stereotype.Service;

@Service
public class InventoryBridgeService {

    private final ErpInventoryClient erpClient;

    public InventoryBridgeService(ErpInventoryClient erpClient) {
        this.erpClient = erpClient;
    }

    public InventoryCheckResponse checkAvailability(InventoryCheckRequest request) {
        boolean available =
                erpClient.checkStock(request.variantId(), request.quantity());

        return new InventoryCheckResponse(available);
    }
}
