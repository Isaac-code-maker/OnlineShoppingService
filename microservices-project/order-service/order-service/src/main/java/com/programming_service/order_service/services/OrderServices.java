package com.programming_service.order_service.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.programming_service.order_service.dto.OrderLineItemsDto;
import com.programming_service.order_service.dto.OrderRequest;
import com.programming_service.order_service.models.Order;
import com.programming_service.order_service.models.OrderLineItems;
import com.programming_service.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServices {
    
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        
        Order order = new Order();

        order.setOrderNumber(UUID.randomUUID().toString());

                List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItems(orderLineItems);
       orderRepository.save(order); 
         
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {

        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;
    }
}
