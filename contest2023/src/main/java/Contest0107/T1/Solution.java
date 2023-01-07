package Contest0107.T1;

/**
 * @author IronSid
 * @since 2023-01-07 22:34
 */
public class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean heavy = mass >= 100;
        boolean bulky = length >= 10000 || width >= 10000 || height >= 10000 || (long) length * width * height >= 1000000000;
        if (heavy && bulky) return "Both";
        if (heavy) return "Heavy";
        if (bulky) return "Bulky";
        return "Neither";
    }
}
