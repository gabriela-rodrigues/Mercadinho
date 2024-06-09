package com.example.Mercadinho.controller;

import com.example.Mercadinho.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("cart", productService.getCart());
        return "index";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam Long productId, Model model) {
        productService.addProductToCart(productId);
        model.addAttribute("message", "Produto adicionado ao carrinho!");
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("cart", productService.getCart());
        return "index";
    }

    @PostMapping("/remove-from-cart")
    public String removeFromCart(@RequestParam Long productId, Model model) {
        productService.removeProductFromCart(productId);
        model.addAttribute("message", "Produto removido do carrinho!");
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("cart", productService.getCart());
        return "index";
    }

    @PostMapping("/update-price")
    public String updatePrice(@RequestParam Long productId, @RequestParam double newPrice, Model model) {
        productService.updateProductPrice(productId, newPrice);
        model.addAttribute("message", "Preço do produto atualizado!");
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("cart", productService.getCart());
        return "index";
    }
}
