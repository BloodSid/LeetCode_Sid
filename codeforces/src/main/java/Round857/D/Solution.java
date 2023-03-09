package Round857.D;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-03-09 20:13
 */
public class Solution {

    private static Integer[] idx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int cases = 0; cases < N; cases++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }

            idx = new Integer[n];
            for (int i = 0; i < n; i++) {
                idx[i] = i;
            }
            System.out.println(Math.min(minDiff(a, b), minDiff(b, a)));
        }
    }

    static int minDiff(int[] a, int[] b) {
        int ans = Integer.MAX_VALUE;
        // 以 a 的大小逆序排序, b 的大小顺序
        int maxB = 0;
        Arrays.sort(idx, (o1, o2) -> a[o2] != a[o1] ? a[o2] - a[o1] : b[o1] - b[o2]);
        for (int i = 1; i < a.length; i++) {
            int maxA = a[idx[i]];
            maxB = Math.max(maxB, b[idx[i - 1]]);
            ans = Math.min(ans, Math.abs(maxA - maxB));
        }
        return ans;
    }
}
