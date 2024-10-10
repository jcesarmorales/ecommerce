package com.example.ecommerce.domains;

import java.util.HashMap;
import java.util.Map;

public class OracleDB implements IProductDb {
    private Map<String,Product>products=new HashMap<>();

    @Override
    public String create(Product product) {
        products.put(product.getId(), product);
        return ("Producto guardado en Oracle.");
    }

    @Override
    public Product read(String id) {
        System.out.println("Extraido de la base de datos Oracle");
        return products.get(id);
    }

    @Override
    public String update(Product updatedProduct) {
        if (products.containsKey(updatedProduct.getId())) {
            products.put(updatedProduct.getId(), updatedProduct);
            return ("Producto actualizado en Oracle.");
        } else {
            return ("Producto no encontrado en Oracle.");
        }
    }

    @Override
    public String delete(String id) {
        products.remove(id);
        return ("Producto eliminado en Oracle.");
    }
}
