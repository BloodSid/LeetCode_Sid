package Round867.B;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * @author IronSid
 * @since 2023-04-24 23:11
 */
public class Main {
    static Scanner sc;
    static Random random = new Random();


    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (n == 2) {
            System.out.println(a[0] * a[1]);
            return;
        }
        shuffle(a);
        Arrays.sort(a);
        long max = Long.MIN_VALUE;
        max = Math.max(max, a[0] * a[1]);
        max = Math.max(max, a[n - 1] * a[n - 2]);
        System.out.println(max);
    }

    public static void shuffle(long[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            swap(nums, i, i + random.nextInt(n - i));
        }
    }

    private static void swap(long[] nums, int i, int j) {
        long t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
