package leetcode.editor.cn;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 全 O(1) 的数据结构
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-16 00:03:39
 */
public class AllOoneDataStructureSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class AllOne {
    private HashMap<String, Integer> freq;
    private PriorityQueue<String> minHeap;
    private PriorityQueue<String> maxHeap;

    public AllOne() {
        freq = new HashMap<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> freq.get(o2) - freq.get(o1));
        minHeap = new PriorityQueue<>((o1, o2) -> freq.get(o1) - freq.get(o2));
    }

    public void inc(String key) {
        int f = freq.getOrDefault(key, 0);
        freq.put(key, f + 1);
        maxHeap.remove(key);
        minHeap.remove(key);
        maxHeap.add(key);
        minHeap.add(key);
    }

    public void dec(String key) {
        int f = freq.get(key);
        if (f == 1) {
            freq.remove(key);
            minHeap.remove(key);
            maxHeap.remove(key);
        } else {
            freq.put(key, f - 1);
            maxHeap.remove(key);
            minHeap.remove(key);
            maxHeap.add(key);
            minHeap.add(key);
        }
    }

    public String getMaxKey() {
        if (freq.isEmpty()) {
            return "";
        }
        return maxHeap.peek();
    }

    public String getMinKey() {
        if (freq.isEmpty()) {
            return "";
        }
        return minHeap.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
