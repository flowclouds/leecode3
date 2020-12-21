//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 351 👎 0

package leetcode.editor.cn;

public class a_316 {
    public static void main(String[] args) {
        a_316.Solution solution = new a_316().new Solution();
        String res = solution.removeDuplicateLetters("bbcaac");
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {

            int length = s.length();
            int[] charCount = new int[26];
            boolean[] charUsed = new boolean[26];

            for (int i = 0; i < length; i++) {
                charCount[s.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < length; i++) {
                if (charUsed[s.charAt(i) - 'a']) {
                    charCount[s.charAt(i) - 'a']--;
                    continue;
                }

                while (sb.length() > 0 && s.charAt(i) < sb.charAt(sb.length() - 1) && charCount[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                    charUsed[sb.charAt(sb.length() - 1) - 'a'] = false;
                    sb.deleteCharAt(sb.length() - 1);

                }

                sb.append(s.charAt(i));
                charUsed[s.charAt(i) - 'a'] = true;
                charCount[s.charAt(i) - 'a']--;

            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}