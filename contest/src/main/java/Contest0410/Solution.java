package Contest0410;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2022-04-10 10:59
 */
public class Solution {
    public int largestInteger(int num) {
        char[] ch = ("" + num).toCharArray();
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] % 2 == 1) {
                odd.add(i);
            } else {
                even.add(i);
            }
        }
        odd.sort((o1, o2) -> ch[o2] - ch[o1]);
        even.sort((o1, o2) -> ch[o2] - ch[o1]);
        char[] res = new char[ch.length];
        int x = 0, y = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] % 2 == 1) {
                res[i] = ch[odd.get(x++)];
            } else {
                res[i] = ch[even.get(y++)];
            }
        }
        return Integer.parseInt(new String(res));
    }

    public String minimizeResult(String expression) {
        String[] nums = expression.split("\\+");
        int min = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < nums[0].length(); i++) {
            int n1;
            if (i == 0) {
                n1 = 1;
            } else {
                n1 = Integer.parseInt(nums[0].substring(0, i));
            }
            int n2 = Integer.parseInt(nums[0].substring(i));
            for (int j = 0; j < nums[1].length(); j++) {
                int n4;
                if (j == 0) {
                    n4 = 1;
                } else {
                    n4 = Integer.parseInt(nums[1].substring(nums[1].length() - j));
                }
                int n3 = Integer.parseInt(nums[1].substring(0, nums[1].length() - j));
                if ((n2 + n3) * n1 * n4 < min) {
                    min = (n2 + n3) * n1 * n4;
                    res = nums[0].substring(0, i) + "(" + nums[0].substring(i) + "+" + nums[1].substring(0, nums[1].length() - j) + ")" + nums[1].substring(nums[1].length() - j);
                }
            }
        }
        return res;
    }

    int MOD = (int) (1e9 + 7);

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        for (int i = 0; i < k; i++) {
            int val = pq.poll();
            pq.offer(val + 1);
        }
        Integer[] res = pq.toArray(new Integer[0]);
        long product = 1;
        for (Integer re : res) {
            product = product * re % MOD;
        }
        return (int) product;
    }

    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        Arrays.sort(flowers);
        long max = 0;
        for (int i = flowers.length; i >= 0; i--) {
            long remain = newFlowers;
            for (int j = i; j < flowers.length; j++) {
                remain -= Math.max(0, target - flowers[j]);
            }
            int l = 0, r = target - 1;
            long cost = 0;
            while (l <= r) {
                int mid = l + r >> 1;
                for (int j = 0; j < i; j++) {
                    cost += Math.max(0, mid - flowers[j]);
                }
                if (cost <= remain) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            long res = (long) r * partial + (long) (flowers.length - i) * full;
            max = Math.max(max, res);
        }
        return max;
    }

}
