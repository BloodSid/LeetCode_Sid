package leetcode.editor.cn;

/**
 * 区域和检索 - 数组可修改
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-04 15:01:26
 */
public class RangeSumQueryMutableSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {

    int[] tree;

    int lowBit(int x) {
        return x & -x;
    }

    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowBit(i)) {
            ans += tree[i];
        }
        return ans;
    }

    void add(int x, int u) {
        for (int i = x; i <= n; i += lowBit(i)) {
            tree[i] += u;
        }
    }

    private int[] nums;
    private int n;

    public NumArray(int[] nums) {
        n = nums.length;
        this.nums = nums;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
