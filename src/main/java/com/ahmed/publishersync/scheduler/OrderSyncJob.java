package com.ahmed.publishersync.scheduler;

import com.ahmed.publishersync.order.OrderSyncService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderSyncJob {

    private final OrderSyncService orderSyncService;

    public OrderSyncJob(OrderSyncService orderSyncService) {
        this.orderSyncService = orderSyncService;
    }

    @Scheduled(fixedDelay = 60000) // every 60 seconds
    public void sync() {
        orderSyncService.syncOrders();
    }
}
