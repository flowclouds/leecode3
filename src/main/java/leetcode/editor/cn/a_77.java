//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 452 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class a_77 {
    public static void main(String[] args) {
        Solution solution = new a_77().new Solution();
        List<List<Integer>> combine = solution.combine(3, 3);
        System.out.println(combine);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                integers.add(i);
                obtain(n, k - 1, i + 1, integers);
                integers.remove(integers.size() - 1);
            }
            if (res.isEmpty()) {
                res.add(new ArrayList<>());
            }
            return res;
        }

        public void obtain(int n, int k, int currentNo, List<Integer> item) {
            if (k == 0) {
                res.add(new ArrayList<>(item));
                return;
            }

            for (int i = currentNo; i <= n; i++) {
                item.add(i);
                obtain(n, k - 1, i + 1, item);
                item.remove(item.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}