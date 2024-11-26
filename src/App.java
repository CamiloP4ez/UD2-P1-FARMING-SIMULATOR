import net.salesianos.restaurants.Restaurant;
import net.salesianos.threads.customers.Customer;
import net.salesianos.threads.farmers.Farmer;

public class App {
    public static void main(String[] args) throws Exception {

        Restaurant restaurant = new Restaurant(5);
        Farmer paco = new Farmer(5, restaurant, "PACO");

        Customer ruben = new Customer("PEPE", 5, restaurant);

        paco.start();
        ruben.start();

        try {
            paco.join();
            ruben.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
