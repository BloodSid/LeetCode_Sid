package leetcode.editor.cn;
//给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。 
//
// 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。 
//
// 
//
// 示例 1： 
//
// 输入：address = "1.1.1.1"
//输出："1[.]1[.]1[.]1"
// 
//
// 示例 2： 
//
// 输入：address = "255.100.50.0"
//输出："255[.]100[.]50[.]0"
// 
//
// 
//
// 提示： 
//
// 
// 给出的 address 是一个有效的 IPv4 地址 
// 
// 👍 87 👎 0


/**
 * IP 地址无效化
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-21 00:37:43 
 */
public class DefangingAnIpAddressSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
