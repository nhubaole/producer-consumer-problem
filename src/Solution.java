import procon.Consumer;
import procon.Producer;
import procon.Storage;

public class Solution {
    void solve() {
        final Storage storage = new Storage();

        for (int i = 1; i <= 5; i++) {
            new Producer("Producer" + i, storage).start();
        }

        for (int i = 1; i <= 5; i++) {
            new Consumer("Consumer" + i, storage).start();
        }
    }
}
