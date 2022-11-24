package org.example;

public class Item {
    private String name;
    private int price;
    private int weight;

    public Item(String name,int weight,int price){
        this.name=name;
        this.price=price;
        this.weight=weight;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name +" с ценой "+ price +"\t"+"и весом "+ weight+"\n";
    }
}
