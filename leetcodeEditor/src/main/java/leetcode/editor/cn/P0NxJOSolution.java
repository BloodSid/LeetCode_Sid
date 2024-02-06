package leetcode.editor.cn;
//小扣当前位于魔塔游戏第一层，共有 `N` 个房间，编号为 `0 ~ N-1`。每个房间的补血道具/怪物对于血量影响记于数组 `nums`，其中正数表示道具补
//血数值，即血量增加对应数值；负数表示怪物造成伤害值，即血量减少对应数值；`0` 表示房间对血量无影响。
//
//**小扣初始血量为 1，且无上限**。假定小扣原计划按房间编号升序访问所有房间补血/打怪，**为保证血量始终为正值**，小扣需对房间访问顺序进行调整，**每
//次仅能将一个怪物房间（负数的房间）调整至访问顺序末尾**。请返回小扣最少需要调整几次，才能顺利访问所有房间。若调整顺序也无法访问完全部房间，请返回 -1。
//
//**示例 1：**
//
//> 输入：`nums = [100,100,100,-250,-60,-140,-50,-50,100,150]`
//>
//> 输出：`1`
//>
//> 解释：初始血量为 1。至少需要将 nums[3] 调整至访问顺序末尾以满足要求。
//
//**示例 2：**
//
//> 输入：`nums = [-200,-300,400,0]`
//>
//> 输出：`-1`
//>
//> 解释：调整访问顺序也无法完成全部房间的访问。
//
//**提示：**
//- `1 <= nums.length <= 10^5`
//- `-10^5 <= nums[i] <= 10^5`
//
// 👍 92 👎 0


import java.util.*;

/**
 * 魔塔游戏
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-02-06 17:34:00 
 */
public class P0NxJOSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int magicTower(int[] nums) {
        // 存储访问过的负数房间，最小的在堆顶
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 当前血量
        long sum = 1;
        // 挪到结尾的血量之和
        long tailSum = 0;
        int cnt = 0;
        for (int num : nums) {
            sum += num;
            if (num < 0) {
                pq.offer(num);
            }
            if (sum <= 0) {
                // 血量不足，反悔最小的一次扣血
                int poll = pq.poll();
                sum -= poll;
                tailSum += poll;
                cnt++;
            }
        }
        if (sum + tailSum < 0) {
            return -1;
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
