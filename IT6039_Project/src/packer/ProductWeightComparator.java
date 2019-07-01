package packer;

import java.util.Comparator;

/**
 *
 * @author Anthony Taite This is used when we need to sort by product weight
 * descending
 */
public class ProductWeightComparator implements Comparator<Product> {

    /**
     *
     * @param a enter the first product
     * @param b enter the second product
     * @return
     */
    public int compare(Product a, Product b) {
        if (a.getWeight() < b.getWeight()) {
            return 1;
        } else if (a.getWeight() > b.getWeight()) {
            return -1;
        } else {
            return a.getName().compareTo(b.getName());
        }
    }

}
