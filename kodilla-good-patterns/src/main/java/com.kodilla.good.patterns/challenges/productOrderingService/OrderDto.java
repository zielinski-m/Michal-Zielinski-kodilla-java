package com.kodilla.good.patterns.challenges.productOrderingService;

public class OrderDto {
    private User user;
    private Product product;
    private boolean success;

    public OrderDto(User user, Product product, boolean success) {
        this.user = user;
        this.product = product;
        this.success = success;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isSuccess() {
        return success;
    }
}
