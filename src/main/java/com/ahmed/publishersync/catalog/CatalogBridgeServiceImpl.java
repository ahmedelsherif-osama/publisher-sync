package com.ahmed.publishersync.catalog;

import com.ahmed.publishersync.catalog.dto.BridgePublicationRequest;
import com.ahmed.publishersync.catalog.dto.BridgePublicationResponse;
import com.ahmed.publishersync.ecommerce.adapter.EcommerceCatalogClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogBridgeServiceImpl implements CatalogBridgeService {

    private final EcommerceCatalogClient ecommerceClient;

    public CatalogBridgeServiceImpl(EcommerceCatalogClient ecommerceClient) {
        this.ecommerceClient = ecommerceClient;
    }

    @Override
    public BridgePublicationResponse syncPublications(BridgePublicationRequest publication) {
        try{


                        ecommerceClient.pushPublication(publication);
                        return new BridgePublicationResponse(publication.isbn(), "SUCCESS");
                    } catch (Exception e) {
                        return new BridgePublicationResponse(publication.isbn(), "FAILED: " + e.getMessage());
                    }
    }
}
