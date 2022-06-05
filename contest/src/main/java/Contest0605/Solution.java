package Contest0605;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author IronSid
 * @since 2022-06-05 10:24
 */
public class Solution {
    // T1
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        int[] newNums;
        for (; n > 1; nums = newNums) {
            newNums = new int[n / 2];
            for (int i = 0; i < n / 2; i++) {
                if (i % 2 == 0) newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                else newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
            n /= 2;
        }
        return nums[0];
    }
    // T2
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int part = 1;
        int n = nums.length;
        for (int start = 0, end = 0; end < n; ) {
            if (nums[start] + k >= nums[end]) {
                end++;
            } else {
                part++;
                start = end;
            }
        }
        return part;
    }
    // T3
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> valToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valToIdx.put(nums[i], i);
        }
        for (int[] operation : operations) {
            int oldVal = operation[0], newVal = operation[1];
            int idx = valToIdx.get(oldVal);
            valToIdx.remove(oldVal);
            valToIdx.put(newVal, idx);
        }
        int[] res = new int[nums.length];
        for (Map.Entry<Integer, Integer> entry : valToIdx.entrySet()) {
            res[entry.getValue()] = entry.getKey();
        }
        return res;
    }



}
// T4
class TextEditor {

    private final StringBuilder sb;
    private int cursor;

    public TextEditor() {
        sb = new StringBuilder();
        cursor = 0;
    }

    public void addText(String text) {
        sb.insert(cursor, text);
        cursor += text.length();
    }

    public int deleteText(int k) {
        int start = Math.max(0, cursor - k);
        sb.delete(start, cursor);
        int delete = cursor - start;
        cursor = start;
        return delete;
    }

    public String cursorLeft(int k) {
        cursor = Math.max(0, cursor - k);
        return sb.substring(Math.max(0, cursor - 10), cursor);
    }

    public String cursorRight(int k) {
        cursor = Math.min(sb.length(), cursor + k);
        return sb.substring(Math.max(0, cursor - 10), cursor);
    }
}

