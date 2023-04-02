package Contest0402.T1;

public class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int max = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                System.out.println(sub);
                if (sub.length() % 2 == 0) {
                    char[] c = sub.toCharArray();
                    boolean flag = true;
                    for (int k = 0; k < c.length; k++) {
                        if (k / (c.length / 2) != c[k] - '0') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        max = Math.max(max, sub.length());
                    }
                }
            }
        }
        return max;
    }
}
