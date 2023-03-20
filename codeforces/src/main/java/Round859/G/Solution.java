package Round859.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author IronSid
 * @since 2023-03-20 0:23
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int cases = 0; cases < N; cases++) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            String line = br.readLine();
            int p = 0;
            int start = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ' ') {
                    a[p++] = Integer.parseInt(line.substring(start, i));
                    start = i + 1;
                }
            }
            a[p] = Integer.parseInt(line.substring(start));
            // Arrays.sort() 会超时
            sort(a);
            // 假设已经有序列 c1, c2...ck 那么这个序列的各个子序列的和，一定可以表示出[1, sum(c1, c2...ck)] 内的所有数字
            boolean flag = true;
            long sum = a[0];
            for (int i = 1; i < a.length; i++) {
                if (sum < a[i]) {
                    flag = false;
                    break;
                }
                sum += a[i];
            }
            if (a[0] != 1) flag = false;
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static void sort(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }
        int[] f = new int[max + 1];
        for (int i : a) {
            f[i]++;
        }
        int p = 0;
        for (int i = 1; i <= max; ) {
            if (f[i] > 0) {
                f[i]--;
                a[p++] = i;
            } else {
                i++;
            }
        }
    }
}
