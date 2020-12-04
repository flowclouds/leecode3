//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 
//
// 示例 2： 
//
// 输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 
//
// 示例 3： 
//
// 输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组长度范围为 [1, 10000] 
// 
//
// 
// Related Topics 堆 贪心算法 
// 👍 153 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class a_659 {
    public static void main(String[] args) {
        Solution solution = new a_659().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossible(int[] nums) {

            HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
            for (int num : nums) {
                if (!map.containsKey(num)) {
                    map.put(num, new PriorityQueue<>());
                }
                if (map.containsKey(num - 1)) {
                    Integer numSize = map.get(num - 1).poll();
                    if (map.get(num - 1).isEmpty()) {
                        map.remove(num - 1);
                    }
                    map.get(num).offer(numSize + 1);
                } else {
                    map.get(num).offer(1);
                }
            }

            Set<Map.Entry<Integer, PriorityQueue<Integer>>> entries = map.entrySet();
            for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entries) {
                if (entry.getValue().peek() < 3) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}