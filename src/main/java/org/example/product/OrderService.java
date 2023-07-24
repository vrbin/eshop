package org.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderJpaRepository orderJpaRepository;

    public void addOrder(Order order) {
        orderJpaRepository.save(order);
    }
    public List<Order> getOrders() {
        return orderJpaRepository.findAll();
    }

}
