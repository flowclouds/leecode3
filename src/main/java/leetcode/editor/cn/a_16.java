//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 634 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class a_16 {
    public static void main(String[] args) {
        a_16.Solution solution = new a_16().new Solution();
        solution.threeSumClosest(new int[]{1, 1, 1, 0}, -100);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);

            int minRes = Integer.MAX_VALUE;
            int minTemp1 = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int leftIndex = i + 1, rightIndex = nums.length - 1;
                while (leftIndex < rightIndex) {
                    int temp = nums[leftIndex] + nums[rightIndex] + nums[i];
                    if (temp == target) {
                        return target;
                    } else if (temp > target) {
                        int minTemp = Math.abs(temp - target);
                        if (minTemp < minTemp1) {
                            minRes = temp;
                            minTemp1 = minTemp;
                        }
                        rightIndex--;
                    } else {
                        int minTemp = Math.abs(temp - target);
                        if (minTemp < minTemp1) {
                            minRes = temp;
                            minTemp1 = minTemp;
                        }
                        leftIndex++;
                    }
                }
            }
            return minRes;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}