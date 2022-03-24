package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //We create the products
        ArrayList<Producto> prods = new ArrayList<>();
        prods.add(new Producto("Tomate", 1, 13.99));
        prods.add(new Producto("Zanahoria", 2, 20.99));
        prods.add(new Producto("Manzana", 3, 14.99));

        //Creamos las tiendas
        ArrayList<Tienda> tienda = new ArrayList<>();
        tienda.add(new Tienda("Aurrera",1,1,"Colima", Tienda.changeInventory(prods, new int[]{10, 30, 0})));
        tienda.add(new Tienda("Walmart",2,3,"Colima", Tienda.changeInventory(prods, new int[]{0, 24, 15})));
        tienda.add(new Tienda("Soriana",3,2,"Colima", Tienda.changeInventory(prods, new int[]{21, 55, 20})));

        //We create the mall
        Mall mall = new Mall(tienda,prods);

        int opcion = 0;
        do {

            mall.menu();


            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> mall.searchByProductName();
                case 2 -> mall.searchByStoreName();
            }

        }
        while (opcion!=0);

    }

}