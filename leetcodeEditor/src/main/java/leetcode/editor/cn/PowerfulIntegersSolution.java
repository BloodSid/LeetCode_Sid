package leetcode.editor.cn;
//给定三个整数 x 、 y 和 bound ，返回 值小于或等于 bound 的所有 强整数 组成的列表 。 
//
// 如果某一整数可以表示为 xⁱ + yʲ ，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个 强整数 。 
//
// 你可以按 任何顺序 返回答案。在你的回答中，每个值 最多 出现一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2, y = 3, bound = 10
//输出：[2,3,4,5,7,9,10]
//解释： 
//2 = 2⁰ + 3⁰
//3 = 2¹ + 3⁰
//4 = 2⁰ + 3¹
//5 = 2¹ + 3¹
//7 = 2² + 3¹
//9 = 2³ + 3⁰
//10 = 2⁰ + 3² 
//
// 示例 2： 
//
// 
//输入：x = 3, y = 5, bound = 15
//输出：[2,4,6,8,10,14]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x, y <= 100 
// 0 <= bound <= 10⁶ 
// 
//
// 👍 61 👎 0


import java.util.*;

/**
 * 强整数
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-01 23:56:11 
 */
public class PowerfulIntegersSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list = new ArrayList<>();
        if (x == 1 && y == 1) {
            if (2 <= bound) {
                list.add(2);
            }
            return list;
        } else if (x == 1 || y == 1) {
            int a = x != 1 ? x : y;
            for (int b = 1; b <= bound - 1; b *= a) {
                list.add(1 + b);
            }
            return list;
        }
        HashSet<Integer> set = new HashSet<>();
        // 枚举
        for (int a = 1; a <= bound - 1; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                set.add(a + b);
            }
        }
        return new ArrayList<>(set);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
