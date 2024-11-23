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
                synchronized (restaurant) {
                    while (restaurant.availableSpace() == 0) {
                        System.out.printf("El granjero %s espera, no hay espacio disponible%n", this.name);
                        restaurant.wait();
                    }
                    String vegetable = Vegetables.getVegetable();
                    int number = (int) (Math.random() * 3) + 1;
                    Thread.sleep(number * 1000);
                    restaurant.addVegetable(vegetable);
                    System.out.printf("Se ha producido una nueva verdura %s por el granjero %s%n", vegetable,
                            this.name);
                    restaurant.notifyAll();
                }

                // aqui agrega a un array de uso compartido :)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
