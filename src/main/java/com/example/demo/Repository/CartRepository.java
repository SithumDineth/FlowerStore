package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.Model.*;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser(User user);
}