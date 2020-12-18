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
        char theDifference = solution.findTheDifference("", "a");
        System.out.println(theDifference);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //采取异或运算 相同为0不同为1 则有0^0=0, 0^1=1 则有a^a=0,a^a^c=c
    class Solution {
        public char findTheDifference(String s, String t) {
            int length = s.length();
            int res = 0;//定义返回结果 初始值

            for (int i = 0; i < length; i++)
                res = res ^ s.charAt(i) ^ t.charAt(i);

            res = res ^ t.charAt(length);

            return (char) res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}