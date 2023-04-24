package Round867.G;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-04-24 23:13
 */
public class Main {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int j : a) {
            f.merge(j, 1, Integer::sum);
        }
        Integer[] k = f.keySet().toArray(new Integer[0]);
        Arrays.sort(k);
        long res = 0;
        for (int i = 0; i < k.length; i++) {
            Integer cnt = f.get(k[i]);
            if (cnt >= 3) res += (long) cnt * (cnt - 1) * (cnt - 2);
            for (int j = i + 1; j < k.length; j++) {
                if (k[j] % k[i] == 0) {
                    res += (long) cnt * f.get(k[j]) * f.getOrDefault(k[j] * (k[j] / k[i]), 0);
                }
            }
        }
        System.out.println(res);
    }
}
