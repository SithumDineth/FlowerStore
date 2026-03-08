package com.example.demo.Service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllFlowers() {
        return repository.findAll();
    }

    public Product getFlowerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Product saveFlower(Product flower) {
        return repository.save(flower);
    }

    public Product updateFlower(Long id, Product flower) {
    	Product existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(flower.getName());
            existing.setCategory(flower.getCategory());
            existing.setPrice(flower.getPrice());
            existing.setStock(flower.getStock());
            existing.setImageUrl(flower.getImageUrl());
            return repository.save(existing);
        }
        return null;
    }

    public void deleteFlower(Long id) {
        repository.deleteById(id);
    }
}