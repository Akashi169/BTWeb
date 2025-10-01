package com.example.bt9.service;

import java.util.List;

import com.example.bt9.entity.Product;

public interface ProductServices {
    void delete(Long id);
    Product get(Long id);
    Product save(Product product);
    List<Product> listAll();
}
