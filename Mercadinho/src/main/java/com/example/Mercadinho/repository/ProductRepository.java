package com.example.Mercadinho.repository;

import com.example.Mercadinho.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    private List<Product> cart = new ArrayList<>();

    public ProductRepository() {
        // Adiciona alguns produtos de exemplo
        products.add(new Product(1L, "Produto 1", "Descrição do Produto 1", 10.0));
        products.add(new Product(2L, "Produto 2", "Descrição do Produto 2", 20.0));
        products.add(new Product(3L, "Produto 3", "Descrição do Produto 3", 30.0));
        products.add(new Product(4L, "Produto 4", "Descrição do Produto 4", 40.0));
    }

    public List<Product> findAll() {
        return products;
    }

    public List<Product> findCart() {
        return cart;
    }

    public void addToCart(Long productId) {
        products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .ifPresent(cart::add);
    }

    public void removeFromCart(Long productId) {
        cart.removeIf(product -> product.getId().equals(productId));
    }

    public void updateProduct(Long productId, double newPrice) {
        products.stream()
                .filter(product -> product.getId().equals(productId))
                .forEach(product -> product.setPrice(newPrice));
        
        cart.stream()
                .filter(product -> product.getId().equals(productId))
                .forEach(product -> product.setPrice(newPrice));
    }
}
