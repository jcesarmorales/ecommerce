package com.example.ecommerce.domains.FactoryMethod;

import com.example.ecommerce.domains.IProductDb;
import com.example.ecommerce.domains.OracleDB;

public class OracleDbConcreteFactory extends IProductDbAbstractFactory {
    @Override
    public IProductDb createProductDb() {
        return new OracleDB();
    }
}
