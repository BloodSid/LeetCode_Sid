package leetcode.editor.cn;

import java.util.*;

/**
 * 设计一个验证系统
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-14 00:31:22
 */
public class DesignAuthenticationManagerSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class AuthenticationManager {

    private int timeToLive;
    private final HashMap<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            if (map.get(tokenId) > currentTime - timeToLive) {
                map.put(tokenId, currentTime);
            }
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() <= currentTime - timeToLive) {
                list.add(entry.getKey());
            }
        }
        for (String s : list) {
            map.remove(s);
        }
        return map.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
