package com.example.Mercadinho.service;

import com.example.Mercadinho.model.Product;
import com.example.Mercadinho.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getCart() {
        return productRepository.findCart();
    }

    public void addProductToCart(Long productId) {
        productRepository.addToCart(productId);
    }

    public void removeProductFromCart(Long productId) {
        productRepository.removeFromCart(productId);
    }

    public void updateProductPrice(Long productId, double newPrice) {
        productRepository.updateProduct(productId, newPrice);
    }
}
