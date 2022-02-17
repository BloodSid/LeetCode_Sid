package leetcode.editor.cn;

import java.util.*;

/**
 * 设计停车系统
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-17 11:06:45
 */
public class DesignParkingSystemSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class ParkingSystem {
    int big, medium, small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (big == 0) {
                    return false;
                }
                big--;
                break;
            case 2:
                if (medium == 0) {
                    return false;
                }
                medium--;
                break;
            case 3:
                if (small == 0) {
                    return false;
                }
                small--;
                break;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
