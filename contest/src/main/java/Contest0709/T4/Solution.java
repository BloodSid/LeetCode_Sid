package Contest0709.T4;

/**
 * @author IronSid
 * @since 2022-07-09 22:21
 */
class Solution {
    // TODO 单调栈求出每个元素a前后最近的小于它的元素x,y，不再枚举长度，而是贪心地选取
    // 2334. 元素值大于变化阈值的子数组
    // x y 之间的子数组，此时该元素是[x,y]中最小值，且[x,y]是a为最小值的子数组中最长的一个。遍历所有的元素，这种最长子数组都不满足条件则返回 -1
    public int validSubarraySize(int[] nums, int threshold) {
        return -1;
    }
}
