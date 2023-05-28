package com.kodilla.good.patterns.challenges.productOrderingService;

public interface OrderRepository {
    void createOrder(User user, Product product);
}
