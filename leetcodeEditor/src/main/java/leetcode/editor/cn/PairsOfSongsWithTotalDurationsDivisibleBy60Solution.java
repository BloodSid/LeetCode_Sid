package leetcode.editor.cn;
//在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。 
//
// 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足 i < j 且有 (time[i] + 
//time[j]) % 60 == 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：time = [30,20,150,100,40]
//输出：3
//解释：这三对的总持续时间可被 60 整除：
//(time[0] = 30, time[2] = 150): 总持续时间 180
//(time[1] = 20, time[3] = 100): 总持续时间 120
//(time[1] = 20, time[4] = 40): 总持续时间 60
// 
//
// 示例 2： 
//
// 
//输入：time = [60,60,60]
//输出：3
//解释：所有三对的总持续时间都是 120，可以被 60 整除。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= time.length <= 6 * 10⁴ 
// 1 <= time[i] <= 500 
// 
//
// 👍 258 👎 0


/**
 * 总持续时间可被 60 整除的歌曲
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-07 20:57:48 
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60Solution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] f = new int[60];
        int cnt = 0;
        for (int t : time) {
            cnt += f[t % 60];
            f[60 - (t + 59) % 60 - 1]++;
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
