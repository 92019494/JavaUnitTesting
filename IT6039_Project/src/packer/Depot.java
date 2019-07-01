package packer;

/**
 *
 * @author Anthony Taite
 */
public class Depot {

    private String name;
    private Address address;

    /**
     *
     * @param name enter the name of the depot
     * @param address enter the address of the depot
     */
    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    /**
     *
     * @return the name of the depot
     */
    public String getName() {
        return name.toString();
    }

    /**
     *
     * @return the coordinates of the depot
     */
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }

    /**
     *
     * @return the name of the depot
     */
    public String toString() {
        return this.getName();
    }

}
