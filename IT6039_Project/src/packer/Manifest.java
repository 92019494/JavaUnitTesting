package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Anthony Taite
 */
public class Manifest {

    // This tracks the quantity if each product in the manifest
    private Map<Product, Integer> quantities;
    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;

    public Manifest() {
        quantities = new HashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
    }

    /**
     *
     * @param p enter the product you wish to add
     */
    public void addProduct(Product p) {
        addProduct(p, 1);
    }

    /**
     *
     * @param p enter the product you wish to add
     * @param quantity enter the amount of the product you wish to add
     */
    public void addProduct(Product p, int quantity) {
        if (quantities.containsKey(p)) {
            quantities.put(p, quantities.get(p) + quantity); // Changed from * to +
        } else {
            quantities.put(p, quantity);
            if (!byWeight.add(p)) {
                System.out.println("Couldn't add " + p.getName() + " to Set");
            }
        }
    }

    /**
     *
     * @param p enter the product you want to check
     * @return the amount of the entered product
     */
    public int getProductQuantity(Product p) {
        return quantities.get(p);
    }

    /**
     *
     * @param p enter the product you wish to remove
     */
    public void removeProduct(Product p) {

        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            quantities.put(p, quantities.get(p) - 1);
        }
        if (quantities.get(p) == 0) {
            quantities.remove(p);

        }

        if (!quantities.containsKey(p)) {
            byWeight.remove(p);
        }

    }

    /**
     *
     * @return the total weight of products in the manifest quantities
     */
    public double getTotalWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            weight += quantities.get(p) * p.getWeight();
        }
        return weight;
    }

    /**
     *
     * @param weight enter the weight you wish to check against
     * @return the heaviest product you can fit in based on weight
     */
    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() < weight) {
                return p;
            }
        }
        return null;
    }

    /**
     *
     * @return a boolean based on whether or not the manifests byWeight variable
     * is empty
     */
    public boolean isEmpty() {
        //System.out.println(byWeight);
        return byWeight.isEmpty();

    }

    /**
     *
     * @param p enter the product you wish to check
     * @return if the manifest contains the product you entered
     */
    public boolean containsProduct(Product p) {
        return quantities.containsKey(p) && quantities.get(p) > 0;
    }

    /**
     *
     * @return the string of the products and amounts in the manifest
     */
    public String toString() {

        StringBuilder result = null;
        result = new StringBuilder();
        for (Product p : quantities.keySet()) {
            result.append(p.getName());
            result.append(" x ");
            result.append(quantities.get(p));
            result.append("\n");
        }
        return result.substring(0, result.length() - 1);

    }

    /**
     *
     * @return if the manifest contains fragile items or not
     */
    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return if the manifest contains hazardous items or not
     */
    public boolean hasHazardousItems() {
        for (Product p : quantities.keySet()) {
            if (p.isHazardous()) {
                return true;
            }
        }
        return false;
    }

}
