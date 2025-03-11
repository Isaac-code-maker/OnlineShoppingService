package com.programming_service.order_service.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programming_service.order_service.dto.OrderLineItemsDto;
import com.programming_service.order_service.dto.OrderRequest;
import com.programming_service.order_service.models.Order;
import com.programming_service.order_service.models.OrderLineItems;
import com.programming_service.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

// Anotação para indicar que esta classe é um serviço do Spring
@Service
// Anotação Lombok para gerar um construtor com argumentos para todos os campos finais
@RequiredArgsConstructor
@Transactional
public class OrderServices {
    
    // Repositório de pedidos, injetado automaticamente pelo Spring
    private final OrderRepository orderRepository;

    // Método para criar um novo pedido a partir de um OrderRequest
    public void placeOrder(OrderRequest orderRequest) {
        
        // Cria um novo objeto Order
        Order order = new Order();
        // Gera um número de pedido único usando UUID
        order.setOrderNumber(UUID.randomUUID().toString());

        // Converte a lista de OrderLineItemsDto para uma lista de OrderLineItems
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
        // Define a lista de itens do pedido no objeto Order
        order.setOrderLineItems(orderLineItems);
        // Salva o pedido no repositório
        orderRepository.save(order); 
    }

    // Método privado para mapear um objeto OrderLineItemsDto para um OrderLineItems
    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        // Cria um novo objeto OrderLineItems
        OrderLineItems orderLineItems = new OrderLineItems();
        // Define os campos do objeto OrderLineItems com base no objeto OrderLineItemsDto
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        // Retorna o objeto OrderLineItems
        return orderLineItems;
    }
}
