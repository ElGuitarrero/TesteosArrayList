package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Mall {
    ArrayList<Tienda> tienda;
    ArrayList<Producto> prods;
    Scanner sc = new Scanner(System.in);

    public Mall(ArrayList<Tienda> tienda, ArrayList<Producto> prods) {
        this.tienda = tienda;
        this.prods = prods;
    }


    public void newMall(){

    }


    public void menu(){
        System.out.println("\n------------------------------------------");
        System.out.println("Welcome to El Bicho mall online store");
        System.out.println("Select what you want to do");

        System.out.println("1.- Search stores by product name");
        System.out.println("2.- Search stores by store name");
        System.out.println("0.- Exit");
    }


    public void searchByStoreName()
    {
        System.out.println("What store are you searching for: ");
        for (Tienda i : tienda){
            System.out.println("*** "+ i.getName() + " ***");
        }
        boolean done = false;
        String search = sc.nextLine();
        search = search.toLowerCase(Locale.ROOT);
        System.out.println("------------------------------------------------");
        System.out.println("*** We are searching " + search.toUpperCase() + " located within our mall *** \n------------------------------------------------");
        System.out.println("Store ID  |   Store name  |   Floor   |   Asset Value");
        System.out.println("------------------------------------------------");
        for (Tienda i : this.tienda){
            if(search.equals(i.getName().toLowerCase(Locale.ROOT)))
            {

                System.out.println("   " + i.getStoreID() + "      |   " + i.getName() + "     |    " + i.getFloor() + "      |     $"+ i.getAssetValue());
                done = true;
            }

        }
        if (!done)
        {
            System.out.println("Please enter a valid value, returning to the main menu.");
        }

    }

    public void searchByProductName()
    {
        System.out.println("What are you searching for: ");

        for (Producto i : prods){
            System.out.println("*** "+ i.getName() + " ***");
        }

        String search = sc.nextLine();
        search = search.toLowerCase(Locale.ROOT);

        System.out.println("------------------------------------------");
        System.out.println("*** We have " + search.toUpperCase() + " on these stores *** \n------------------------------------------");
        System.out.println("Store ID  |   Store name  |   Stock   |   Price");
        System.out.println("------------------------------------------");
        boolean done = false;


        for (Tienda i : this.tienda){
            for(Producto k : prods)
            {
                if(search.equals(k.getName().toLowerCase(Locale.ROOT)))
                {
                    if(i.getQuantity(search) != 0)
                    {
                        System.out.println("   " + i.getStoreID() + "      |   " + i.getName() + "     |    " + i.getQuantity(search) + "     |   $" + i.getProductPrice(search));
                        done = true;
                    }
                }
            }
        }

        if (!done)
        {
            System.out.println("Please enter a valid value, returning to the main menu.");
        }

    }
}
