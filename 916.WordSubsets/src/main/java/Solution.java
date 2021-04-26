import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author IronSid
 * @create 2021-04-24 16:00
 */

public class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        if (A == null || B == null) return new ArrayList<String>();
        if (A.length == 0) return new ArrayList<String>();
        if (B.length == 0) return Arrays.asList(A);
        //将b合并成一个单词b_union再去遍历a
        int[] bmaxChar = new int[26];
        for (String b :
                B) {
            int[] bChar = new int[26];
            for (int i = 0; i < b.length(); i++) {
                bChar[b.charAt(i) - 97]++;
            }
            for (int i = 0; i < 26; i++) {
                bmaxChar[i] = Math.max(bmaxChar[i], bChar[i]);
            }
        }
        for (int i = 0; i < bmaxChar.length; i++) {
            System.out.println((char) ('a' + i)+" "+bmaxChar[i]);
        }
        //用a遍历A，检查b——union是不是a的子集，若是则将a加入结果集
        List<String> uniWords = new ArrayList<>();
        for (String a :
                A) {
            int[] aChar = new int[26];
            for (int i = 0; i < a.length(); i++) {
                aChar[a.charAt(i) - 97]++;
            }
            System.out.println(a);
            for (int i = 0; i < aChar.length; i++) {
                System.out.println((char) ('a' + i)+" "+aChar[i]);
            }
            //若a符合条件，则必有a[i]>=bmax[i]
            for (int i = 0; i < 26; i++) {
                if (aChar[i] < bmaxChar[i]) {
                    System.out.println((char) ('a' + i)+"achari "+aChar[i]+"maxchari"+bmaxChar[i]);
                    System.out.println("delete " + a);
                    break;
                } else if (i == 25) {
                    System.out.println("add " + a);
                    uniWords.add(a);
                }
            }
        }


        return uniWords;
    }

    public static void main(String[] args) {
        System.out.println((char)('a' + 1));
    }

}
