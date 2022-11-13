package Contest1113.T1;

/**
 * @author IronSid
 * @since 2022-11-13 10:30
 */
public class Solution {
    public double[] convertTemperature(double celsius) {
        double[] res = {celsius + 273.15, celsius * 1.8 + 32.0};
        return res;
    }
}
