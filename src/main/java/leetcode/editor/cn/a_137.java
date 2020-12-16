//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,3,2]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [0,1,0,1,0,1,99]
//输出: 99 
// Related Topics 位运算 
// 👍 475 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Set;

public class a_137 {
    public static void main(String[] args) {
        a_137.Solution solution = new a_137().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            Set<Integer> integers = map.keySet();
            for (Integer integer : integers) {
                if (map.get(integer) == 1) {
                    return integer;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}