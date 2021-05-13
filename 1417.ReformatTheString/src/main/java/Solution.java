import java.util.Arrays;

/**
 * @author IronSid
 * @create 2021-05-12 23:35
 */
public class Solution {
    public String reformat(String s) {
        if (s == null) {
            return null;
        }
        if(s.length()<2){
            return s;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int halfLength = chars.length / 2;
        StringBuilder stringBuilder = new StringBuilder();
        if (chars.length % 2 == 0) {
            //字符串长度是偶数，数字和字母应各占一半
            if (!Character.isDigit(chars[halfLength - 1])) return "";
            if (!Character.isLetter(chars[halfLength])) return "";
            for (int i = 0; i < halfLength; i++) {
                stringBuilder.append(chars[i]);
                stringBuilder.append(chars[i + halfLength]);
            }
        } else {
            //字符串长度是奇数，最中间的字符为较多的那种字符
            if (!Character.isDigit(chars[halfLength - 1])) return "";
            if (!Character.isLetter(chars[halfLength + 1])) return "";
            if (Character.isDigit(chars[halfLength])) {
                //数字多，以数字起头
                for (int i = 0; i < halfLength; i++) {
                    stringBuilder.append(chars[i]);
                    stringBuilder.append(chars[i + halfLength + 1]);
                }
            } else {
                //字母多，字母起头
                for (int i = 0; i < halfLength; i++) {
                    stringBuilder.append(chars[i + halfLength + 1]);
                    stringBuilder.append(chars[i]);
                }
            }
            //最后加上最中间的字符
            stringBuilder.append(chars[halfLength]);

        }

        return stringBuilder.toString();
    }

}