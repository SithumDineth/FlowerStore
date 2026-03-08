package com.example.demo.Controller;


import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    private final ProductRepository productRepository;

    // Constructor injection
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Create new product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Update existing product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product p) {
        Product existing = productRepository.findById(id).orElseThrow();
        existing.setName(p.getName());
        existing.setCategory(p.getCategory());
        existing.setPrice(p.getPrice());
        existing.setStock(p.getStock());
        existing.setImageUrl(p.getImageUrl());
        return productRepository.save(existing);
    }

    // Delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}

