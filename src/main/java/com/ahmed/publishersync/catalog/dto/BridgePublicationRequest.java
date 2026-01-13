package com.ahmed.publishersync.catalog.dto;

import java.math.BigDecimal;
import java.util.List;

public record BridgePublicationRequest(
        String title,
        String isbn,
        String author,
        BigDecimal price,
        List<BridgeVariantRequest> variants
) {}
