package com.ahmed.publishersync.ecommerce.dto;

import java.util.UUID;

public record EcommerceOrderItemDto(
        UUID publicationId,
        int quantity
) {}
