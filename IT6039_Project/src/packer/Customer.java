package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anthony Taite
 */
public class Customer {

    private String name;
    List<Address> addresses;

    /**
     *
     * @param name enter the name of the customer
     * @param address enter the address of the customer
     */
    public Customer(String name, Address address) {
        addresses = new ArrayList<>();
        this.name = name;
        this.addresses.add(address);
    }

    /**
     *
     * @param address enter the address you wish to add
     */
    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    /**
     *
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param d enter the depot to check which address is closest
     * @return the closest address to the entered depot
     */
    public Address getClosestAddressTo(Depot d) {
        double bestDistance = Double.MAX_VALUE;
        Address bestAddress = null;

        for (Address a : addresses) {
            double distance = a.getCoordinates().companyDistanceTo(d.getCoordinates());

            if (distance < bestDistance) {
                bestAddress = a;
                bestDistance = distance;
            }
        }
        return bestAddress;
    }

    /**
     *
     * @return the name of the customer
     */
    public String toString() {
        return this.getName();
    }
}
