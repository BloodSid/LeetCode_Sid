package Round867.E;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-04-24 23:44
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
        char[] s = sc.next().toCharArray();
        if (n % 2 == 1) {
            System.out.println(-1);
            return;
        }
        // 鸽笼原理：如果有一个字母占s的一半以上，则必无结果
        int[] f = new int[128];
        for (char c : s) {
            f[c]++;
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (f[c] > n / 2) {
                System.out.println(-1);
                return;
            }
        }

        // 记录需要进行交换的字母对
        List<Integer>[] idx = new List[128];
        for (char c = 'a'; c <= 'z'; c++) {
            idx[c] = new ArrayList<>();
        }
        int cnt = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s[i] == s[n - i - 1]) {
                idx[s[i]].add(i);
                cnt++;
            }
        }
        if (cnt == 0) {
            System.out.println(0);
            return;
        }
        // 若需要交换的字母对中，有字母占总数过半，则这个字母的交换需要单独处理
        boolean flag = false;
        int max = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (idx[c].size() > cnt / 2) {
                max = idx[c].size();
                flag = true;
            }
        }
        if (flag) {
            System.out.println(max);
        } else {
            System.out.println((cnt + 1) / 2);
        }

    }
}
