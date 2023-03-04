package Contest0304.T1;

import java.util.Arrays;

public class Solution {
    public int splitNum(int num) {
        char[] ch = ("" + num).toCharArray();
        Arrays.sort(ch);
        String s1 = "", s2 = "";
        for (int i = 0; i < ch.length; i++) {
            if (i % 2 == 0) {
                s1 += ch[i];
            } else {
                s2 += ch[i];
            }
        }
        return Integer.parseInt(s1) + Integer.parseInt(s2);
    }
}