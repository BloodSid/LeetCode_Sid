package Contest0319_1.T1;

public class Solution {
    public int distMoney(int money, int children) {
        int[] c = new int[children];
        for (int i = 0; i < c.length; i++) {
            c[i]++;
            money--;
        }
        if (money < 0) return -1;
        for (int i = 0; i < c.length; i++) {
            int d = Math.min(7, money);
            money -= d;
            c[i] += d;
            if (money == 0) {
                if (c[i] == 4 && i == c.length - 1) {
                    return Math.max(0, i - 1);
                } else if (c[i] == 8){
                    return i + 1;
                } else {
                    return i;
                }
            }
        }
        // 最后 money 不为 0
        return children - 1;
    }
}
