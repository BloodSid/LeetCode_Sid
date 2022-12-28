package leetcode.editor.cn;
//给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次： 
//
// 
// 选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。 
// 选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。 
// 前缀和后缀在字符串中任意位置都不能有交集。 
// 前缀和后缀包含的所有字符都要相同。 
// 同时删除前缀和后缀。 
// 
//
// 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ca"
//输出：2
//解释：你没法删除任何一个字符，所以字符串长度仍然保持不变。
// 
//
// 示例 2： 
//
// 
//输入：s = "cabaabac"
//输出：0
//解释：最优操作序列为：
//- 选择前缀 "c" 和后缀 "c" 并删除它们，得到 s = "abaaba" 。
//- 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "baab" 。
//- 选择前缀 "b" 和后缀 "b" 并删除它们，得到 s = "aa" 。
//- 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "" 。 
//
// 示例 3： 
//
// 
//输入：s = "aabccabba"
//输出：3
//解释：最优操作序列为：
//- 选择前缀 "aa" 和后缀 "a" 并删除它们，得到 s = "bccabb" 。
//- 选择前缀 "b" 和后缀 "bb" 并删除它们，得到 s = "cca" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含字符 'a'，'b' 和 'c' 。 
// 
// 👍 55 👎 0


/**
 * 删除字符串两端相同字符后的最短长度
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-12-28 21:27:44 
 */
public class MinimumLengthOfStringAfterDeletingSimilarEndsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumLength(String s) {
        char[] ch = s.toCharArray();
        int i = 0, j = ch.length - 1;
        // i = j 时，剩余长度 1，无法满足删除前缀和后缀均不为空的条件
        while (i < ch.length && i < j && ch[i] == ch[j]) {
            char c = ch[i];
            while (i <= j && ch[i] == c) i++;
            while (i <= j && ch[j] == c) j--;
        }
        return j - i + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
