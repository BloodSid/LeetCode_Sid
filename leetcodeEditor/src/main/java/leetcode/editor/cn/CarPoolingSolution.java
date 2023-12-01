package leetcode.editor.cn;
//车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向） 
//
// 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有
// numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。 
//
// 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
//
// 👍 288 👎 0


/**
 * 拼车
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-12-02 02:49:42 
 */
public class CarPoolingSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] d = new int[1002];
        for (int[] trip : trips) {
            int from = trip[1], to = trip[2];
            d[from] += trip[0];
            d[to] -= trip[0];
        }
        int num = 0;
        for (int i : d) {
            num += i;
            if (num > capacity) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
