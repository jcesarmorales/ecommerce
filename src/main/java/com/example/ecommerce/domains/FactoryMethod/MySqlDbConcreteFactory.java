package com.example.ecommerce.domains.FactoryMethod;

import com.example.ecommerce.domains.IProductDb;
import com.example.ecommerce.domains.MySqlDb;

public class MySqlDbConcreteFactory extends IProductDbAbstractFactory {
    @Override
    public IProductDb createProductDb() {
        return new MySqlDb();
    }
}
