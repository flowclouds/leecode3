//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈 
// 👍 222 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class a_503 {
    public static void main(String[] args) {
        Solution solution = new a_503().new Solution();
        int[] ints = solution.nextGreaterElements(new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100});
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[nums.length];

            for (int i = nums.length * 2 - 1; i >= 0; --i) {
                while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length])
                    stack.pop();
                res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
                stack.push(i % nums.length);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}