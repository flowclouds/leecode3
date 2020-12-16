//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 304 👎 0

package leetcode.editor.cn;

public class a_125 {
    public static void main(String[] args) {
        a_125.Solution solution = new a_125().new Solution();
        boolean palindrome = solution.isPalindrome("0P");
        System.out.println(palindrome);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {

            s = s.toLowerCase();

            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (!Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                    continue;
                }
                if (!Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                    continue;
                }
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}