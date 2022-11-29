package com.mka.springmvcspringboot.models;

import com.mka.springmvcspringboot.services.ProductIdService;
import com.mka.springmvcspringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ProductRepository {

    private ArrayList<Product> productList;
    private ProductService productService;
    private ProductIdService productIdService;

    @Autowired
    public ProductRepository(ArrayList<Product> productList, ProductService productService, ProductIdService productIdService) {
        this.productService = productService;
        this.productList = productList;
        this.productIdService = productIdService;
    }

    @PostConstruct
    private void initRepository() {
        productList.add(productService.createProduct("Ноутбук", 25000));
        productList.add(productService.createProduct("Книга", 1000));
        productList.add(productService.createProduct("Смартфон", 6000));
        productList.add(productService.createProduct("Гитара", 4000));
        productList.add(productService.createProduct("Телевизор", 12000));
    }

    public void addProduct(String title, int cost) {
        productList.add(productService.createProduct(title, cost));
    }

    public void addProduct(Product product) {
        product.setId(productIdService.giveId());
        productList.add(product);
    }

    public Product getProductById(int id) {
        return productList.stream()
                .filter(it -> Objects.equals(id, it.getId()))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProducts() {
        return productList;
    }
}
