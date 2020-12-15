//给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
//
// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。） 
//
// 示例 1: 
//
// 输入: N = 10
//输出: 9
// 
//
// 示例 2: 
//
// 输入: N = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 输入: N = 332
//输出: 299
// 
//
// 说明: N 是在 [0, 10^9] 范围内的一个整数。 
// Related Topics 贪心算法 
// 👍 108 👎 0


package leetcode.editor.cn;

public class a_738 {
    public static void main(String[] args) {
        Solution solution = new a_738().new Solution();
        int i = solution.monotoneIncreasingDigits(9999991);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int monotoneIncreasingDigits(int N) {
            String s = String.valueOf(N);

            char[] chars = s.toCharArray();
            int i = 1;

            while (i < chars.length && chars[i - 1] <= chars[i]) {
                i++;
            }

            if (i < chars.length) {
                while (i > 0 && chars[i - 1] > chars[i]) {
                    chars[i - 1] -= 1;
                    i -= 1;
                }
                for (i += 1; i < chars.length; ++i) {
                    chars[i] = '9';
                }
            }

            return Integer.parseInt(new String(chars));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}