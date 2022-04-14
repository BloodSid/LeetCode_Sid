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
    private final HashMap<String, Integer> map = new HashMap<>();
    // 使用两个列表分别储存id和time
    List<String> idList = new ArrayList<>();
    List<Integer> timeList = new ArrayList<>();
    // 记录上一次查询未过时验证码时，第一个未过时的验证码的index
    int start = 0;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
        idList.add(tokenId);
        timeList.add(currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            // 若该id存在且未过时，则更新map并给列表添加记录
            if (map.get(tokenId) > currentTime - timeToLive) {
                map.put(tokenId, currentTime);
                idList.add(tokenId);
                timeList.add(currentTime);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int n = idList.size();
        int i = start;
        for (; i < n; i++) {
            String id = idList.get(i);
            Integer time = timeList.get(i);
            // 遇到第一个没超时的就停止遍历
            if (time > currentTime - timeToLive) break;
            // 如果这一id的最晚更新时间和列表中的时间相等，则说明这一id已经过时
            if (map.get(id).equals(time)) {
                map.remove(id);
            }
        }
        // 下一次查询从start开始即可
        start = i;
        return map.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
