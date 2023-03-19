package Round859.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
            int left = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ' ') {
                    a[p++] = Integer.parseInt(line.substring(left, i));
                    left = i + 1;
                }
            }
            a[p] = Integer.parseInt(line.substring(left));
            Arrays.sort(a);
            boolean flag = true;
            boolean[] h = new boolean[5001];
            int max = 1;
            h[1] = true;
            for (int i = 1; i < n; i++) {
                if (!h[a[i]]) {
                    flag = false;
                    break;
                }
                for (int j = 1; j <= max; j++) {
                    if (h[j]) {
                        if (j + a[i] <= 5000) {
                            h[j + a[i]] = true;
                        }
                    }
                }
                max = Math.max(max, max + a[i]);
            }
            if (a.length == 1 && a[0] != 1) flag = false;
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}