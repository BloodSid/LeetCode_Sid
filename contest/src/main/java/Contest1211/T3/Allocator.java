package Contest1211.T3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * @author IronSid
 * @since 2022-12-11 10:52
 */
public class Allocator {

    // 记录空闲的空间
    private final TreeSet<int[]> free;
    // 记录占用的空间
    private final HashMap<Integer, List<int[]>> m;
    private int n;

    public Allocator(int n) {
        this.n = n;
        free = new TreeSet<>((o1, o2) -> o1[0] - o2[0]);
        free.add(new int[]{0, n - 1});
        m = new HashMap<>();
    }

    public int allocate(int size, int mID) {
        // 从左到右遍历空闲的空间
        for (int[] ints : free) {
            int left = ints[0];
            int right = ints[1];
            if (right - left + 1 >= size) {
                free.remove(ints);
                // 若不是恰好占满，则把剩余空间加回 free
                if (right - left + 1 != size) free.add(new int[]{left + size, right});
                if (!m.containsKey(mID)) m.put(mID, new ArrayList<>());
                m.get(mID).add(new int[]{left, left + size - 1});
                return left;
            }
        }
        return -1;
    }

    public int free(int mID) {
        int sum = 0;
        List<int[]> list = m.remove(mID);
        if (list == null) return 0;
        for (int[] ints : list) {
            int left = ints[0];
            int right = ints[1];
            sum += right - left + 1;
            int[] lower = free.lower(ints);
            if (lower != null && lower[1] + 1 == left) {
                free.remove(lower);
                left = lower[0];
            }
            int[] higher = free.higher(ints);
            if (higher != null && higher[0] - 1 == right) {
                free.remove(higher);
                right = higher[1];
            }
            free.add(new int[]{left, right});
        }
        return sum;
    }
}