package leetcode.editor.cn;
//给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。 
//
// 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。 
//
// 示例 1: 
//
// 
//输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K",
//"L","M"]
//
//输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
// 
//
// 示例 2: 
//
// 
//输入: ["A","A"]
//
//输出: []
// 
//
// 提示： 
//
// 
// array.length <= 100000 
// 
// 👍 58 👎 0


import java.util.HashMap;

/**
 *  字母与数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-03-11 00:02:40 
 */
public class FindLongestSubarrayLcciSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findLongestSubarray(String[] array) {
        int maxLen = 0;
        int maxLeft = 0;
        // 记录字母和数字的频率的差值第一次出现的位置
        HashMap<Integer, Integer> first = new HashMap<>();
        // 空数组
        first.put(0, -1);
        for (int i = 0, d = 0; i < array.length; i++) {
            char c = array[i].charAt(0);
            if (c >= '0' && c <= '9') {
                d++;
            } else {
                d--;
            }
            // 两个前缀的频率差值相等，两个前缀相减的子数组字母和数字相同
            Integer j = first.get(d);
            if (j == null) {
                first.put(d, i);
            } else if (i - j > maxLen) {
                maxLen = i - j;
                maxLeft = j + 1;
            }
        }
        String[] res = new String[maxLen];
        for (int i = 0; i < maxLen; i++) {
            res[i] = array[i + maxLeft];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
