package com.programservices.micro_services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.programservices.micro_services.dto.ProductRequest;
import com.programservices.micro_services.dto.ProductResponse;
import com.programservices.micro_services.model.Product;
import com.programservices.micro_services.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// Anotação para indicar que esta classe é um serviço do Spring
@Service
// Anotação Lombok para gerar um construtor com argumentos para todos os campos finais
@RequiredArgsConstructor
// Anotação Lombok para habilitar o registro de logs na classe
@Slf4j
public class ProductService {

    // Repositório de produtos, injetado automaticamente pelo Spring
    private final ProductRepository productRepository;
    
    // Método para criar um novo produto a partir de um ProductRequest
    public void createProduct(ProductRequest productRequest){
        // Cria um novo objeto Product usando o padrão Builder
        Product product = Product.builder()
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .price(productRequest.getPrice())
            .build();

        // Salva o produto no repositório
        productRepository.save(product);
        // Registra uma mensagem de log indicando que o produto foi criado
        log.info("Product {} created", product.getId());
    }

    // Método para obter todos os produtos
    public List<ProductResponse> getAllProducts() {
        // Busca todos os produtos no repositório
        List<Product> products = productRepository.findAll();

        // Converte a lista de produtos para uma lista de ProductResponse e a retorna
        return products.stream().map(this::mapToProductResponse).toList(); 
    }

    // Método privado para mapear um objeto Product para um ProductResponse
    private ProductResponse mapToProductResponse(Product product){
        // Cria um novo objeto ProductResponse usando o padrão Builder
        return ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .build();
    }
}
