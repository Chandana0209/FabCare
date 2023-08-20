package com.example.foodex;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<ItemList> item;
    @Override
    public void onCreate() {
        super.onCreate();
        item=new ArrayList<ItemList>();
        item.add(new ItemList("Dress","28","dress"));
        item.add(new ItemList("Formal","22","formal"));
        item.add(new ItemList("Hoodie","28","hoodie"));
        item.add(new ItemList("Jeans","24","jeans"));
        item.add(new ItemList("Jumpsuit","22","jumpsuit"));
        item.add(new ItemList("Skirt","26","skirt"));
        item.add(new ItemList("Sportswear","28","sportwear"));
        item.add(new ItemList("Traditional","25","traditional"));
        item.add(new ItemList("T-shirt","27","tshirt"));
        item.add(new ItemList("Western Wear","28","westernwear"));




    }
}
