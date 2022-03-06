package leetcode.editor.cn;

import java.util.*;

/**
 * 替换数组中的非互质数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-06 13:14:55
 */
public class ReplaceNonCoprimeNumbersInArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        Deque<Integer> stack = list;
        for (int num : nums) {
            while (!stack.isEmpty() && gcd(num, stack.peekLast()) > 1) {
                int top = stack.pollLast();
                num = num / gcd(num, top) * top;
            }
            stack.offerLast(num);
        }
        return list;
    }

    int gcd(int a, int b) {
        // gcd(a,b) = gcd(b,a mod b)
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
