package leetcode.editor.cn;
//TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-
//tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。 
//
// 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本
//的 URL 。 
//
// 实现 Solution 类： 
//
// 
// 
// 
// Solution() 初始化 TinyURL 系统对象。 
// String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。 
// String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系
//统对象加密的。 
// 
//
// 
//
// 示例： 
//
// 
//输入：url = "https://leetcode.com/problems/design-tinyurl"
//输出："https://leetcode.com/problems/design-tinyurl"
//
//解释：
//Solution obj = new Solution();
//string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
//string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= url.length <= 10⁴ 
// 题目数据保证 url 是一个有效的 URL 
// 
// 
// 
// 👍 192 👎 0


import java.util.*;

/**
 * TinyURL 的加密与解密
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-29 16:25:39 
 */
public class EncodeAndDecodeTinyurlSolution {
//leetcode submit region begin(Prohibit modification and deletion)
public class Codec {

    private final char[] ch = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    private final HashMap<String, String> sTOl = new HashMap<>();
    private final HashMap<String, String> lTOs = new HashMap<>();
    private final Random random = new Random();
    private final String pre = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int n = 6;
        while (!lTOs.containsKey(longUrl)) {
            char[] code = new char[n];
            for (int i = 0; i < n; i++) {
                code[i] = ch[random.nextInt(ch.length)];
            }
            String cur = pre + new String(code);
            if (sTOl.containsKey(cur)) continue;
            lTOs.put(longUrl, cur);
            sTOl.put(cur, longUrl);
        }
        return lTOs.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return sTOl.get(shortUrl);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
