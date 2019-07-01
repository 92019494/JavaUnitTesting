/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import packer.Address;
import packer.Coordinates;
import packer.Depot;

/**
 *
 * @author Anthony Taite
 */
public class DepotTest {
    
    // Test data
    Coordinates testCoordinates1 = new Coordinates(0,0);
    Coordinates testCoordinates2 = new Coordinates(30,40);
    Coordinates testCoordinates3 = new Coordinates(1000, 2000);
    Address testAddress1 = new Address("1 First St", "Aplace", "Citadel City", "A111", testCoordinates1);
    Address testAddress2 = new Address("123 Count St", "Brooklyn", "Welling Town", "B222", testCoordinates2);
    Address testAddress3 = new Address("321 Back St", "Christly", "Holly Oaks", "C333", testCoordinates3);
    Depot testDepot1 = new Depot("City Depot", testAddress1);
    Depot testDepot2 = new Depot("Suburbs Depot", testAddress2);
    Depot testDepot3 = new Depot("Country Depot", testAddress3);

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Depot class...");
    }
    
    /**
     * Test of getName method, of class Depot.
     */
    @Test
    public void testGetName() {
        System.out.println("toString");
        assertEquals("City Depot", testDepot1.getName());
        assertEquals("Suburbs Depot", testDepot2.getName());
        assertEquals("Country Depot", testDepot3.getName());
    }

    /**
     * Test of getCoordinates method, of class Depot.
     */
    @Test
    public void testGetCoordinates() {
        System.out.println("getCoordinates");
        assertEquals(testCoordinates1, testDepot1.getCoordinates());
        assertEquals(testCoordinates2, testDepot2.getCoordinates());
        assertEquals(testCoordinates3, testDepot3.getCoordinates());
    }
    
}
