package Contest1029.T4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * @author IronSid
 * @since 2022-10-29 22:27
 */
public class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        // 记录下两个更大元素的位置
        int[] next = new int[n];
        Integer[] k = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        // 按元素的大小顺序，元素的位置逆序依次排列
        Arrays.sort(k, (p, q) -> nums[p] == nums[q] ? p - q : nums[q] - nums[p]);
        // 存元素的位置
        TreeSet<Integer> list = new TreeSet<>();
        for (Integer i : k) {
            Iterator<Integer> it = list.tailSet(i, false).iterator();
            Integer j = null;
            int p = 0;
            while (p < 2 && it.hasNext()) {
                j = it.next();
                p++;
            }
            next[i] = p < 2 ? -1 : nums[j];
            list.add(i);
        }
        return next;
    }
}
