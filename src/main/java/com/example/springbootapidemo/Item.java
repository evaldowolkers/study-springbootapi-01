package com.example.springbootapidemo;

public class Item {

    private final long id;
    private String name;
    private double price;
    private int count;

    public Item(long id, String name, double price, int count){
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }   

    public void setPrice(double price) {
        this.price = price;
    }
    
}
