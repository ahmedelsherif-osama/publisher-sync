package com.ahmed.publishersync.erp.dto;

import java.util.UUID;

public record ErpOrderItemDto(
        UUID publicationId,
        int quantity
) {}
