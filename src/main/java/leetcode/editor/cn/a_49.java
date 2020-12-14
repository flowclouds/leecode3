//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 578 👎 0


package leetcode.editor.cn;

import java.util.*;

public class a_49 {
    public static void main(String[] args) {
        Solution solution = new a_49().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            HashMap<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String s = String.valueOf(chars);
                List<String> strings = map.get(s);
                if (strings == null) {
                    strings = new LinkedList<>();
                }
                strings.add(str);
                map.put(s, strings);
            }
            List<List<String>> res = new ArrayList<>();
            Set<Map.Entry<String, List<String>>> entries = map.entrySet();
            for (Map.Entry<String, List<String>> entry : entries) {
                res.add(entry.getValue());
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}