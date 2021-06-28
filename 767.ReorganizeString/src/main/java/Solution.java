/**
 * https://leetcode-cn.com/problems/reorganize-string/
 *
 * @author IronSid
 * @create 2021-06-28 16:18
 */
public class Solution {
    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) return "";
        int[] count = new int[26];
        //数字母,若某个字母过多,返回空字符串
        for (int i = 0; i < s.length(); i++) {
            if (++count[s.charAt(i) - 'a'] > (s.length() + 1) / 2)
                return "";
        }
        //找出最多的字母
        int max = count[0], index = 0;
        for (int i = 1; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        //拼结果,从最多的字母开始放
        char[] output = new char[s.length()];
        int j = index;
        for (int i = 0; i < s.length(); i += 2) {
            while (count[j] == 0) {
                j++;
                j %= 26;
            }
            count[j]--;
            output[i] = (char) (j + 'a');
        }
        for (int i = 1; i < s.length(); i += 2) {
            while (count[j] == 0) {
                j++;
                j %= 26;
            }
            count[j]--;
            output[i] = (char) (j + 'a');
        }
        return new String(output);
    }
}