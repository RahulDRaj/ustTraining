package com.cart;

import java.util.ArrayList;


public class CreateCartList implements ListInterface{
    public ArrayList<Cart> createList()  // Creates and returns items in the cart
    {
        ArrayList<Cart> list = new ArrayList<Cart>();

        String title;
        String brand;
        byte rating;
        float price;
        Cart cart;

        int num=(int)InputData.getNumber("Enter the number of items to be listed (Max 5)",1,5);
        for(int i=0;i<num;i++)
        {
            System.out.println("-----------------------------------");
            System.out.println("Item "+(i+1)+" Details:");
            title=InputData.getString("Enter title");
            brand=InputData.getString("Enter brand");
            price=InputData.getNumber("Enter Price");
            rating=(byte)InputData.getNumber("Enter rating (1-5) ",1,5);
            cart=new Cart(title,brand,price,rating);
            list.add(cart);
        }
        return list;
    }
}
