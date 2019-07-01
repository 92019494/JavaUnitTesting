/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;


/**
 *
 * @author Anthony Taite
 */
public class AddressTest {
    
    // Test data
    Coordinates testCoordinates1 = new Coordinates(0,0);
    Coordinates testCoordinates2 = new Coordinates(30,40);
    Coordinates testCoordinates3 = new Coordinates(1000, 2000);
    Address testAddress1 = new Address("1 First St", "Aplace", "Citadel City", "A111", testCoordinates1);
    Address testAddress2 = new Address("123 Count St", "Brooklyn", "Welling Town", "B222", testCoordinates2);
    Address testAddress3 = new Address("321 Back St", "Christly", "Holly Oaks", "C333", testCoordinates3);

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Address class...");
    }
    
    /**
     * Test of toString method, of class Address.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals("1 First St\nAplace\nCitadel City\nA111", testAddress1.toString());
        assertEquals("123 Count St\nBrooklyn\nWelling Town\nB222", testAddress2.toString());
        assertEquals("321 Back St\nChristly\nHolly Oaks\nC333", testAddress3.toString());
    }

    /**
     * Test of getCoordinates method, of class Address.
     */
    @Test
    public void testGetCoordinates() {
        System.out.println("getCoordinates");
        assertEquals(testCoordinates1, testAddress1.getCoordinates());
        assertEquals(testCoordinates2, testAddress2.getCoordinates());
        assertEquals(testCoordinates3, testAddress3.getCoordinates());
    }
    
}
