package leetcode.editor.cn;

import java.util.*;

/**
 * O(1) 时间插入、删除和获取随机元素
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-13 00:26:49 
 */
public class InsertDeleteGetrandomO1Solution {
//leetcode submit region begin(Prohibit modification and deletion)
class RandomizedSet {

    HashSet<Integer> set = new HashSet<>();
    Random random = new Random();

    public RandomizedSet() {

    }
    
    public boolean insert(int val) {
        return set.add(val);
    }
    
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    public int getRandom() {
        int size = set.size();
        for (Integer i : set) {
            if (random.nextInt(size--) == 0) return i;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
