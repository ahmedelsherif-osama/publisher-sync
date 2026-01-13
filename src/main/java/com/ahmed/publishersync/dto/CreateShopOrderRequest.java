package com.ahmed.publishersync.dto;

import java.util.List;

public record CreateShopOrderRequest(List<CartItemRequest> items) {}
