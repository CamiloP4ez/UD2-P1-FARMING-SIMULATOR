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
                if (restaurant.isWarehouseFull() != 0) {
                    int number = (int) (Math.random() * 3) + 1;
                    Thread.sleep(number * 1000);
                    restaurant.eatVegetable();
                    System.out.println(this.getId() + " ha consumido una verdura");
                } else {
                    Thread.sleep(1000);
                    i--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
