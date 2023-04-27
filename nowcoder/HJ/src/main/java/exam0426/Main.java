package exam0426;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 示例，结果是2
        System.out.println(solve1(new long[][]{{6, 2}, {2, 1},{100,100}}, 3, 2));
        System.out.println(solve2(new long[][]{{6, 2}, {2, 1},{100,100}}, 3, 2));
        System.out.println(solve3(new long[][]{{6, 2}, {2, 1},{100,100}}, 3, 2));

        Random r = new Random();
        // 坐标范围
        int bound = (int) 1e9;
        // 草种类
        int N = 50;
        int T = (int) 1e8;
        for (int ti = 0; ti < T; ti++) {
            int M = r.nextInt(10) + 1;
            long[][] loc = new long[N][];
            for (int i = 0; i < N; i++) {
                loc[i] = new long[]{r.nextInt(bound) + 1, r.nextInt(bound) + 1};
            }
            // 对拍
            if (solve3(loc, N, M) != solve1(loc, N, M)) {
                System.out.println("--------------");
                System.out.println(Arrays.toString(loc));
                System.out.println("N = " + N);
                System.out.println("M = " + M);
                break;
            }
            if ((ti & 0b11111111111111) == 0) System.out.println(ti);
        }
    }

    // 二分加扫描线 正解
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

    // 二分 + 枚举 不满足数据范围，只过 18%
    static long solve2(long[][] ss, int N, int M) {
        long maxx = 0, maxy = 0;
        for (int i = 0; i < N; i++) {
            maxx = Math.max(maxx, ss[i][0]);
            maxy = Math.max(maxy, ss[i][1]);
        }
        int m = (int) (maxx + 1); int n = (int) (maxy + 1);
        long l = 0, r = Math.max(maxx, maxy);
        while (l <= r) {
            long mid = l + r >> 1;
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int cnt = 0;
                    for (long[] s : ss) {
                        if (Math.max(Math.abs(i - s[0]), Math.abs(j - s[1])) <= mid) {
                            cnt++;
                        }
                    }
                    max = Math.max(max, cnt);
                }
            }
            if (max >= M) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 贪心 + 排序 存在漏洞，能过大多数
    static long solve3(long[][] points, int N, int M) {
        Arrays.sort(points, (o1, o2) -> (int) (o1[0] - o2[0]));
        int l = -1, r = (int) 1e9;
        while (l + 1 < r) {
            int mid = l + (r - l >> 1);
            if (valid(points, N, M, mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }

    private static boolean valid(long[][] points, int n, int m, int day) {
        int l = 0, r = 0;
        while (l < n) {
            while (r < n && points[r][0] <= points[l][0] + 2 * day) {
                r++;
            }
            if (getNum(points, l, r - 1, day) >= m) {
                return true;
            }
            l++;
        }
        return false;
    }

    private static int getNum(long[][] points, int l, int r, int day) {
        List<Long> ys = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            ys.add(points[i][1]);
        }
        Collections.sort(ys);
        int ret = 1, i = 0, j = 0, n = r - l + 1;
        while (i < n) {
            while (j < n && ys.get(j) <= ys.get(i) + 2 * day) {
                j++;
                ret = Math.max(ret, j - i);
            }
            i++;
        }
        return ret;
    }
}
