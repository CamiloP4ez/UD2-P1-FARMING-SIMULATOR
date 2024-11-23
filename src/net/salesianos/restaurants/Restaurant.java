package net.salesianos.restaurants;

public class Restaurant {

    private String[] warehouse;

    public Restaurant(int size) {
        this.warehouse = new String[size];
    }

    public void addVegetable(String vegetable) {
        synchronized (this) {
            for (int i = 0; i < warehouse.length; i++) {
                if (warehouse[i] == null) {
                    warehouse[i] = vegetable;
                    break;
                }
            }
        }
    }

    public synchronized void eatVegetable(String name) {
        try {
            while (availableSpace() == this.warehouse.length) {
                System.out.printf("El cliente %d espera, no hay verduras para consumir%n", name);
                wait();
            }
            for (int i = 0; i < warehouse.length; i++) {
                if (warehouse[i] != null) {
                    warehouse[i] = null;
                    System.out.printf("El cliente %d ha consumido una verdura%n", name);
                    notifyAll();
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int availableSpace() {
        int space = 0;
        for (int i = 0; i < warehouse.length; i++) {
            if (warehouse[i] == null) {
                space++;
            }
        }
        return space;
    }

}