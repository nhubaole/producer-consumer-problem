package procon;

public class Consumer extends Thread {

    private final String mName;

    private final Storage mStorage;

    public Consumer(String name, Storage storage) {
        super(name);
        mName = name;
        mStorage = storage;
    }

    private void consume(Product product) {
        System.out.println(mName + " consume produce " + product.getData());
    }

    @Override
    public void run() {
        super.run();
        System.out.println(mName + " is running");
        while (true) {
            try {
                final Product product = mStorage.get();
                consume(product);
                System.out.println(mName + " consumed " + product.getData());
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
