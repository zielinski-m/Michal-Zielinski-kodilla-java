package com.kodilla.good.patterns.challenges.productOrderingService;

public class ServiceRun {

    public static void main(String[] args) {

        InformationService informationService = new MailInformationService();
        ProductService productService = new ProductServiceImpl();
        OrderRepository orderRepository = new OrderRepositoryImpl();

        ProductOrderService productOrderService = new ProductOrderService(informationService, productService, orderRepository);

        User user = new User("John", "john@gmail.com");
        Product product = new Product("The_Witcher_4");

        OrderRequest orderRequest = new OrderRequest(user, product);

        OrderDto orderDto = productOrderService.process(orderRequest);

        System.out.println("Order processed:");
        System.out.println("User: " + orderDto.getUser().getName());
        System.out.println("Product: " + orderDto.getProduct().getName());
        System.out.println("Success: " + orderDto.isSuccess());
    }
}

