package com.ahmed.publishersync.inventory.dto;

import java.util.UUID;

public record InventoryCheckRequest(
        UUID variantId,
        int quantity
) {}
