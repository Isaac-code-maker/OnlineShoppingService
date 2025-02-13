package com.programming_service.order_service.dto;

import java.math.BigDecimal;
import java.util.List;

import com.programming_service.order_service.models.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderLineItemsDto {

    private Long id;
    private String skuCode;
    private BigDecimal price;
    private int quantity;
    private List<OrderLineItems> orderLineItemsList;

}
