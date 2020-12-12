package com.cart;

import java.util.ArrayList;

public interface FilterInterface  //Filter class interface
{
    public void showFilteredResults(ArrayList<Cart> list,int choice);
    public void showRatingFilter(ArrayList<Cart> list);
    public void showPriceFilter(ArrayList<Cart> list);
}
