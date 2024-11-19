package net.salesianos.threads.customers;

import net.salesianos.restaurants.Restaurant;

public class Customer extends Thread {

    private int vegetablesAmount;
    private Restaurant restaurant;

    public Customer(int vegetablesAmount, Restaurant restaurant) {
        super();
        this.vegetablesAmount = vegetablesAmount;
        this.restaurant = restaurant;

    }

    @Override
    public void run() {
        for (int i = 0; i < vegetablesAmount; i++) {
            try {
                restaurant.eatVegetable();

                // aqui agrega a un array de uso compartido :)
            } catch (Exception e) {
            }

        }
    }
}
