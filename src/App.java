import net.salesianos.restaurants.Restaurant;
import net.salesianos.threads.customers.Customer;
import net.salesianos.threads.farmers.Farmer;

public class App {
    public static void main(String[] args) throws Exception {

        Restaurant restaurant = new Restaurant(15);
        Farmer paco = new Farmer(20, restaurant, "paco");

        Customer ruben = new Customer("Pepe", 10, restaurant);

        paco.start();
        paco.setPriority(Thread.MIN_PRIORITY);
        ruben.start();
        ruben.setPriority(Thread.MAX_PRIORITY);

        try {
            paco.join();
            ruben.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
