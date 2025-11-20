package com.ahmed.publishersync.dto;

import java.util.List;
import java.util.UUID;

public record CartItemRequest(UUID productId, int quantity) {}
