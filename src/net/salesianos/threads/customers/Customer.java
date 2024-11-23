package net.salesianos.threads.customers;

import net.salesianos.restaurants.Restaurant;

public class Customer extends Thread {

    private String name;
    private int vegetablesAmount;
    private Restaurant restaurant;

    public Customer(String name, int vegetablesAmount, Restaurant restaurant) {
        this.name = name;
        this.vegetablesAmount = vegetablesAmount;
        this.restaurant = restaurant;

    }

    @Override
    public void run() {
        for (int i = 0; i < vegetablesAmount; i++) {
            try {
                int number = (int) (Math.random() * 3) + 1;
                Thread.sleep(number * 1000);
                restaurant.eatVegetable(this.name);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
