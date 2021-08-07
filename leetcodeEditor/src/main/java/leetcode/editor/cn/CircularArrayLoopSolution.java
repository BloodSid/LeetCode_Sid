package leetcode.editor.cn;
//存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数： 
//
// 
// 如果 nums[i] 是正数，向前 移动 nums[i] 步 
// 如果 nums[i] 是负数，向后 移动 nums[i] 步 
// 
//
// 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。 
//
// 数组中的 循环 由长度为 k 的下标序列 seq ： 
//
// 
// 遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ... 
// 所有 nums[seq[j]] 应当不是 全正 就是 全负 
// k > 1 
// 
//
// 如果 nums 中存在循环，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,-1,1,2,2]
//输出：true
//解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1,2]
//输出：false
//解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
// 
//
// 示例 3: 
//
// 
//输入：nums = [-2,1,-1,-2,-2]
//输出：false
//解释：按下标 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为 nums[1] 是正数，而 nums[2] 是负数。
//所有 nums[seq[j]] 应当不是全正就是全负。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -1000 <= nums[i] <= 1000 
// nums[i] != 0 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(n) 且额外空间复杂度为 O(1) 的算法吗？ 
// Related Topics 数组 哈希表 双指针 
// 👍 150 👎 0


import java.util.*;

import static java.util.Arrays.*;
import static java.lang.Math.*;
import static java.lang.System.*;

/**
 * 环形数组是否存在循环
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-08-07 23:25:14
 */
public class CircularArrayLoopSolution {
    //ctrl+alt+a 加入版本控制

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean circularArrayLoop(int[] nums) {
            // 看作一个图，不断去除入度为零的点，从而找出循环，再判断循环的方向
            // 统计入度
            int len = nums.length;
            int[] inCount = new int[len];
            for (int i = 0; i < len; i++) {
                inCount[getSon(nums, i)]++;
            }
            // 把入度为零的节点放入队列
            Queue<Integer> queue = new ArrayDeque<>(len);
            for (int i = 0; i < inCount.length; i++) {
                if (inCount[i] == 0) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int rm = queue.poll();
                int son = getSon(nums, rm);
                if (--inCount[son] == 0) {
                    queue.offer(son);
                }
            }
            // 此时入度不为零的节点都在环上，需去除自环和方向不一致的环
            for (int i = 0; i < len; i++) {
                if (inCount[i] != 0) {
                    inCount[i]--;
                    if (nums[i] % len == 0) {
                        // 自环
                        continue;
                    }
                    boolean flag = true;
                    int son = getSon(nums, i);
                    while (son != i) {
                        inCount[son]--;
                        if (nums[i] > 0 != nums[son] > 0) {
                            flag = false;
                        }
                        son = getSon(nums, son);
                    }
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }

        int getSon(int[] nums, int parent) {
            int son = (parent + nums[parent]) % nums.length;
            if (son < 0) {
                son += nums.length;
            }
            return son;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
