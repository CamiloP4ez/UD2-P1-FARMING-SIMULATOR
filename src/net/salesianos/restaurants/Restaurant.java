package net.salesianos.restaurants;

public class Restaurant {

    private String[] warehouse;

    public Restaurant(int size) {
        this.warehouse = new String[size];
    }

    public synchronized void addVegetable(String vegetable) {
        for (int i = 0; i < warehouse.length; i++) {
            if (warehouse[i] == null) {
                warehouse[i] = vegetable;
                break;
            }
        }
    }

    public synchronized String eatVegetable() {
        String vegetable = null;
        for (int i = 0; i < warehouse.length; i++) {
            if (warehouse[i] != null) {
                vegetable = warehouse[i];
                warehouse[i] = null;
                break;
            }
        }
        return vegetable;
    }

    public int isWarehouseFull() {
        int space = 0;
        for (int i = 0; i < warehouse.length; i++) {
            if (warehouse[i] == null) {
                space++;
            }
        }
        return space;
    }

}