package packer;

/**
 *
 * @author Anthony Taite
 */
public class Address {
    private String street;
    private String suburb;
    private String city;
    private String postcode;
    private Coordinates coordinates;

    /**
     * 
     *  @param street the name of the street
     *  @param suburb the name of the suburb
     *  @param city the name of the city
     *  @param postcode the name of the postcode
     *  @param coordinates the coordinates of the address(Double x, Double y)
     */
    public Address(String street, String suburb, String city, String postcode, Coordinates coordinates) {
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }

    /**
     * @returns a string of the address with each parameter presented
     * on a new line
     */
    public String toString() {
        return 
                street + "\n" +
                suburb + "\n" +
                city + "\n" +
                postcode;
    }
    
    /**
     * @return the coordinates 
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    
}
