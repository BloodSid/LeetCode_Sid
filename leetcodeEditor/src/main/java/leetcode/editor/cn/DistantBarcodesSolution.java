package leetcode.editor.cn;
//在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。 
//
// 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：barcodes = [1,1,1,2,2,2]
//输出：[2,1,2,1,2,1]
// 
//
// 示例 2： 
//
// 
//输入：barcodes = [1,1,1,1,2,2,3,3]
//输出：[1,3,1,3,2,1,2,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= barcodes.length <= 10000 
// 1 <= barcodes[i] <= 10000 
// 
//
// 👍 148 👎 0


import java.util.*;

/**
 * 距离相等的条形码
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-14 16:14:53 
 */
public class DistantBarcodesSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        if (n == 1) return barcodes;
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int barcode : barcodes) {
            f.merge(barcode, 1, Integer::sum);
        }
        int p = 0;
        // 如果有一个元素的出现次数过半，则先排列它
        int modeK = 0;
        for (Map.Entry<Integer, Integer> e : f.entrySet()) {
            int k = e.getKey(), t = e.getValue();
            if (t >= n / 2) {
                modeK = k;
                for (int i = 0; i < t; i++) {
                    barcodes[p % n] = k;
                    p += 2;
                }
                break;
            }
        }
        for (Map.Entry<Integer, Integer> e : f.entrySet()) {
            int k = e.getKey(), t = e.getValue();
            if (k == modeK) continue;
            for (int i = 0; i < t; i++) {
                if (p == n) p++;
                barcodes[p % n] = k;
                p += 2;
            }
        }
        return barcodes;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
