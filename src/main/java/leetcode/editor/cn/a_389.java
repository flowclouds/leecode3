//给定两个字符串 s 和 t，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
// 
//
// 示例 2： 
//
// 输入：s = "", t = "y"
//输出："y"
// 
//
// 示例 3： 
//
// 输入：s = "a", t = "aa"
//输出："a"
// 
//
// 示例 4： 
//
// 输入：s = "ae", t = "aea"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 1000 
// t.length == s.length + 1 
// s 和 t 只包含小写字母 
// 
// Related Topics 位运算 哈希表 
// 👍 180 👎 0


package leetcode.editor.cn;

public class a_389 {
    public static void main(String[] args) {
        Solution solution = new a_389().new Solution();
        solution.findTheDifference("abcd", "abcde");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char findTheDifference(String s, String t) {
            int length = s.length();

            int[] sArray = new int[26];

            sArray[t.charAt(length) - 'a']++;
            for (int i = 0; i < length; i++) {
                sArray[t.charAt(i) - 'a']++;
                sArray[s.charAt(i) - 'a']--;
            }

            for (int i = 0; i < 26; i++) {
                if (sArray[i] == 1) {
                    return (char) (i + 'a');
                }
            }

            return 'a';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}