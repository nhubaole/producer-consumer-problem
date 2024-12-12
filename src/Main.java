public class Main {
    public static void main(String[] args) {
        new Solution().solve();
        keepAppLiving();
    }

    private static void keepAppLiving() {
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}