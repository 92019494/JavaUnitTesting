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
public class BoxTest {
    
    // Test data
    Coordinates testCoordinates0 = new Coordinates(0,0);
    Coordinates testCoordinates1 = new Coordinates(3,4);
   
    Address testAddress0 = new Address("111 Emerge Rd", "Really", "Inn Town", "D444", testCoordinates0);
    Address testAddress1 = new Address("1 First St", "Aplace", "Citadel City", "A111", testCoordinates1);

    Depot testDepot0 = new Depot("Test Depot", testAddress0);
    Depot testDepot4 = new Depot("Test Depot", testAddress1);
    
    Customer testCustomer = new Customer("testCustomer", testAddress0);
    
    Product a1 = new Product("Hammer", 3, true, true);
    Product a2 = new Product("Nails", 2, false, false);
    Product a3 = new Product("Wood", 3, false, true);
    Product a4 = new Product("Saw", 4, true, false);
    
    Box box = new Box(testCustomer, testDepot0);
    Box box1 = new Box(testCustomer, testDepot4);
    
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }
    
    /**
     * Test of getLabel method, of class Box.
     */
    @Test
    public void testGetLabel(){
        System.out.println("getLabel");
        box1.addProduct(a1,6);
        assertEquals(testCustomer + "\n" 
                + testCustomer.getClosestAddressTo(testDepot0)
                + "\n" + "Hammer x 6\n" + "FRAGILE\n" +  "HAZARDOUS\n" + "HEAVY\n"
                ,box1.getLabel());  
        
        box.addProduct(a2, 10);
        assertEquals(testCustomer + "\n" 
                + testCustomer.getClosestAddressTo(testDepot0)
                + "\n" + "Nails x 10\n" + "HEAVY\n"
                ,box.getLabel());  
        
    }
    
    /**
     * Test of addProduct method, of class Box.
     */
    @Test
    public void testAddProduct(){
        System.out.println("addProduct");
        
        box.addProduct(a4);
        assertEquals("Saw x 1",box.getContents());

        
        box1.addProduct(a3,10);
        assertEquals("Wood x 10",box1.getContents());

        
    }
    
    /**
     * Test of getWeight method, of class Box.
     */
    @Test
    public void testGetWeight(){
        System.out.println("getWeight");
        
        box.addProduct(a1,5);
        assertEquals(15.0,box.getWeight(), 0); 
        box.addProduct(a1);
        assertEquals(18.0,box.getWeight(), 0); 
        
        box1.addProduct(a3,5);
        assertEquals(15.0,box1.getWeight(), 0); 
        box1.addProduct(a2);
        assertEquals(17.0,box1.getWeight(), 0); 
        
      
    }
    
    /**
     * Test of canFit method, of class Box.
     */
    @Test
    public void testCanFit(){
        System.out.println("canFit");
        
        assertEquals(true,box.canFit(a1)); 
        assertEquals(true,box.canFit(a2));
        assertEquals(true,box.canFit(a3));
        assertEquals(true,box.canFit(a4));
        assertEquals(false,box.canFit(a1,20));
        assertEquals(true,box.canFit(a3,4));
        assertEquals(true,box.canFit(a2,5));
        assertEquals(false,box.canFit(a3,7));
        assertEquals(false,box.canFit(a4,6));

    }
    
    /**
     * Test of remainingCapacity method, of class Box.
     */
    @Test
    public void testRemainingCapacity(){
        System.out.println("remainingCapacity");
        
        assertEquals(20,box.remainingCapacity(),0);
        box.addProduct(a1);
        assertEquals(17.0,box.remainingCapacity(),0);
        box.addProduct(a3,2);
        assertEquals(11.0,box.remainingCapacity(),0);
        
        assertEquals(20,box1.remainingCapacity(),0);
        box1.addProduct(a4,3);
        assertEquals(8.0,box1.remainingCapacity(),0);
        box1.addProduct(a2,2);
        assertEquals(4.0,box1.remainingCapacity(),0);
    }
    
    /**
     * Test of isFragile method, of class Box.
     */
    @Test 
    public void testIsFragile(){
        System.out.println("isFragile");
        box.addProduct(a1);
        assertEquals(true,box.isFragile());
        box1.addProduct(a2);
        assertEquals(false,box1.isFragile());
        box1.addProduct(a3);
        assertEquals(true,box1.isFragile());
    }
    
    /**
     * Test of isHazardous method, of class Box.
     */
    @Test 
    public void testIsHazardous(){
        System.out.println("isHazardous");
        box.addProduct(a1);
        assertEquals(true,box.isHazardous());
        box1.addProduct(a3);
        assertEquals(false,box1.isHazardous());
        box1.addProduct(a4);
        assertEquals(true,box1.isHazardous());
    }
}
