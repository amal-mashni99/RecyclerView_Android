package com.cs.foodapp;

import java.util.ArrayList;

public class Food {

    private String img;
    private String name;
    private String description;
    private int price;
  static ArrayList<Food> foods = new ArrayList<>();

    public Food(String img, String name, String description, int price) {
        this.img = img;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Food() {

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    /*private static Food [] food={
            new Food(R.drawable.img1,"Cheese Sandwich","Cheese,Tomato,Cucumber,Lettuce,Basil,Pesto Sauce",16),
         new Food(R.drawable.img2,"Avocado Sandwich","Avocado, Cucumber, Tomato, Mushroom, Lettuce, Fitafe Sauce",16),
         new Food(R.drawable.img3,"Smoked Salmon Sandwich","Greek Yogurt, Salmon, Augula,Tomato, Purple Onion",30),
         new Food(R.drawable.img4,"Sunrise Salad","Lettuce, Tomato, Carrots, Corn, Cucumber 2 Boiled eggs, Sweet potato, Greek yogurt, Lemon, Sunflower seeds oil olive",25),
         new Food(R.drawable.img5,"Sweet Complete","Lettuce, Tomato, Carrots, Corn, Cucumber, Apple , Sweet potato, Purple Onions, Walnuts, Cranberry, lemon Olive Oil, Tahini, Low Fat Cheese",32),
         new Food(R.drawable.img6,"Side Salad","Lettuce, Tomato, Cucumber, Bell Pepper",8),
         new Food(R.drawable.img7,"Sesame Chicken Salad","Lettuce, Cabbage, Tomato, Chcicken, Cucumber, Cooked Bell Pepper and Onion Sesame Soy Sauce, lemon Olive Oil",30),
         new Food(R.drawable.img8,"Crazy Tabouleh","Lettuce, Parsley, Apple, lentils, Quinoa, Pomegranate, Walnuts, Cranberry",20),
         new Food(R.drawable.img9,"Chicken Sandwich","Chicken Breast, Lettuce, Cucumber, Tomato, Fitafe Vinaigrette Sauce",22),
new Food(R.drawable.img10,"Fajita Chicken Sandwich","Grilled Chicken With Onions&Bell peppers,Soy Sauce",24)
 };*/




}
