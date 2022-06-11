package Contest0611;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author IronSid
 * @since 2022-06-11 22:14
 */
public class Solution {
    // T1
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        int lower = 0, upper = 0, digit = 0, special = 0;
        char[] ch = password.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (i > 0 && ch[i] == ch[i - 1]) return false;
            if (ch[i] >= 'a' && ch[i] <= 'z') {
                lower++;
            } else if (ch[i] >= 'A' && ch[i] <= 'Z') {
                upper++;
            } else if (ch[i] >= '0' && ch[i] <= '9') {
                digit++;
            } else {
                special++;
            }
        }
        if (lower == 0 || upper == 0 || digit == 0 || special == 0) return false;
        return true;
    }

    // T2
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = m - 1;
            while (l <= r) {
                int mid = l + r >> 1;
                if ((long) spells[i] * potions[mid] < success) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            res[i] = m - l;
        }
        return res;
    }

    // T3
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        for (char[] mapping : mappings) {
            if (!map.containsKey(mapping[0])) {
                map.put(mapping[0], new HashSet<>());
            }
            map.get(mapping[0]).add(mapping[1]);
        }
        char[] ch = s.toCharArray();
        char[] subCh = sub.toCharArray();
        int n = ch.length, m = subCh.length;
        loop:
        for (int start = 0; start <= n - m; start++) {
            for (int i = start, j = 0; j < m; j++, i++) {
                if (subCh[j] != ch[i] && !(map.containsKey(subCh[j]) && map.get(subCh[j]).contains(ch[i]))) {
                    continue loop;
                }
            }
            return true;
        }
        return false;
    }

    // T4
    public long countSubarrays(int[] nums, long k) {
        long cnt = 0;
        long sum = 0;
        int n = nums.length;
        int l = 0, r = 0;
        for (; r < n; r++) {
            sum += nums[r];
            for (; l <= r; l++) {
                if (k > sum * (r - l + 1)) {
                    break;
                }
                sum -= nums[l];
            }
            cnt += r - l + 1;
        }
        return cnt;
    }
}
