package com.example.demo.Controller;


import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.Model.*;
import com.example.demo.Repository.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    // Constructor injection
    public CartController(CartRepository cartRepository,
                          UserRepository userRepository,
                          ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    // Add to cart
    @PostMapping("/{userId}/{productId}")
    public Cart addToCart(@PathVariable Long userId,
                              @PathVariable Long productId) {
        User user = userRepository.findById(userId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();

        Cart item = new Cart();
        item.setUser(user);
        item.setProduct(product);
        item.setQuantity(1);

        return cartRepository.save(item);
    }

    // View user's cart
    @GetMapping("/{userId}")
    public List<Cart> viewCart(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return cartRepository.findByUser(user);
    }

    // Remove item from cart
    @DeleteMapping("/{cartId}")
    public void removeFromCart(@PathVariable Long cartId) {
        cartRepository.deleteById(cartId);
    }
}

