package Contest0304.T2;

public class Solution {
    public long coloredCells(int n) {
        long ans = 1;
        for (int i = 1; i < n; i++) {
            ans += 4L * i;
        }
        return ans;
    }
}
