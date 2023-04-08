package leetcode.editor.cn;
//作为项目经理，你规划了一份需求的技能清单 req_skills，并打算从备选人员名单 people 中选出些人组成一个「必要团队」（ 编号为 i 的备选人员
// people[i] 含有一份该备选人员掌握的技能列表）。 
//
// 所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 req_skills 中列出的每项技能，团队中至少有一名成员已经掌握。可以用每个人的编号来表示团
//队中的成员： 
//
// 
// 例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 people[3] 的备选人员。 
// 
//
// 请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按 任意顺序 返回答案，题目数据保证答案存在。 
//
// 
//
// 示例 1： 
//
// 
//输入：req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],[
//"nodejs","reactjs"]]
//输出：[0,2]
// 
//
// 示例 2： 
//
// 
//输入：req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people 
//= [["algorithms","math","java"],["algorithms","math","reactjs"],["java",
//"csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= req_skills.length <= 16 
// 1 <= req_skills[i].length <= 16 
// req_skills[i] 由小写英文字母组成 
// req_skills 中的所有字符串 互不相同 
// 1 <= people.length <= 60 
// 0 <= people[i].length <= 16 
// 1 <= people[i][j].length <= 16 
// people[i][j] 由小写英文字母组成 
// people[i] 中的所有字符串 互不相同 
// people[i] 中的每个技能是 req_skills 中的技能 
// 题目数据保证「必要团队」一定存在 
// 
//
// 👍 132 👎 0


import java.util.*;

/**
 * 最小的必要团队
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-04-08 15:57:27 
 */
public class SmallestSufficientTeamSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private long[][] f;
    private int[] p;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> skill = new HashMap<>();
        final int[] id = {0};
        for (String s : req_skills) {
            skill.put(s, id[0]++);
        }
        int n = skill.size();
        p = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            List<String> p = people.get(i);
            for (String s : p) {
                this.p[i] |= 1 << skill.get(s);
            }
        }
        int m = people.size();
        // f(i, j）表示从前i个集合中选择若干集合，并集包含 j 至少需要选择的集合数
        f = new long[m][1 << n];
        for (long[] ints : f) {
            Arrays.fill(ints, -1);
        }
        long res = f(m - 1, (1 << n) - 1);
        int[] ans = new int[Long.bitCount(res)];
        for (int i = 0, j = 0; i < m; i++) {
            if ((res >> i & 1) == 1) {
                ans[j++] = i;
            }
        }
        return ans;
    }

    long f(int i, int j) {
        // 不需要继续取
        if (j == 0) return 0;
        // 无法取到，则返回全集，便于上层比较集合大小时忽略
        if (i < 0) return (1L << p.length) - 1;
        if (f[i][j] != -1) return f[i][j];
        // 不选pi
        long res = f(i - 1, j);
        // 选pi
        long res2 = f(i - 1, j & ~p[i]) | 1L << i;
        f[i][j] = Long.bitCount(res) < Long.bitCount(res2) ? res : res2;
        return f[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
