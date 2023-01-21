package contest0123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-01-23 11:10
 */
public class Solution {
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int cnt = 0;
        for (int num : nums) {
            if (num != min && num != max) {
                cnt++;
            }
        }
        return cnt;
    }

    public int[] rearrangeArray(int[] nums) {
        int p1 = 0;
        int p2 = 1;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num > 0) {
                res[p1] = num;
                p1 += 2;
            } else {
                res[p2] = num;
                p2 += 2;
            }
        }
        return res;
    }

    public List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i] - 1) {
                continue;
            }
            if (i < nums.length - 1 && nums[i + 1] <= nums[i] + 1) {
                continue;
            }
            res.add(nums[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {10, 5, 6, 8};
        Solution solution = new Solution();
        List<Integer> list = solution.findLonely(arr);
        System.out.println(list);
    }
}

