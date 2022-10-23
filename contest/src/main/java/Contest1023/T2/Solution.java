package Contest1023.T2;

/**
 * @author IronSid
 * @since 2022-10-23 10:52
 */
public class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int gcd = nums[i];
            for (int j = i; j < n; j++) {
                gcd = gcd(gcd, nums[j]);
                if (gcd == k) cnt++;
            }
        }
        return cnt;
    }

    int gcd(int a, int b) {
        // gcd(a,b) = gcd(b,a mod b)
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}
