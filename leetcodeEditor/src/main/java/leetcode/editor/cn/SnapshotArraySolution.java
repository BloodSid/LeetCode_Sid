package leetcode.editor.cn;
//实现支持下列接口的「快照数组」- SnapshotArray： 
//
// 
// SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。 
// void set(index, val) - 会将指定索引 index 处的元素设置为 val。 
// int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。 
// int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。 
// 
//
// 
//
// 示例： 
//
// 输入：["SnapshotArray","set","snap","set","get"]
//     [[3],[0,5],[],[0,6],[0,0]]
//输出：[null,null,0,null,5]
//解释：
//SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
//snapshotArr.set(0,5);  // 令 array[0] = 5
//snapshotArr.snap();  // 获取快照，返回 snap_id = 0
//snapshotArr.set(0,6);
//snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5 
//
// 
//
// 提示： 
//
// 
// 1 <= length <= 50000 
// 题目最多进行50000 次set，snap，和 get的调用 。 
// 0 <= index < length 
// 0 <= snap_id < 我们调用 snap() 的总次数 
// 0 <= val <= 10^9 
// 
// 👍 93 👎 0


import java.util.*;

/**
 * 快照数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-18 15:13:49 
 */
public class SnapshotArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class SnapshotArray {

    private final List<Integer>[] value;
    private final List<Integer>[] id;
    private int snap;

    public SnapshotArray(int length) {
        id = new List[length];
        value = new List[length];
        snap = 0;
    }
    
    public void set(int index, int val) {
        if (value[index] == null) {
            value[index] = new ArrayList<>();
            id[index] = new ArrayList<>();
        }
        value[index].add(val);
        id[index].add(snap);
    }
    
    public int snap() {
        return snap++;
    }
    
    public int get(int index, int snap_id) {
        if (value[index] == null) return 0;
        int l = 0, r = value[index].size() - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (id[index].get(mid) > snap_id) r = mid - 1;
            else l = mid + 1;
        }
        return r == -1 ? 0 : value[index].get(r);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
