package com.ahmed.publishersync.catalog.dto;

import java.math.BigDecimal;

public record BridgeVariantRequest(
        String sku,
        BigDecimal price,
        int stockCount,
        String attributes
) {}
