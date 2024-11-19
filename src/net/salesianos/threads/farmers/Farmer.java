package net.salesianos.threads.farmers;

import net.salesianos.restaurants.Restaurant;
import net.salesianos.utils.Vegetables;

public class Farmer extends Thread {
    private int vegetablesAmount;
    private Restaurant restaurant;

    public Farmer(int vegetablesAmount, Restaurant restaurant) {
        super();
        this.vegetablesAmount = vegetablesAmount;
        this.restaurant = restaurant;

    }

    @Override
    public void run() {
        for (int i = 0; i < vegetablesAmount; i++) {
            try {
                String vegetable = Vegetables.getVegetable();
                int number = (int) (Math.random() * 3) + 1;
                sleep(number * 1000);
                restaurant.addVegetable(vegetable);

                // aqui agrega a un array de uso compartido :)
            } catch (Exception e) {
            }

        }
    }
}
