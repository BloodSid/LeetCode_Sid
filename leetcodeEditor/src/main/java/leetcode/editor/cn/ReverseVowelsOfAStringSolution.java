package leetcode.editor.cn;
//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 168 👎 0


import java.util.*;

/**
 * 反转字符串中的元音字母
 *
 * @author IronSid
 * @since 2021-08-19 00:13:53 
 * @version 1.0
 */
public class ReverseVowelsOfAStringSolution {
    //ctrl+alt+a 加入版本控制

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] str = s.toCharArray();
        int left = -1;
        int right = str.length;
        while (left < right) {
            left++;
            right--;
            while (left < str.length && !isVowel(str[left])) {
                left++;
            }
            while (right > left && !isVowel(str[right])) {
                right--;
            }
            if (left < right) {
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
            }
        }
        return new String(str);
    }

    boolean isVowel(char chr) {
        char[] vowels = "aeiouAEIOU".toCharArray();
        for (char vowel : vowels) {
            if (vowel == chr) {
                return true;
            }
        }
        return false;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
