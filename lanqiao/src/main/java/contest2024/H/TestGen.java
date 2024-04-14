package contest2024.H;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author IronSid
 * @since 2024-04-14 20:34
 */
public class TestGen {
    static Random random = new Random();
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pr = new PrintWriter(System.out);
        int maxn = (int) 1e3;
        // n
        pr.print(maxn);
        Random r = new Random();
        pr.print(' ');
        // s
        pr.println(1 + r.nextInt(maxn));
        // w
        int[] w = new int[maxn];
        for (int i = 0; i < maxn; i++) {
            w[i] = i + 1;
        }
        shuffle(w);
        for (int i : w) {
            pr.print(i);
            pr.print(' ');
        }
        pr.println();
        // edges
        for (int v = 2; v <= maxn; v++) {
            int u = random.nextInt(v-1)+1;
            pr.println(u + " " + v);
        }
        pr.close();
    }

    public static void shuffle(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            swap(nums, i, i + random.nextInt(n - i));
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
