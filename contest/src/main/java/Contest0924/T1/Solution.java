package Contest0924.T1;

/**
 * @author IronSid
 * @since 2022-09-24 17:13
 */
public class Solution {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int[] trendA = new int[n - 1];
        int[] trendB = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (temperatureA[i + 1] - temperatureA[i] == 0) trendA[i] = 0;
            else if (temperatureA[i + 1] - temperatureA[i] >= 0) trendA[i] = 1;
            else trendA[i] = 2;
        }
        for (int i = 0; i < n - 1; i++) {
            if (temperatureB[i + 1] - temperatureB[i] == 0) trendB[i] = 0;
            else if (temperatureB[i + 1] - temperatureB[i] >= 0) trendB[i] = 1;
            else trendB[i] = 2;
        }
        int max = 0;
        for (int i = 0, dp = 0; i < trendA.length; i++) {
            if (trendA[i] == trendB[i]) dp++;
            else dp = 0;
            max = Math.max(max, dp);
        }
        return max;
    }
}
