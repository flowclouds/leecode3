//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。 
//
// 示例 : 
//
// 输入: [1,2,1,3,2,5]
//输出: [3,5] 
//
// 注意： 
//
// 
// 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。 
// 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
// 
// Related Topics 位运算 
// 👍 331 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Set;

public class a_260 {
    public static void main(String[] args) {
        a_260.Solution solution = new a_260().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumber(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int[] ints = new int[2];
            int index = 0;
            Set<Integer> integers = map.keySet();
            for (Integer integer : integers) {
                if (map.get(integer) == 1) {
                    ints[index] = integer;
                    index++;
                    if (index > 1) {
                        return ints;
                    }
                }
            }
            return ints;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}