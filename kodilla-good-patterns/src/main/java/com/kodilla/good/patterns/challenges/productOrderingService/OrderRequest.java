package com.kodilla.good.patterns.challenges.productOrderingService;

public class OrderRequest {
    private User user;
    private Product product;

    public OrderRequest(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }
}
