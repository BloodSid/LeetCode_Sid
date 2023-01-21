package HJ93;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2022-02-11 18:26
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int[] nums = new int[a];
            for (int i = 0; i < a; i++) {
                nums[i] = in.nextInt();
            }
            System.out.println(canBeGrouped(nums));
        }
    }

    static int total = 0;
    static int n = 0;
    static int[] nums;

    static boolean canBeGrouped(int[] nums) {
        total = 0;
        n = nums.length;
        Main.nums = nums;
        for (int num : nums) {
            total += num;
        }
        if ((total & 1) == 1) return false;
        return dfs(0, 0);
    }

    static boolean dfs(int idx, int sum) {
        if (idx == n) {
            return sum == total >> 1;
        }
        int cur = nums[idx];
        if (cur % 3 == 0) {
            return dfs(idx + 1, sum + cur);
        } else if (cur % 5 == 0) {
            return dfs(idx + 1, sum);
        }
        return dfs(idx + 1, sum + cur) || dfs(idx + 1, sum);
    }
}
