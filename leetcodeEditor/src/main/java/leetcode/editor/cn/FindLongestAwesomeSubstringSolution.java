package leetcode.editor.cn;
//给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。 
//
// 「超赞子字符串」需满足满足下述两个条件： 
//
// 
// 该字符串是 s 的一个非空子字符串 
// 进行任意次数的字符交换后，该字符串可以变成一个回文字符串 
// 
//
// 
//
// 示例 1： 
//
// 输入：s = "3242415"
//输出：5
//解释："24241" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "24142"
// 
//
// 示例 2： 
//
// 输入：s = "12345678"
//输出：1
// 
//
// 示例 3： 
//
// 输入：s = "213123"
//输出：6
//解释："213123" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "231132"
// 
//
// 示例 4： 
//
// 输入：s = "00"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s 仅由数字组成 
// 
// Related Topics 位运算 哈希表 字符串 
// 👍 53 👎 0


import java.util.*;

/**
 * 找出最长的超赞子字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-09-04 23:49:30
 */
public class FindLongestAwesomeSubstringSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestAwesome(String s) {
        char[] cs = s.toCharArray();
        int[] preSum = new int[cs.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] ^ (1 << (cs[i - 1] - '0'));
        }
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            if (map.containsKey(preSum[i])) {
                max = Math.max(max, i - map.get(preSum[i]));
            }
            for (int j = 0; j <= 9; j++) {
                int temp = preSum[i] ^ (1 << j);
                if (map.containsKey(temp)) {
                    max = Math.max(max, i - map.get(temp));
                }
            }
            map.putIfAbsent(preSum[i], i);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
