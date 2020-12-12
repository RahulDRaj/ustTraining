package com.cart;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
      ArrayList<Cart> list= new CreateCart().createNewCart();    //Getting items details

       int choice = (int)InputData.getNumber("Enter 1 to sort by Price \nEnter 2 to sort by Rating",1,2);

        CreateFilter filter = new CreateFilter();       // To filter by Price or Rating
       filter.showResults(list,choice);



    }
}

