package com.programming_service.order_service.models;

// Importações necessárias para a classe
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "orders")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
public class Order {

    // Anotação para indicar que este campo é o identificador do documento no MongoDB
    @Id
    private String id;

    // Campo para armazenar o número do pedido
    private String orderNumber;

    // Campo para armazenar a lista de itens do pedido
    private List<OrderLineItems> orderLineItems;
}