package procon;

import java.util.UUID;

public class Producer extends Thread {

    private final String mName;

    private final Storage mStorage;

    public Producer(String name, Storage storage) {
        super(name);
        mName = name;
        mStorage = storage;
    }

    private Product produce() {
        return new Product(UUID.randomUUID().toString());
    }

    @Override
    public void run() {
        super.run();
        System.out.println(mName + " is running");
        while (true) {
            try {
                final Product newProduct = produce();
                mStorage.put(newProduct);
                System.out.println(mName + " produce " + newProduct.getData());
            } catch (Exception e) {
                System.out.println(mName + e.getMessage());
            }

            mySleep(10L);
        }
    }

    private void mySleep(Long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }

}
