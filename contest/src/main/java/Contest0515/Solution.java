package Contest0515;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-05-15 10:32
 */
public class Solution {
    // T1
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        int[] freq = new int[26];
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        for (int i = 1; i < n; i++) {
            for (char c : words[i - 1].toCharArray()) {
                freq[c - 'a']++;
            }
            for (char c : words[i].toCharArray()) {
                freq[c - 'a']--;
            }
            for (int i1 = 0; i1 < 26; i1++) {
                if (freq[i1] != 0) {
                    res.add(words[i]);
                    break;
                }
            }
            Arrays.fill(freq, 0);
        }
        return res;
    }

    // T2
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int n = special.length;
        int max = Math.max(top - special[special.length - 1], special[0] - bottom);
        for (int i = 1; i < n; i++) {
            max = Math.max(max, special[i] - special[i - 1] - 1);
        }
        return max;
    }

    // T3
    public int largestCombination(int[] candidates) {
        int[] freq = new int[32];
        for (int i = 0; i < candidates.length; i++) {
            int num = candidates[i];
            for (int j = 0; j < 32 && (num >= 1 << j); j++) {
                if ((num & 1 << j) != 0) freq[j]++;
            }
        }
        int max = 0;
        for (int i = 0; i < freq.length; i++) {
            max = Math.max(max, freq[i]);
        }
        return max;
    }

    @Test
    public void CountIntervalsTest1() {
        CountIntervals countIntervals = new CountIntervals(); // 用一个区间空集初始化对象
        countIntervals.add(2, 3);  // 将 [2, 3] 添加到区间集合中
        countIntervals.add(7, 10); // 将 [7, 10] 添加到区间集合中
        Assert.assertEquals(6, countIntervals.count());   // 返回 6
        // 整数 2 和 3 出现在区间 [2, 3] 中
        // 整数 7、8、9、10 出现在区间 [7, 10] 中
        countIntervals.add(5, 8);  // 将 [5, 8] 添加到区间集合中
        Assert.assertEquals(8, countIntervals.count());    // 返回 8
        // 整数 2 和 3 出现在区间 [2, 3] 中
        // 整数 5 和 6 出现在区间 [5, 8] 中
        // 整数 7 和 8 出现在区间 [5, 8] 和区间 [7, 10] 中
        // 整数 9 和 10 出现在区间 [7, 10] 中
    }

    @Test
    public void CountIntervalsTest2() {
        //["CountIntervals","count","add","add","add","add","add","count","add","add"]
        //[[],[],[8,43],[13,16],[26,33],[28,36],[29,37],[],[34,46],[10,23]]
        CountIntervals countIntervals = new CountIntervals();
        Assert.assertEquals(0, countIntervals.count());
        countIntervals.add(8, 43);
        countIntervals.add(13, 16);
        countIntervals.add(26,33);
        countIntervals.add(28,36);
        countIntervals.add(29,37);
        Assert.assertEquals(36, countIntervals.count());
        countIntervals.add(34,46);
        countIntervals.add(10,23);

    }


}

// T4
class CountIntervals {
    class Node {
        int l, r, v;
        Node left, right;

        public Node(int l, int r, int v) {
            this.l = l;
            this.r = r;
            this.v = v;
        }
    }

    Node root = new Node(1, (int) 1e9, 0);

    public CountIntervals() {

    }

    int update(Node node, int left, int right) {
        int mid = node.l + node.r >> 1;
        int oldV = node.v;
        if (left <= node.l && node.r <= right) {
            node.v = node.r - node.l + 1;
            return node.v - oldV;
        }
        if (left <= mid) {
            if (node.left == null) node.left = new Node(node.l, mid, 0);
            node.v += update(node.left, left, right);
        }
        if (right > mid) {
            if (node.right == null) node.right = new Node(mid + 1, node.r, 0);
            node.v += update(node.right, left, right);
        }
        return node.v - oldV;
    }

    public void add(int left, int right) {
        update(root, left, right);
    }

    public int count() {
        return root.v;
    }

}


