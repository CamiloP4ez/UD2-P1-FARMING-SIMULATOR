package net.salesianos.utils;

public class Vegetables {
    private static String[] vegetables = { "lettuce", "cabbage", "onion", "spinach", "potato", "celery", "asparagus",
            "radish",
            "broccoli", "artichoke", "tomato", "cucumber", "eggplant", "carrot", "green bean" };

    public static String getVegetable() {
        String vegetable = vegetables[(int) (Math.random() * vegetables.length)];
        return vegetable;
    }
}