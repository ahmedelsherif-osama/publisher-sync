package com.ahmed.publishersync.order;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sync")
public class OrderSyncController {

    private final OrderSyncService service;

    public OrderSyncController(OrderSyncService service) {
        this.service = service;
    }

    @PostMapping("/orders")
    public void syncOrders() {
        service.syncOrders();
    }
}
