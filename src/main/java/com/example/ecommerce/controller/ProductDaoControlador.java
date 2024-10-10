package com.example.ecommerce.controller;

import com.example.ecommerce.domains.IProductDb;
import com.example.ecommerce.domains.Product;
import com.example.ecommerce.domains.SimpleFactory.ConfiguracionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductDaoControlador {

    private IProductDb productDb;

    // Constructor por defecto con una base de datos predefinida
    public ProductDaoControlador() {
        ConfiguracionFactory configuracionFactory = new ConfiguracionFactory();
        this.productDb = configuracionFactory.Configurar("mysql"); // Configuración inicial por defecto
    }

    // Endpoint para configurar la base de datos (Ej: /api/configurarDB/mysql)
    @GetMapping("/configurarDB/{DB}")
    public ResponseEntity<String> configurarBaseDeDatos(@PathVariable String DB) {
        ConfiguracionFactory configuracionFactory = new ConfiguracionFactory();
        this.productDb = configuracionFactory.Configurar(DB); // Cambiar la configuración de la base de datos
        return new ResponseEntity<>("Base de datos configurada a: " + DB, HttpStatus.OK);
    }

    // Crear un nuevo producto (POST)
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        String response = productDb.create(product);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Obtener un producto por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = productDb.read(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un producto (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        Product product = productDb.read(id);
        if (product != null) {
            updatedProduct = new Product(id, updatedProduct.getDecripcion(), updatedProduct.getPrecio());
            String response = productDb.update(updatedProduct);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un producto (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        Product product = productDb.read(id);
        if (product != null) {
            String response = productDb.delete(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
