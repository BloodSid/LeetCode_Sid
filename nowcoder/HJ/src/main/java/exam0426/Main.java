package exam0426;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(solve1(new long[][]{{6, 2}, {2, 1},{100,100}}, 3, 2));
        Random r = new Random();
        // 坐标范围
        int bound = 100;
        // 草种类
        int N = 10;
        int M = r.nextInt(10) + 1;


    }

    static long solve1(long[][] loc, int N, int M) {
        int l = 0, r = (int) (1e9/2 + 10);
        while (l <= r) {
            int mid = l + (r - l >> 1);
            long[][] sq = new long[N][];
            for (int i = 0; i < N; i++) {
                sq[i] = new long[]{loc[i][0], loc[i][1], mid * 2L};
            }
            int cnt = maxOverlap(sq);
            if (cnt >= M) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int maxOverlap(long[][] forceField) {
        long[][] rec = new long[forceField.length][];
        int ri = 0;
        for (long[] ints : forceField) {
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
