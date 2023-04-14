package leetcode.editor.cn;
//如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 
//个字符。） 
//
// 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 
//pattern 匹配时， answer[i] 才为 true，否则为 false。 
//
// 
//
// 示例 1： 
//
// 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
//, pattern = "FB"
//输出：[true,false,true,true,false]
//示例：
//"FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
//"FootBall" 可以这样生成："F" + "oot" + "B" + "all".
//"FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer". 
//
// 示例 2： 
//
// 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
//, pattern = "FoBa"
//输出：[true,false,true,false,false]
//解释：
//"FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
//"FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
// 
//
// 示例 3： 
//
// 输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
//, pattern = "FoBaT"
//输入：[false,true,false,false,false]
//解释： 
//"FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
// 
//
// 
//
// 提示： 
//
// 
// 1 <= queries.length <= 100 
// 1 <= queries[i].length <= 100 
// 1 <= pattern.length <= 100 
// 所有字符串都仅由大写和小写英文字母组成。 
// 
//
// 👍 74 👎 0


import java.util.*;

/**
 * 驼峰式匹配
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-04-14 10:23:40 
 */
public class CamelcaseMatchingSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
//import java.util.*;

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int n = queries.length;
        boolean[] list = new boolean[n];
        int pi = 0;
        char[] p = pattern.toCharArray();
        for (String query : queries) {
            char[] c = query.toCharArray();
            boolean flag = true;
            int i = 0, j = 0;
            for (; i < c.length; i++) {
                if (j < p.length && c[i] == p[j]) {
                    j++;
                } else if (c[i] >= 'A' && c[i] <= 'Z') {
                    // 大写字母必须匹配到
                    flag = false;
                    break;
                }
            }
            // Pattern 的字母必须全部匹配
            flag &= j == p.length;
            list[pi++] = flag;
        }

        return new AbstractList<Boolean>() {
            @Override
            public Boolean get(int index) {
                return list[index];
            }

            @Override
            public int size() {
                return list.length;
            }
        };
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
