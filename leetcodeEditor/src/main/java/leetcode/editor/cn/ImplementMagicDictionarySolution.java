package leetcode.editor.cn;
//设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单
//词存在于你构建的字典中。 
//
// 实现 MagicDictionary 类： 
//
// 
// MagicDictionary() 初始化对象 
// void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字
//符串互不相同 
// bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得
//所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入
//["MagicDictionary", "buildDict", "search", "search", "search", "search"]
//[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
//输出
//[null, null, false, true, false, false]
//
//解释
//MagicDictionary magicDictionary = new MagicDictionary();
//magicDictionary.buildDict(["hello", "leetcode"]);
//magicDictionary.search("hello"); // 返回 False
//magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
//magicDictionary.search("hell"); // 返回 False
//magicDictionary.search("leetcoded"); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 100 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] 仅由小写英文字母组成 
// dictionary 中的所有字符串 互不相同 
// 1 <= searchWord.length <= 100 
// searchWord 仅由小写英文字母组成 
// buildDict 仅在 search 之前调用一次 
// 最多调用 100 次 search 
// 
// 
// 
// 
// 👍 155 👎 0


import java.util.*;

/**
 * 实现一个魔法字典
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-07-11 15:08:59 
 */
public class ImplementMagicDictionarySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class MagicDictionary {

    public static final String WILD = "**";
    private final HashMap<String, String> virtual;


    public MagicDictionary() {
        virtual = new HashMap<>();
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            String[] var = virtualize(word);
            for (String s : var) {
                // 若有两个单词连接到该虚拟节点，则查询时任何连接到该节点的单词都合法
                if (virtual.containsKey(s)) {
                    virtual.put(s, WILD);
                } else {
                    // 只有一个单词连接到该虚拟节点。则查询时连接到该节点的单词必须不能和这个单词相同
                    virtual.put(s, word);
                }
            }
        }
    }
    
    public boolean search(String searchWord) {
        String[] vir = virtualize(searchWord);
        for (String s : vir) {
            String real = virtual.get(s);
            if (real != null && !searchWord.equals(real)) return true;
        }
        return false;
    }

    String[] virtualize(String s) {
        char[] ch = s.toCharArray();
        String[] res = new String[ch.length];
        for (int i = 0; i < ch.length; i++) {
            char t = ch[i];
            ch[i] = '*';
            res[i] = new String(ch);
            ch[i] = t;
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
