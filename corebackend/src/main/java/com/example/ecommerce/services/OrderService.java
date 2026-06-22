package com.example.ecommerce.services;

import com.example.ecommerce.entities.Order;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fetch Error: Order not found"));
    }

    public List<Order> getOrdersByUser(Long userId){
        return orderRepository.findByUser(userId);
    }

    public Order updateOrderStatus(Long id, Order.Status status){
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fetch Error: Order not found"));

        existingOrder.setStatus(status);

        return orderRepository.save(existingOrder);
    }

    public Order cancelOrder(Long id){
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fetch Error: Order not found"));

        existingOrder.setStatus(Order.Status.CANCELLED);
        return orderRepository.save(existingOrder);
    }

}

//createOrder()
//getOrderById()
//getOrdersByUser()
//updateOrderStatus()
//cancelOrder()

