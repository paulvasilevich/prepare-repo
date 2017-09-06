package com.belhard.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static List<Product> products = new ArrayList<>();

    static {
        for (int i = 0; i < 10 ; i++) {
            Product p = new Product();
            p.setName("name" + i);
            p.setPrice(i * 100);
            products.add(p);
        }
    }

}
