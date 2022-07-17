package Contest0717;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-07-17 10:56
 */
public class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] res = new int[2];
        int[] f = new int[101];
        for (int num : nums) {
            f[num]++;
        }
        int cnt = 0;
        for (int i : f) {
            cnt += i / 2;
        }
        res[0] = cnt;
        res[1] = nums.length - cnt * 2;
        return res;
    }

    public int maximumSum(int[] nums) {
        List[] f = new List[90];
        for (int i = 0; i < f.length; i++) {
            f[i] = new ArrayList();
        }
        for (int num : nums) {
            int sum = 0, t = num;
            while (t != 0) {
                sum += t % 10;
                t /= 10;
            }
            f[sum].add(num);
        }
        int max = -1;
        for (List<Integer> list : f) {
            if (list.size() >= 2) {
                list.sort((o1, o2) -> o2 - o1);
                max = Math.max(max, list.get(0) + list.get(1));
            }
        }
        return max;
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int m = queries.length;
        int[] res = new int[m];
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int trim = queries[i][1];
            int begin = nums[0].length() - trim;
            Arrays.sort(idx, (o1, o2) -> {
                int c = nums[o1].substring(begin).compareTo(nums[o2].substring(begin));
                if (c != 0) return c;
                return o1 - o2;
            });
            res[i] = idx[queries[i][0] - 1];
        }
        return res;
    }

    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        if (nums[0] == 1) return 0;
        int gcd = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            gcd = gcd(gcd, numsDivide[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (gcd % nums[i] == 0) return i;
        }
        return -1;
    }
    int gcd(int a, int b) {
        // gcd(a,b) = gcd(b, a%b)
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) {

    }
}
