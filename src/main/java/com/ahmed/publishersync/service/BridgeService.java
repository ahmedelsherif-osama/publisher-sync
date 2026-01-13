package com.ahmed.publishersync.service;

import com.ahmed.bridge.dto.CartItemRequest;
import com.ahmed.bridge.dto.CreateShopOrderRequest;
import com.ahmed.publisher.erp.dto.CreateOrderItemRequest;
import com.ahmed.publisher.erp.dto.CreateOrderRequest;
import com.ahmed.publisher.erp.dto.OrderDto;
import com.ahmed.publisher.erp.dto.ProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BridgeService {

    private final RestTemplate restTemplate;
    private static final String ERP_BASE = "http://localhost:8080/api"; // ERP base URL

    public BridgeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductDto> listProducts() {
        ProductDto[] products = restTemplate.getForObject(ERP_BASE + "/products", ProductDto[].class);
        return Arrays.asList(products);
    }

    public ProductDto getProductById(UUID id) {
        return restTemplate.getForObject(ERP_BASE + "/products/" + id, ProductDto.class);
    }

    public OrderDto checkout(CreateShopOrderRequest request) {
        List<CreateOrderItemRequest> erpItems = request.items().stream()
                .map(i -> new CreateOrderItemRequest(i.productId(), i.quantity()))
                .collect(Collectors.toList());

        CreateOrderRequest erpOrderRequest = new CreateOrderRequest(erpItems);

        return restTemplate.postForObject(ERP_BASE + "/orders", erpOrderRequest, OrderDto.class);
    }
}
