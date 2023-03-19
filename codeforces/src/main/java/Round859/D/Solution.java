package Round859.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author IronSid
 * @since 2023-03-19 23:08
 */
public class Solution {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            for (int cases = 0; cases < N; cases++) {
                String[] split = br.readLine().split(" ");
                int n = Integer.parseInt(split[0]);
                int q = Integer.parseInt(split[1]);
                int[] a = new int[n];
                String line = br.readLine();
                int pl = 0;
                int j = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ' ') {
                        a[pl++] = Integer.parseInt(line.substring(j, i));
                        j = i + 1;
                    }
                }
                a[pl] = Integer.parseInt(line.substring(j));
            int[] p = new int[n + 1];
            for (int i = 0, t = 0; i < n; i++) {
                t += a[i];
                p[i + 1] = t;
            }
            for (int i = 0; i < q; i++) {
                String[] query = br.readLine().split(" ");
                int l = Integer.parseInt(query[0]);
                int r = Integer.parseInt(query[1]);
                int k = Integer.parseInt(query[2]) % 2;
                if ((p[n] - p[r] + p[l - 1] + k * (r - l + 1)) % 2 == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
