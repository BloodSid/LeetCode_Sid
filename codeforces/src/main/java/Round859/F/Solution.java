package Round859.F;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-03-19 23:45
 */
public class Solution {
    static HashMap<String, int[]> DIRS;
    static {
        DIRS = new HashMap<>();
        DIRS.put("DR", new int[]{1, 1});
        DIRS.put("DL", new int[]{1, -1});
        DIRS.put("UR", new int[]{-1, 1});
        DIRS.put("UL", new int[]{-1, -1});
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int cases = 0; cases < N; cases++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int i1 = sc.nextInt();
            int j1 = sc.nextInt();
            int i2 = sc.nextInt();
            int j2 = sc.nextInt();
            String D = sc.next();
            // d[0] 上下， d[1] 左右
            int[] d = DIRS.get(D).clone();
            HashSet<String> set = new HashSet<>();
            int cnt = 0;
            boolean flag = true;
            int i = i1, j = j1;
            while (true) {
                // 判断 点 2 在不在线上
                int di = i2 - i, dj = j2 - j;
                if (di * d[0] >= 0 && di * d[0] == dj * d[1]) {
                    break;
                }
                // 计算撞击点，
                int r0 = d[0] == 1 ? m - i : i - 1;
                int r1 = d[1] == 1 ? n - j : j - 1;
                int r = Math.min(r0, r1);
                i += r * d[0];
                j += r * d[1];
                cnt++;
                // 如果出现重复点，则中断
                if (!set.add(i + " " + j + D)) {
                    flag = false;
                    break;
                }
                // 拐弯
                if (i == 1 || i == m) {
                    d[0] = -d[0];
                }
                if (j == 1 || j == n) {
                    d[1] = -d[1];
                }
            }
            if (flag) {
                System.out.println(cnt);
            } else {
                System.out.println(-1);
            }
        }
    }
}
