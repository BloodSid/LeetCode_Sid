package Contest1113.T2;

/**
 * @author IronSid
 * @since 2022-11-13 10:30
 */
public class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int res  = 0;
        for (int i = 0; i < n; i++) {
            int lcm = 1;
            for (int j = i; j < n; j++) {
                lcm = (int) ((long) nums[j] * lcm / gcd(nums[j], lcm));
                if (lcm == k) res++;
                else if (lcm > k) break;
            }
        }
        return res;
    }

    int gcd(int a, int b) {
        // gcd(a,b) = gcd(b,a mod b)
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
