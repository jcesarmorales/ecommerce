package com.example.ecommerce.domains;

public class Product {
    private String id;
    private String decripcion;
    private double Precio;

    public Product(String id, String decripcion, double precio) {
        this.id = id;
        this.decripcion = decripcion;
        Precio = precio;
    }

    public String getId() {
        return id;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public double getPrecio() {
        return Precio;
    }
}
