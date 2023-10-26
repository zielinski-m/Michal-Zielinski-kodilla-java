package com.kodilla.good.patterns.challenges.productOrderingService;

public class OrderRepositoryImpl implements OrderRepository {
    public void createOrder(User user, Product product) {
        System.out.println("User: " + user.getName());
        System.out.println("Product: " + product.getName());
        System.out.println("Order of: " + user.getName() + " created successfully.");
    }
}