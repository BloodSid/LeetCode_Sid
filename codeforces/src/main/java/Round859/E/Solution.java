package Round859.E;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-03-19 23:18
 */
public class Solution {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int cases = 0; cases < N; cases++) {
            int n = sc.nextInt();
            int[] cnt = new int[n];
            for (int i = 0; i < n; i++) {
                cnt[i] = sc.nextInt();
            }
            int[] p = new int[n + 1];
            for (int i = 0, t = 0; i < n; i++) {
                t += cnt[i];
                p[i + 1] = t;
            }
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = left + right >> 1;
                if (query(left + 1, mid + 1) == p[mid + 1] - p[left]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            System.out.println("! " + (left + 1));
        }
    }

    static int query(int left, int right) {
        StringBuilder sb = new StringBuilder();
        sb.append("? ").append(right - left + 1);
        for (; left <= right; left++) {
            sb.append(' ').append(left);
        }
        System.out.println(sb);
        System.out.flush();
        return sc.nextInt();
    }
}
