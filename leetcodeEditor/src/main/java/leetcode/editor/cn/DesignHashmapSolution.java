package leetcode.editor.cn;

import java.util.*;

/**
 * 设计哈希映射
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-05 20:27:39
 */
public class DesignHashmapSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class MyHashMap {
    int[] hash;

    public MyHashMap() {
        hash = new int[1_000_001];
        Arrays.fill(hash, -1);
    }

    public void put(int key, int value) {
        hash[key] = value;
    }

    public int get(int key) {
        return hash[key];
    }

    public void remove(int key) {
        hash[key] = -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
