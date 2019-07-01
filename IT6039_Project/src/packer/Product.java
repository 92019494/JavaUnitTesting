package packer;

/**
 *
 * @author Anthony Taite
 */
public class Product {

    private String name;
    private int weight;
    private boolean hazardous;
    private boolean fragile;

    /**
     * 
     * @param name enter the name of the product
     * @param weight enter the weight of the product
     * @param hazardous enter if the product is hazardous or not
     * @param fragile enter if the product is fragile or not
     */
    public Product(String name, int weight, boolean hazardous, boolean fragile) {
        this.name = name;
        this.weight = weight;
        this.hazardous = hazardous;
        this.fragile = fragile;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return if hazardous
     */
    public boolean isHazardous() {
        return hazardous;
    }

    /**
     * @return if fragile
     */
    public boolean isFragile() {
        return fragile;
    }

    /**
     * 
     * @return the name
     */
    public String toString() {
        return this.getName();
    }
    
    /**
     * 
     * @param o enter the object you wish to check
     * @return boolean based on if the names match
     */
    public boolean equals(Object o) {
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product)o;
        return p.getName().equals(this.getName());
    }
    
}
