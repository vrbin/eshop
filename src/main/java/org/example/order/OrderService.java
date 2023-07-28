package org.example.order;

import org.example.exception.OrderNotFoundException;
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
    public Order getOrderById(long id) {
        return orderJpaRepository.findById(id).orElseThrow(
                () -> new OrderNotFoundException(String.format("Objednavka s %id nenalezena.", id))
        );
    }

}
