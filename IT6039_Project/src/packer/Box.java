package packer;

/**
 *
 * @author Anthony Taite
 */
public class Box {
    
    
    private Manifest contents;
    private Customer customer;
    private Depot depot; 
    
    /**
     * 
     * @param customer the customer who the box is for
     * @param depot the closest depot to the customers address
     */

    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }
    
    /**
     * *
     * @param product enter the product you wish to add
     * if a product can fit in the box it will be added
     */
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }
        

    /**
     * 
     * @param product enter the product you wish to add
     * @param quantity enter the amount of the product you wish to add
     * if the products can fit in the box it will be added
     */
    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)); {
            contents.addProduct(product, quantity);
        }
    }
    
    /**
     * 
     * @return the contents of the box
     */
   public String getContents(){
       return contents.toString();
   }
    
   /**
    * 
    * @return the label which includes the customer, the closest depot,
    * the contents of the box and any warnings for whats inside the box
    */
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");
        }
        if (this.isHazardous()) {
            label.append("HAZARDOUS\n");
        }
        if (contents.getTotalWeight() > 15){
            label.append("HEAVY\n");
        }
        
        return label.toString();
    }
    
    
    /**
     * 
     * @return label 
     */
    public String toString() {
        return getLabel();
    }
    
    /**
     * 
     * @return the combined weight of all products in the bos
     */
    public double getWeight() {
        return contents.getTotalWeight();
    }

    /**
     * 
     * @param p enter the product you wish to check
     * @return a boolean based on whether the product can fit into the box
     */
    public boolean canFit(Product p) {
        return p.getWeight() < this.remainingCapacity(); // changed from 40 to this.remainingCapacity()
    }
    
    /**
     * 
     * @param p enter the product you wish to check
     * @param quantity enter the amount of the product you wish to check
     * @return a boolean based on whether the products can fit into the box 
     */
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) < this.remainingCapacity(); // changed from 40 to this.remainingCapacity()
    }
    
    /**
     * 
     * @return the remaining capacity of the box
     */
    public double remainingCapacity() {
        return 20 - this.getWeight(); // changed from 40 to 20
    }
    
    /**
     * 
     * @return a boolean based on whether the box contains fragile items or not 
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    
    /**
     * 
     * @return a boolean based on whether the box contains hazardous items or not 
     */
    public boolean isHazardous() {
        return contents.hasHazardousItems();
    }
    
}
