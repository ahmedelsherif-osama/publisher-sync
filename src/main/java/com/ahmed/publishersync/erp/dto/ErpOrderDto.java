package com.ahmed.publishersync.erp.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ErpOrderDto(
        UUID id,
        UUID userId,
        List<ErpOrderItemDto> items,
        String status,
        LocalDateTime createdAt
) {}
