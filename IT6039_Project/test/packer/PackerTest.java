/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import packer.Packer;
/**
 *
 * This packer class relies on the box classes toString() method. If this test fails please
 * make sure the box test class passes all it's tests before debugging the packer class
 * 
 * @author Anthony Taite
 */
public class PackerTest {
    
        // Test data
        Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
        Depot depot = new Depot("Main Depot", depotAddress);

        Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
        Address customerAddress2 = new Address("88 Camp Mine St", "Ridgeway", "Lowe Valley", "I998", new Coordinates(100, 34));
        Customer customer = new Customer("Andy Bravo", customerAddress1);

        Product hammer = new Product("Hammer", 1, true, true);
        Product nails = new Product("Nails", 8, true, true);
        Product ladder = new Product("Ladder", 3, false, true);
        Product saw = new Product("Saw", 4, true, false);
    
        Product lights = new Product("Lights", 8, true, true);
        Product drill = new Product("Drill", 2, true, true);
        Product blade = new Product("Blade", 3, false, true);
        Product knife = new Product("Knife", 4, true, false);
        
        Manifest manifest = new Manifest();
        Manifest manifest2 = new Manifest();

    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Packer class...");
    }
    
    /**
     * Test of packProducts method, of class Packer.
     */
    @Test
    public void testPackProducts(){
        System.out.println("packProducts");
        customer.addAddress(customerAddress2);
        manifest.addProduct(hammer, 2);
        manifest.addProduct(blade, 2);


        List<Box> packedBoxes = Packer.packProducts(customer, depot, manifest);
        assertEquals(1,packedBoxes.size());
       
        manifest.addProduct(drill, 5);
        manifest.addProduct(hammer, 2);
        manifest.addProduct(lights, 4);
        manifest.addProduct(nails, 2);
        manifest.addProduct(saw, 3);
        
        List<Box> packedBoxes2 = Packer.packProducts(customer, depot, manifest);
        assertEquals(4,packedBoxes2.size());
        
        manifest2.addProduct(drill, 25);
        manifest2.addProduct(hammer, 12);
        manifest2.addProduct(lights, 4);
        manifest2.addProduct(nails, 2);
        manifest2.addProduct(saw, 3);
        
        List<Box> packedBoxes3 = Packer.packProducts(customer, depot, manifest2);
        assertEquals(7,packedBoxes3.size());
        
        manifest2.addProduct(lights, 100);
        
        List<Box> packedBoxes4 = Packer.packProducts(customer, depot, manifest2);
        assertEquals(50,packedBoxes4.size());

    }
}
