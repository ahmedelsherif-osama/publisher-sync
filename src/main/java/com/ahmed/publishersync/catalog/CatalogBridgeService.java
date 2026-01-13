package com.ahmed.publishersync.catalog;

import com.ahmed.publishersync.catalog.dto.BridgePublicationRequest;
import com.ahmed.publishersync.catalog.dto.BridgePublicationResponse;

import java.util.List;

public interface CatalogBridgeService {
  BridgePublicationResponse syncPublications(BridgePublicationRequest publication);
}
