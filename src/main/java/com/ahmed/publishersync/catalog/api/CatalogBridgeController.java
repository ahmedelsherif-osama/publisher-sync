package com.ahmed.publishersync.catalog.api;

import com.ahmed.publishersync.catalog.CatalogBridgeService;
import com.ahmed.publishersync.catalog.dto.BridgePublicationListRequest;
import com.ahmed.publishersync.catalog.dto.BridgePublicationRequest;
import com.ahmed.publishersync.catalog.dto.BridgePublicationResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bridge/catalog/publications")
public class CatalogBridgeController {

    private final CatalogBridgeService service;

    public CatalogBridgeController(CatalogBridgeService service) {
        this.service = service;
    }

    @PostMapping
    public BridgePublicationResponse pushPublications(
            @RequestBody BridgePublicationRequest wrapper
    ) {
        System.out.println("BRIDGE RECEIVED: " + wrapper);
        return service.syncPublications(wrapper);
    }
}
