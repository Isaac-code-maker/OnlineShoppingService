package com.programming_service.order_service.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsDto {
    // Campo para armazenar o código SKU do item (Stock Keeping Unit)
    private String skuCode;
    // Campo para armazenar o preço do item
    private BigDecimal price;
    // Campo para armazenar a quantidade do item
    private int quantity;
}
