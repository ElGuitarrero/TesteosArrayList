package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Tienda {
    String name;
    int storeID;
    int floor;
    String location;
    HashMap<Producto, Integer> inventario;

    public Tienda(String name, int storeID, int floor, String location, HashMap<Producto, Integer> inventario) {
        this.name = name;
        this.storeID = storeID;
        this.floor = floor;
        this.location = location;
        this.inventario = inventario;
    }



    //    Getters
    public String getName() {
        return name;
    }

    public int getStoreID() {
        return storeID;
    }

    public int getFloor() {
        return floor;
    }

    //Metodos

    public Integer getQuantity(String search){
        for (Producto i : this.inventario.keySet())
        {
            if(i.getName().toLowerCase(Locale.ROOT).equals(search.toLowerCase(Locale.ROOT)))
            {
                return inventario.get(i);
            }
        }
        return null;
    }

    public double getAssetValue()
    {
        double sumatoria = 0;
        for (Producto i : inventario.keySet())
        {
            //System.out.println("key: " + i.getName() + " value: " + inventario.get(i));
            sumatoria += i.price * inventario.get(i);
        }

        return sumatoria;
    }

    public String getProductName(String search)
    {
        for (Producto i : this.inventario.keySet())
        {
            if (search.toLowerCase(Locale.ROOT).equals(i.getName().toLowerCase(Locale.ROOT)))
            {
                return i.getName();
            }
        }
        return "Invalid product";
    }

    public double getProductPrice(String search)
    {
        for (Producto i : this.inventario.keySet())
        {
            if (search.toLowerCase(Locale.ROOT).equals(i.getName().toLowerCase(Locale.ROOT)))
            {
                return i.getPrice();
            }
        }
        return 0;
    }


    public static HashMap<Producto, Integer> changeInventory(ArrayList<Producto> produs, int[] qtys)
    {
        HashMap<Producto, Integer> inventa = new HashMap<>();
        if (produs.size() == qtys.length)
        {
            for (int i = 0; i < produs.size(); i++)
            {
                inventa.put(produs.get(i), qtys[i]);
            }
            return inventa;
        }
        else
        {
            System.out.println("Invalid length of array");
        }

        return inventa;
    }
}
