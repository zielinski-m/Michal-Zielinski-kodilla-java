package com.kodilla.good.patterns.challenges.productOrderingService;

public class ProductOrderService {
    private InformationService informationService;
    private ProductService productService;
    private OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService,
                               final ProductService productService,
                               final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.productService = productService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered = productService.order(orderRequest.getUser(), orderRequest.getProduct());

        if (isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), false);
        }
    }
}
