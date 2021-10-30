package leetcode.editor.cn;

import java.util.*;

/**
 * Excel表列名称
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-30 14:27:47 
 */
public class ExcelSheetColumnTitleSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int columnNumber) {
        char[] temp = Integer.toString(columnNumber, 26).toUpperCase().toCharArray();
        System.out.println(Integer.toString(columnNumber, 26));
        for (int i = 0; i < temp.length; i++) {
            // 把每一位转成数字0-25
            if(Character.isLetter(temp[i])) {
                temp[i] += 10 - 'A';
            } else {
                temp[i] -= '0';
            }
        }
        for (int i = temp.length - 1; i >= 0; i--) {
            // 若有一位是0，则从前一位“借一”
            if (temp[i] == 0) {
                if (i != 0) {
                    temp[i - 1]--;
                    temp[i] = 26;
                } else {
                    return new String(temp, 1, temp.length - 1);
                }
            }
            // 把数字1-26转成A-Z
            temp[i] += 'A' - 1;
        }
        return new String(temp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
