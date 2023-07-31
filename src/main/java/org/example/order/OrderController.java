package org.example.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }
    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable long id) {
        return(orderService.getOrderById(id));
    }
    @PostMapping("/orders")
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body("Objednavka zadana...");
    }
}
