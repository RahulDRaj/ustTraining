package com.cart;

import java.util.ArrayList;

public class CreateFilter
{
    public void showResults(ArrayList<Cart> list, int choice) //Filter Interface Implementation
    {

        FilterInterface filter= new FilterClass();
        filter.showFilteredResults(list,choice);
        System.out.println("------------------------------------");

    }
}
