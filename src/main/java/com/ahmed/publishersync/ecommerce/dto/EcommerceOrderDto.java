package com.ahmed.publishersync.ecommerce.dto;

import java.util.List;
import java.util.UUID;

public record EcommerceOrderDto(
        UUID externalOrderId,
        List<EcommerceOrderItemDto> items,
        String source
) {}
