package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Producto {
    String name;
    int productID;
    double price;

    public Producto(String name, int productID, double price) {
        this.name = name;
        this.productID = productID;
        this.price = price;
    }

    //    Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
