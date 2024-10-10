package com.example.ecommerce.domains.SimpleFactory;

import com.example.ecommerce.domains.FactoryMethod.IProductDbAbstractFactory;
import com.example.ecommerce.domains.FactoryMethod.MySqlDbConcreteFactory;
import com.example.ecommerce.domains.FactoryMethod.OracleDbConcreteFactory;
import com.example.ecommerce.domains.IProductDb;


public class ConfiguracionFactory {

    public IProductDb Configurar(String DB) {
        IProductDbAbstractFactory factory;

        switch (DB.toLowerCase()) {
            case "mysql":
                factory = new MySqlDbConcreteFactory();
                break;
            case "oracle":
                factory = new OracleDbConcreteFactory();
                break;
            default:
                throw new IllegalArgumentException("Tipo de base de datos no soportada: " + DB);
        }

        return factory.createProductDb();
    }
}
