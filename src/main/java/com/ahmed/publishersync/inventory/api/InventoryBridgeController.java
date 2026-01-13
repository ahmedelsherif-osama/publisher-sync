package com.ahmed.publishersync.inventory.api;

import com.ahmed.publishersync.inventory.InventoryBridgeService;
import com.ahmed.publishersync.inventory.dto.InventoryCheckRequest;
import com.ahmed.publishersync.inventory.dto.InventoryCheckResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bridge/inventory")
public class InventoryBridgeController {

    private final InventoryBridgeService service;

    public InventoryBridgeController(InventoryBridgeService service) {
        this.service = service;
    }

    @PostMapping("/check")
    public InventoryCheckResponse check(@RequestBody InventoryCheckRequest request) {
        return service.checkAvailability(request);
    }
}
