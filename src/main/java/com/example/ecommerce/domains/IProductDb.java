package com.example.ecommerce.domains;

public interface IProductDb {
    String create(Product product);
    Product read(String id);
    String update(Product updatedProduct);
    String delete(String id);
}
