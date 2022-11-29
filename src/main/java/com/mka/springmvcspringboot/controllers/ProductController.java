package com.mka.springmvcspringboot.controllers;

import com.mka.springmvcspringboot.models.Product;
import com.mka.springmvcspringboot.models.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    public String getProducts(Model model) {
        model.addAttribute("products", productRepository.getProducts());
        return "products";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getProductById(@PathVariable int id) {
        return productRepository.getProductById(id).toString();
    }

    @GetMapping("/add_product_to_repo")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProductToRepo";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") Product product) {
        productRepository.addProduct(product);
        return "redirect:/products";
    }
}
