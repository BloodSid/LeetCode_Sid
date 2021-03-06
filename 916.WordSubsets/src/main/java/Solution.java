import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author IronSid
 * @create 2021-04-24 16:00
 */

public class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        if (A == null || B == null) return new ArrayList<>();
        if (A.length == 0) return new ArrayList<>();
        if (B.length == 0) return Arrays.asList(A);
        //将b合并成一个单词b_union再去遍历a
        int[] bmaxChar = new int[26];
        for (String b :
                B) {
            int[] bChar = new int[26];
            for (char chr : b.toCharArray()) {
                bChar[chr - 97]++;
            }
            for (int i = 0; i < 26; i++) {
                bmaxChar[i] = Math.max(bmaxChar[i], bChar[i]);
            }
        }
        //用a遍历A，检查b——union是不是a的子集，若是则将a加入结果集
        List<String> uniWords = new ArrayList<>();
        for (String a :
                A) {
            int[] aChar = new int[26];
            for (char chr: a.toCharArray()) {
                aChar[chr - 97]++;
            }
            //若a符合条件，则必有a[i]>=bmax[i]
            for (int i = 0; i < 26; i++) {
                if (aChar[i] < bmaxChar[i]) {
                    break;
                } else if (i == 25) {
                    uniWords.add(a);
                }
            }
        }
        return uniWords;
    }

}
