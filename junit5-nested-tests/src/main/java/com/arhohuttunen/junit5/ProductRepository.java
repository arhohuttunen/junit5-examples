package com.arhohuttunen.junit5;

public interface ProductRepository {
    Product findById(Long id);
    void save(Product product);
    void deleteById(Long id);
}
