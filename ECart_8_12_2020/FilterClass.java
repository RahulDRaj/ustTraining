package com.cart;

import java.util.ArrayList;
import java.util.Comparator;

public class FilterClass implements FilterInterface
{
    public void showFilteredResults(ArrayList<Cart> list,int choice) //Prints filtered results
    {
        System.out.println("-----------------Filtered Results---------------------");
        switch (choice)
        {
            case 1:
                showPriceFilter(list);
                break;
            case 2:
                showRatingFilter(list);
                break;
        }

    }

    public void showRatingFilter(ArrayList<Cart> list) //Filter by Rating
    {
        list.stream()
                .sorted(Comparator.comparing(Cart::getRating).reversed())
                .peek(m -> System.out.print("Title: " + m.getTitle()))
                .forEach(n -> System.out.println(" Rating: " + n.getRating()));
    }

    public void showPriceFilter(ArrayList<Cart> list) //Filter by Price
    {
        list.stream()
                .sorted(Comparator.comparing(Cart::getPrice).reversed())
                .peek(m -> System.out.print("Title: " + m.getTitle()))
                .forEach(n -> System.out.println(" Price: " + n.getPrice()));
    }

}
