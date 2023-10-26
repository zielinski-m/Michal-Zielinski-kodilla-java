package com.kodilla.good.patterns.challenges.productOrderingService;

public class ProductServiceImpl implements ProductService {
    public boolean order(User user, Product product) {
        System.out.println("Ordering product: " + product.getName());
        System.out.println("User: " + user.getName());
        System.out.println("Product ordered successfully.");
        return true;
    }
}