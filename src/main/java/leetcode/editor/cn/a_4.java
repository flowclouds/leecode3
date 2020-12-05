//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3470 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;

public class a_4 {
    public static void main(String[] args) {
        a_4.Solution solution = new a_4().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            ArrayList<Integer> list = new ArrayList<>();

            for (int i : nums1) {
                list.add(i);
            }
            for (int i : nums2) {
                list.add(i);
            }

            Collections.sort(list);

            System.out.println(list);

            int size = list.size();
            if (size % 2 == 0) {
                return (double) (list.get((size - 1) >> 1) + list.get(((size - 1) >> 1) + 1)) / 2d;
            } else {
                return list.get(size >> 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}