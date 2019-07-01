/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import packer.Address;
import packer.Address;
import packer.Coordinates;
import packer.Coordinates;
import packer.Customer;
import packer.Customer;
import packer.Depot;
import packer.Depot;

/**
 *
 * @author Anthony Taite
 */
public class CustomerTest {

    // Test data
    Coordinates testCoordinates0 = new Coordinates(0,0);
    Coordinates testCoordinates1 = new Coordinates(3,4);
    Coordinates testCoordinates2 = new Coordinates(30,40);
    Coordinates testCoordinates3 = new Coordinates(300,400);
    Coordinates testCoordinates4 = new Coordinates(3000,4000);
    
    Address testAddress0 = new Address("111 Emerge Rd", "Really", "Inn Town", "D444", testCoordinates0);
    Address testAddress1 = new Address("1 First St", "Aplace", "Citadel City", "A111", testCoordinates1);
    Address testAddress2 = new Address("123 Count St", "Brooklyn", "Welling Town", "B222", testCoordinates2);
    Address testAddress3 = new Address("321 Back St", "Christly", "Holly Oaks", "C333", testCoordinates3);
    Address testAddress4 = new Address("55 Some St", "Somewhere", "Elsewhere", "E555", testCoordinates4);
    
    Depot testDepot0 = new Depot("Test Depot", testAddress0);
    Depot testDepot4 = new Depot("Test Depot", testAddress4);
        
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Customer class...");
    }

    /**
     * Test of getClosestAddressTo method, of class Customer.
     */
    @Test
    public void testGetClosestAddressToOne() {
        
        System.out.println("getClosestAddressToTestOne");
        Customer testCustomer;
        testCustomer = new Customer("Test Customer", testAddress3);
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot0)); // Coordinates testCoordinates0 = new Coordinates(0,0);
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4)); // Coordinates testCoordinates1 = new Coordinates(3,4);
        testCustomer.addAddress(testAddress2);                                    // Coordinates testCoordinates2 = new Coordinates(30,40);              
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot0)); // Coordinates testCoordinates3 = new Coordinates(300, 400);
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4)); // Coordinates testCoordinates4 = new Coordinates(3000, 4000);
        testCustomer.addAddress(testAddress1);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        testCustomer.addAddress(testAddress0);
        assertEquals(testAddress0, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        
    }
    
     /**
     * Test of getClosestAddressTo method number two to further validate the integrity of the method, of class Customer.
     */
    @Test
    public void testGetClosestAddressToTwo() {

        System.out.println("getClosestAddressToTestTwo");
        Customer testCustomer;
        testCustomer = new Customer("Test Customer", testAddress1);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot4));
        testCustomer.addAddress(testAddress2);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot4)); 
        testCustomer.addAddress(testAddress3);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        testCustomer.addAddress(testAddress4);         
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0)); 
        assertEquals(testAddress4, testCustomer.getClosestAddressTo(testDepot4));
    }
       
    /**
     * Test of getClosestAddressTo method number three to further validate the integrity of the method, of class Customer.
     */
    @Test
    public void testGetClosestAddressToThree() {

        System.out.println("getClosestAddressToTestThree");
        Customer testCustomer;
        testCustomer = new Customer("Test Customer", testAddress2);
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot4));
        testCustomer.addAddress(testAddress3);
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        testCustomer.addAddress(testAddress1);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
    }
    
}
