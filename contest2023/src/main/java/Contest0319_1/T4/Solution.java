package Contest0319_1.T4;

public class Solution {
    public long repairCars(int[] ranks, int cars) {
        long l = 1, r = (long) 1e14;
        while (l <= r) {
            long mid = l + r >> 1;
            long t = 0;
            for (int rank : ranks) {
                t += (long) Math.sqrt(mid / rank);
            }
            if (t < cars) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}

