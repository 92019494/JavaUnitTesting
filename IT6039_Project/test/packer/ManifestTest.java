/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
/**
 *
 * @author Anthony Taite
 */
public class ManifestTest {
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest class...");
    }
    
    // Test Data
    Manifest manifest = new Manifest();
    Manifest manifest1 = new Manifest();
    Manifest manifest2 = new Manifest();
    
    
    Product a1 = new Product("Hammer", 3, true, true);
    Product a2 = new Product("Nails", 2, false, false);
    Product a3 = new Product("Wood", 3, false, true);
    Product a4 = new Product("Saw", 4, true, false);
    Product a5 = new Product("Drill", 10, true, false);
    Product a6 = new Product("Crowbar", 12, true, false);
    
    /**
     * Test of addProduct method, of class Manifest.
     */
    @Test
    public void testAddProduct(){
        System.out.println("addProduct");
        manifest.addProduct(a1);
        assertEquals("Hammer x 1",manifest.toString());
        manifest.addProduct(a1);
        assertEquals("Hammer x 2",manifest.toString());
        manifest.addProduct(a1,4);
        assertEquals("Hammer x 6",manifest.toString());
        manifest1.addProduct(a3);
        assertEquals("Wood x 1",manifest1.toString());
        manifest2.addProduct(a4,4);
        assertEquals("Saw x 4",manifest2.toString());
 
    }
    
    /**
     * Test of removeProduct method, of class Manifest.
     */
    @Test
    public void testRemoveProduct(){
        System.out.println("removeProduct");
        manifest.addProduct(a1);
        manifest.addProduct(a4,3);
        manifest.addProduct(a2,2);
        manifest.removeProduct(a1);
        assertEquals("Saw x 3\nNails x 2",manifest.toString());
        manifest.removeProduct(a4);
        assertEquals("Saw x 2\nNails x 2",manifest.toString());
        manifest.removeProduct(a4);
        assertEquals("Saw x 1\nNails x 2",manifest.toString());
        manifest.removeProduct(a4);
        assertEquals("Nails x 2",manifest.toString());

    }
    
    /**
     * Test of getTotalWeight method, of class Manifest.
     */
    @Test 
    public void testGetTotalWeight(){
        System.out.println("getTotalWeight");
        manifest.addProduct(a1,5);
        assertEquals(15.0,manifest.getTotalWeight(), 0); 
        manifest.addProduct(a1);
        assertEquals(18.0,manifest.getTotalWeight(), 0); 
        
        manifest1.addProduct(a3,5);
        assertEquals(15.0,manifest1.getTotalWeight(), 0); 
        manifest1.addProduct(a2);
        assertEquals(17.0,manifest1.getTotalWeight(), 0); 
    }
    
    /**
     * Test of getHeaviestUnder method, of class Manifest.
     */
    @Test
    public void testGetHeaviestUnder(){
        System.out.println("getHeaviestUnder");
        manifest.addProduct(a1);
        manifest.addProduct(a3,2);
        manifest.addProduct(a4);
        manifest.addProduct(a2,4);
        manifest.addProduct(a5);
        manifest.addProduct(a6);
        assertEquals(a6,manifest.getHeaviestUnder(20));
        assertEquals(a5,manifest.getHeaviestUnder(11));
        assertEquals(a4,manifest.getHeaviestUnder(5));
    }
    
    /**
     * Test of isEmpty method, of class Manifest.
     */
    @Test
    public void testIsEmpty(){
        System.out.println("isEmpty");
        assertEquals(true,manifest.isEmpty());
        manifest.addProduct(a2,2);
        assertEquals(false,manifest.isEmpty());
        manifest.removeProduct(a2);
        assertEquals(false,manifest.isEmpty());
        manifest.addProduct(a3,2);
        assertEquals(false,manifest.isEmpty());
        manifest.removeProduct(a3);
        assertEquals(false,manifest.isEmpty());
        manifest.removeProduct(a3);
        assertEquals(false,manifest.isEmpty());
    
    }
    
    /**
     * Test of containsProduct method, of class Manifest.
     */
    @Test
    public void testContainsProduct(){
        System.out.println("containsProduct");
        manifest.addProduct(a2,2);
        assertEquals(false,manifest.containsProduct(a3));
        manifest.addProduct(a3,2);
        assertEquals(true,manifest.containsProduct(a3));
        manifest.removeProduct(a3);
        assertEquals(true,manifest.containsProduct(a3));
        manifest.addProduct(a4);
        manifest.removeProduct(a3);
        assertEquals(false,manifest.containsProduct(a3));
        assertEquals(false,manifest.containsProduct(a1));
        assertEquals(true,manifest.containsProduct(a4));
    }
    
    /**
     * Test of hasFragileItems method, of class Manifest.
     */
    @Test
    public void testHasFragileItems(){
        System.out.println("hasFragileItems");
        manifest.addProduct(a1);
        assertEquals(true,manifest.hasFragileItems());
        manifest1.addProduct(a2);
        assertEquals(false,manifest1.hasFragileItems());
        manifest1.addProduct(a3);
        assertEquals(true,manifest1.hasFragileItems());
    }
    
    /**
     * Test of hasHazardousItems method, of class Manifest.
     */
    @Test
    public void testHasHazardousItems(){
        System.out.println("hasHazardousItems");
        manifest.addProduct(a1);
        assertEquals(true,manifest.hasHazardousItems());
        manifest1.addProduct(a3);
        assertEquals(false,manifest1.hasHazardousItems());
        manifest1.addProduct(a4);
        assertEquals(true,manifest1.hasHazardousItems());
    }
}
