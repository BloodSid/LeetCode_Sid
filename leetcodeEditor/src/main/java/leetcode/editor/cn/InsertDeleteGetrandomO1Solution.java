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

    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    Random random = new Random();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            int idx = list.size();
            list.add(val);
            map.put(val, idx);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int idx = map.remove(val);
            int last = list.size() - 1;
            if (idx == last) {
                list.remove(last);
            } else {
                // 把list中被删除元素替换成list结尾的元素，再将list结尾删除一个元素
                int lastVal = list.get(last);
                list.set(idx, lastVal);
                list.remove(last);
                // 修改结尾元素在map中对应的下标
                map.put(lastVal, idx);
            }
            return true;
        }
        return false;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
