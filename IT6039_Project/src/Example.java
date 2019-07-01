
import java.util.ArrayList;
import java.util.List;
import packer.Address;
import packer.Box;
import packer.Coordinates;
import packer.Customer;
import packer.Depot;
import packer.Manifest;
import packer.Packer;
import packer.Product;

/**
 * @author Anthony Taite
 *
 * This file shows example usage of the system
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
        Depot depot = new Depot("Main Depot", depotAddress);
        System.out.println("\nDEPOT:");
        System.out.println(depot);

        Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
        Address customerAddress2 = new Address("88 Camp Mine St", "Ridgeway", "Lowe Valley", "I998", new Coordinates(100, 34));
        Customer customer = new Customer("Andy Bravo", customerAddress1);
        customer.addAddress(customerAddress2);
        System.out.println("\nCUSTOMER");
        System.out.println(customer);

        Product hammer = new Product("Hammer", 1, true, true);
        Product nails = new Product("Nails", 8, true, true);
        Product ladder = new Product("Ladder", 3, false, true);
        Product saw = new Product("Saw", 4, true, false);

        Product lights = new Product("Lights", 8, true, true);
        Product drill = new Product("Drill", 2, true, true);
        Product blade = new Product("Blade", 3, false, true);
        Product knife = new Product("Knife", 4, true, false);

        Manifest manifest = new Manifest();
        manifest.addProduct(hammer, 2);
        manifest.addProduct(hammer, 2);
        manifest.addProduct(knife, 4);
        manifest.addProduct(blade, 2);
        manifest.addProduct(blade, 2);
        manifest.addProduct(lights, 3);
        manifest.addProduct(knife, 2);
        manifest.addProduct(saw, 2);
        manifest.addProduct(drill, 2);
        manifest.addProduct(drill, 5);
        manifest.addProduct(saw, 2);

        System.out.println("\nMANIFEST (to be packed):");

        System.out.println("\nPACKING:");
        List<Box> done = Packer.packProducts(customer, depot, manifest);

        // Results
        int i = 0;
        for (Box b : done) {
            System.out.println(b);
            i++;
        }

        System.out.println(i + " boxes packed");

    }

}
