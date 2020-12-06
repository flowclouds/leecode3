//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1026 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class a_46 {
    public static void main(String[] args) {
        a_46.Solution solution = new a_46().new Solution();
        List<List<Integer>> permute = solution.permute(new int[]{});
        System.out.println(permute);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final List<List<Integer>> res = new LinkedList<>();

        private boolean[] visited;

        public List<List<Integer>> permute(int[] nums) {
            visited = new boolean[nums.length];

            if (nums.length == 0) {
                res.add(new ArrayList<>());
                return res;
            }

            for (int i = 0; i < nums.length; i++) {
                visited[i] = true;
                List<Integer> objects = new LinkedList<>();
                objects.add(nums[i]);
                obtain(nums, i, objects);
                objects.remove(objects.size() - 1);
                visited[i] = false;
            }
            return res;
        }

        public void obtain(int[] nums, int currIndex, List<Integer> item) {
            if (item.size() == nums.length) {
                res.add(new LinkedList<>(item));
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    item.add(nums[i]);
                    obtain(nums, i, item);
                    visited[i] = false;
                    item.remove(item.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}