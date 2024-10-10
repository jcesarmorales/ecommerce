package com.example.ecommerce.domains;

import java.util.ArrayList;
import java.util.List;

public class MySqlDb implements IProductDb{
    private List<Product>products=new ArrayList<>();
    @Override
    public String create(Product producto) {
        products.add(producto);
        return "se ha creado el Producto en MySQL. ";
    }

    @Override
    public Product read(String id) {
        System.out.println("Extraido de la base de datos Mysql");
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public String update(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(updatedProduct.getId())) {
                products.set(i, updatedProduct);
                return("Producto actualizado en MySQL.");
            }
        }
        return("Producto no encontrado en MySQL.");
    }

    @Override
    public String delete(String id) {
        products.removeIf(p -> p.getId().equals(id));
        return ("Producto eliminado en MySQL.");
    }
}
