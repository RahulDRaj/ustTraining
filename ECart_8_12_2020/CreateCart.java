package com.cart;

import java.util.ArrayList;

//decoupled class
public class CreateCart
{

    public ArrayList<Cart> createNewCart()  //Implementation of Cart list
    {
        ListInterface list= new CreateCartList();
        return list.createList();
    }
}
