package leetcode.editor.cn;

import java.util.*;

/**
 * 大礼包
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-24 10:40:52
 */
public class ShoppingOffersSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int n;
    int len;
    List<List<Integer>> special;
    List<Integer> price;
    int minTotal;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.n = price.size();
        this.special = special;
        len = special.size();
        this.price = price;
        int[] count = new int[len];
        Integer[] needsArray = needs.toArray(new Integer[0]);
        minTotal = Integer.MAX_VALUE;
        backtrack(0, count, needsArray);
        return minTotal;
    }

    void backtrack(int index, int[] count, Integer[] needsArray) {
        if (index == len) {
            minTotal = Math.min(minTotal, getTotal(count, needsArray));
            return;
        }
        List<Integer> cur = special.get(index);
        int maxCount = Integer.MAX_VALUE;
        // 计算当前礼包最多能买几套
        for (int i = 0; i < n; i++) {
            int quantity = cur.get(i);
            if (quantity == 0) {
                continue;
            }
            maxCount = Math.min(maxCount, needsArray[i] / quantity);
        }

        for (int i = 0; i <= maxCount; i++) {
            count[index] = i;
            if (i != 0) {
                for (int j = 0; j < n; j++) {
                    needsArray[j] -= cur.get(j);
                }
            }
            backtrack(index + 1, count, needsArray);
        }

        count[index] = 0;
        for (int i = 0; i < n; i++) {
            needsArray[i] += maxCount * cur.get(i);
        }
    }

    int getTotal(int[] count, Integer[] needs) {
        int total = 0;
        for (int i = 0; i < len; i++) {
            total += count[i] * special.get(i).get(n);
        }
        for (int i = 0; i < n; i++) {
            total += needs[i] * price.get(i);
        }
        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
