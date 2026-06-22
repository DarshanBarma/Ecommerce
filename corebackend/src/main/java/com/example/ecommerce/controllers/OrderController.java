package com.example.ecommerce.controllers;

import com.example.ecommerce.entities.Order;
import com.example.ecommerce.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrderByUser(@PathVariable Long userId){
        return  orderService.getOrdersByUser(userId);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @PatchMapping("/{id}/status")
    public Order updateOrderStatus(@PathVariable Long id, @RequestParam Order.Status status){
        return orderService.updateOrderStatus(id, status);
    }

    @PatchMapping("/{id}/cancel")
    public Order cancelOrder(@PathVariable Long id){
        return orderService.cancelOrder(id);
    }

}

//POST   /orders
//GET    /orders/{id}
//GET    /orders/user/{userId}
//PATCH  /orders/{id}/status
//PATCH  /orders/{id}/cancel
