package net.salesianos.restaurants;

public class Restaurant {

    private String[] warehouse;

    public Restaurant(int size) {
        this.warehouse = new String[size];
    }

    public void addVegetable(String vegetable, String name) {
        try {
            synchronized (this) {
                while (availableSpace() == 0) {
                    System.out.println("El granjero " + name + " espera, no hay espacio disponible");
                    wait();
                }
                for (int i = 0; i < warehouse.length; i++) {
                    if (warehouse[i] == null) {
                        warehouse[i] = vegetable;
                        System.out.println("Se ha producido una nueva verdura " + vegetable + " por el granjero " +
                                name + "\n");
                        notifyAll();
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void eatVegetable(String name) {
        try {
            while (availableSpace() == this.warehouse.length) {
                System.out.println("El cliente " + name + " espera, no hay verduras para consumir \n");
                wait();
            }
            for (int i = 0; i < warehouse.length; i++) {
                if (warehouse[i] != null) {
                    System.out.println("El cliente " + name + " ha consumido " + warehouse[i] + "\n");
                    warehouse[i] = null;
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