package com.cart;

public class Cart
{
    private String title;
    private String brand;
    private float price;
    private byte rating;

    public Cart(String title, String brand, float price, byte rating) //Constructor
    {
        this.title = title;
        this.brand = brand;
        this.price = price;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }
}
