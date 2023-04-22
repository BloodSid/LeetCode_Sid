package Contest0422.T3;

import java.util.*;

/**
 * @author IronSid
 * @since 2023-04-22 14:59
 */
public class Solution {
    public int fieldOfGreatestBlessing(int[][] forceField) {
        long[][] rec = new long[forceField.length][];
        int ri = 0;
        for (int[] ints : forceField) {
            long x = ints[0], y = ints[1], side = ints[2];
            rec[ri++] = new long[]{2 * x - side, 2 * y - side, 2 * x + side, 2 * y + side};
        }
        HashSet<Long> set = new HashSet<>();
        // 对 x 坐标离散化
        for (long[] longs : rec) {
            set.add(longs[0]);
            set.add(longs[2]);
        }
        Long[] arr = set.toArray(new Long[0]);
        Arrays.sort(arr);
        HashMap<Long, Integer> xi = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            xi.put(arr[i], i);
        }
        HashMap<Long, List<Integer>> addY = new HashMap<>();
        HashMap<Long, List<Integer>> subY = new HashMap<>();
        set = new HashSet<>();
        for (int i = 0; i < rec.length; i++) {
            long[] longs = rec[i];
            set.add(longs[1]);
            set.add(longs[3]);
            addY.computeIfAbsent(longs[1], k -> new ArrayList<>()).add(i);
            subY.computeIfAbsent(longs[3], k -> new ArrayList<>()).add(i);
        }
        arr = set.toArray(new Long[0]);
        Arrays.sort(arr);
        // 按照y进行扫描
        int max = 0;
        // 差分数组
        int[] d = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            Long y = arr[i];
            // 把下边缘是y的放入
            List<Integer> list = addY.get(y);
            if (list != null) {
                for (Integer id : list) {
                    long[] re = rec[id];
                    int l = xi.get(re[0]);
                    int r = xi.get(re[2]);
                    d[l]++;
                    d[r + 1]--;
                }
            }
            // 通过差分数组计算
            for (int i1 = 0, t = 0; i1 <= n; i1++) {
                t += d[i1];
                max = Math.max(max, t);
            }
            // 把上边缘是x的取出
            list = subY.get(y);
            if (list != null) {
                for (Integer id : list) {
                    long[] re = rec[id];
                    int l = xi.get(re[0]);
                    int r = xi.get(re[2]);
                    d[l]--;
                    d[r + 1]++;
                }
            }
        }
        return max;
    }
}
