package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anthony Taite
 */
public class Packer {
        
    /**
     * 
     * @param c enter the customer
     * @param d enter the depot
     * @param m enter the manifest
     * @return a list of boxes containing every product that was in the manifest 
     */
    public static List<Box> packProducts(Customer c, Depot d, Manifest m) {
        List<Box> packedBoxes = new ArrayList<>();
        Box b = null;
        
//        System.out.println("starting manifest");
//        System.out.println(m);
//        System.out.println("starting manifest");
        while (!m.isEmpty()) { // repeat until all items are packed
            if (b == null) {
                b = new Box(c,d);
//                System.out.println("\nnew box created\n");
            }
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());
            if (prodToAdd == null) {
                //System.out.println("get heaviest product that can fit");
                packedBoxes.add(b);
                b = null;
            }
            else {
//                System.out.println("This is the manifest");
//                System.out.println(m);
//                System.out.println("This is the manifest");
//                System.out.println("the remaining capacity of this box is " + b.remainingCapacity());
                b.addProduct(prodToAdd);
                m.removeProduct(prodToAdd);
            }  
        }
        if (b != null) {
            packedBoxes.add(b);
            //System.out.println("last box added");
        }
 
        return packedBoxes;
    }
    
}
