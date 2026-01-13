package com.ahmed.publishersync.controller;

import com.ahmed.bridge.dto.CreateShopOrderRequest;
import com.ahmed.publisher.erp.dto.OrderDto;
import com.ahmed.publisher.erp.dto.ProductDto;
import com.ahmed.bridge.service.BridgeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shop")
public class BridgeController {

    private final BridgeService bridgeService;

    public BridgeController(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    @GetMapping("/products")
    public List<ProductDto> listProducts() {
        return bridgeService.listProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDto getProduct(@PathVariable UUID id) {
        return bridgeService.getProductById(id);
    }

    @PostMapping("/checkout")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto checkout(@RequestBody CreateShopOrderRequest request) {
        return bridgeService.checkout(request);
    }
}
