package net.salesianos.threads.farmers;

import net.salesianos.restaurants.Restaurant;
import net.salesianos.utils.Vegetables;

public class Farmer extends Thread {
    private int vegetablesAmount;
    private Restaurant restaurant;
    private String name;

    public Farmer(int vegetablesAmount, Restaurant restaurant, String name) {
        super();
        this.vegetablesAmount = vegetablesAmount;
        this.restaurant = restaurant;
        this.name = name;

    }

    @Override
    public void run() {
        for (int i = 0; i < vegetablesAmount; i++) {
            try {
                if (restaurant.availableSpace() != 0) {
                    String vegetable = Vegetables.getVegetable();
                    int number = (int) (Math.random() * 3) + 1;
                    sleep(number * 1000);
                    restaurant.addVegetable(vegetable);
                    System.out.printf("Se ha producido una nueva verdura %s por el granjero %s", vegetable, this.name);

                } else {
                    Thread.sleep(1000);

                }

                // aqui agrega a un array de uso compartido :)
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
