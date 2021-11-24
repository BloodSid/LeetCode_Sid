package leetcode.editor.cn;

import java.util.*;

/**
 * 根据字符出现频率排序
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-24 08:20:30
 */
public class SortCharactersByFrequencySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {
        char[] arr = s.toCharArray();
        int[] freq = new int[128];
        for (char c : arr) {
            freq[c]++;
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> freq[o2] - freq[o1]);
        for (char c = 0; c < 128; c++) {
            if (freq[c] != 0) {
                queue.offer(c);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            for (int i = 0; i < freq[ch]; i++) {
                arr[index] = ch;
                index++;
            }
        }
        return new String(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
