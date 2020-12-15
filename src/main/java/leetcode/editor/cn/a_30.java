//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
// 
// Related Topics 哈希表 双指针 字符串 
// 👍 395 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class a_30 {
    public static void main(String[] args) {
        Solution solution = new a_30().new Solution();
        List<Integer> res = solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new LinkedList<>();
            if (words.length == 0 || s.length() == 0) {
                return res;
            }
            List<String> strings = Arrays.asList(words);
            int wordLength = words[0].length();
            int lastIndex = strings.size() * wordLength;
            for (int i = 0; i <= s.length() - lastIndex; i++) {
                List<String> strings1 = new LinkedList<>(strings);
                String substring = s.substring(i, i + lastIndex);
                int subIndex = 0;
                while (subIndex + wordLength <= substring.length()) {
                    String str = substring.substring(subIndex, subIndex + wordLength);
                    boolean remove = strings1.remove(str);
                    if (!remove) {
                        break;
                    }
                    subIndex += wordLength;
                }
                if (strings1.isEmpty()) {
                    res.add(i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}