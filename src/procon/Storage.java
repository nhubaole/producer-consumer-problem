package procon;

import java.util.LinkedList;
import java.util.Queue;

public class Storage {

    private static final int MAX_SIZE = 20;

    private final Queue<Product> products = new LinkedList<>();

    void put(Product product) throws Exception {
        synchronized (products) {
            if(products.size() == MAX_SIZE) {
                throw new Exception("Storage is Full");
            }
            products.add(product);
        }
    }

    Product get() throws Exception {
        synchronized (products) {
            if(products.isEmpty()) {
                throw new Exception("Storage is Empty");
            }
            return products.poll();
        }
    }
}
