package com.ahmed.publishersync.order;

import com.ahmed.publishersync.ecommerce.dto.EcommerceOrderDto;
import com.ahmed.publishersync.ecommerce.dto.EcommerceOrderItemDto;
import com.ahmed.publishersync.erp.dto.ErpOrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public EcommerceOrderDto toEcommerce(ErpOrderDto erp) {
        return new EcommerceOrderDto(
                erp.id(),
                erp.items().stream()
                        .map(i -> new EcommerceOrderItemDto(
                                i.publicationId(),
                                i.quantity()
                        ))
                        .toList(),
                "ERP"
        );
    }
}
