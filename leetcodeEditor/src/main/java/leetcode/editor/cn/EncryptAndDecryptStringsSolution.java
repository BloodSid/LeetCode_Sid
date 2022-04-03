package leetcode.editor.cn;

import java.util.*;

/**
 * 加密解密字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-03 15:27:38 
 */
public class EncryptAndDecryptStringsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Encrypter {

    private final String[] encode;
    private final Map<String, Integer> freq;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        encode = new String[26];
        int n = keys.length;
        for (int i = 0; i < n; i++) {
            encode[keys[i] - 'a'] = values[i];
        }
        freq = new HashMap<>();
        for (String s : dictionary) {
            s = encrypt(s);
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
    }
    
    public String encrypt(String word1) {
        int n = word1.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(encode[word1.charAt(i) - 'a']);
        }
        return sb.toString();
    }
    
    public int decrypt(String word2) {
        return freq.getOrDefault(word2, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
