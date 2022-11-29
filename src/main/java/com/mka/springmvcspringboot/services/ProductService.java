package com.mka.springmvcspringboot.services;

import com.mka.springmvcspringboot.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    private ProductIdService productIdService;

    @Autowired
    public ProductService(ProductIdService productIdService) {
        this.productIdService = productIdService;
    }

    public Product createProduct(String title, int cost) {
        Product product = new Product(title, cost);
        product.setId(productIdService.giveId());
        return product;
    }
}
