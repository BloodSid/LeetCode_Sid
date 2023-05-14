package Contest0514.T2;

/**
 * @author IronSid
 * @since 2023-05-14 16:46
 */
public class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] ori = new int[n];
        // 假设 ori0 是 0；ori(i+1) = ori(i) ^ der(i)
        for (int i = 1; i < n; i++) {
            ori[i] = ori[i - 1] ^ derived[i - 1];
        }
        return (ori[0] ^ ori[n - 1]) == derived[n - 1];
    }
}