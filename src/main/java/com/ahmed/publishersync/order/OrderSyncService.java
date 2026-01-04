package com.ahmed.publishersync.order;

import com.ahmed.publishersync.ecommerce.adapter.EcommerceOrderClient;
import com.ahmed.publishersync.ecommerce.dto.EcommerceOrderDto;
import com.ahmed.publishersync.erp.adapter.ErpOrderClient;
import com.ahmed.publishersync.erp.dto.ErpOrderDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderSyncService {

    private final ErpOrderClient erpClient;
    private final EcommerceOrderClient ecommerceClient;
    private final OrderMapper mapper;

    public OrderSyncService(
            ErpOrderClient erpClient,
            EcommerceOrderClient ecommerceClient,
            OrderMapper mapper
    ) {
        this.erpClient = erpClient;
        this.ecommerceClient = ecommerceClient;
        this.mapper = mapper;
    }

    @Transactional
    public void syncOrders() {
        List<ErpOrderDto> orders = erpClient.fetchNewOrders();

        for (ErpOrderDto erpOrder : orders) {
            EcommerceOrderDto ecommerceOrder =
                    mapper.toEcommerce(erpOrder);

            ecommerceClient.pushOrder(ecommerceOrder);
        }
    }
}
