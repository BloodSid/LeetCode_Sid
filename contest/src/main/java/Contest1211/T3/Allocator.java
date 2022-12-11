package Contest1211.T3;

/**
 * @author IronSid
 * @since 2022-12-11 10:52
 */
public class Allocator {

    private final int[] mem;

    public Allocator(int n) {
        mem = new int[n];
    }

    public int allocate(int size, int mID) {
        for (int i = 0, t = 0; i < mem.length; i++) {
            if (mem[i] == 0) {
                t++;
                if (t == size) {
                    for (int j = i - t + 1; j <= i; j++) {
                        mem[j] = mID;
                    }
                    return i - t + 1;
                }
            } else {
                t = 0;
            }
        }
        return -1;
    }

    public int free(int mID) {
        int sum = 0;
        for (int i = 0; i < mem.length; i++) {
            if (mem[i] == mID) {
                sum++;
                mem[i] = 0;
            }
        }
        return sum;
    }
}