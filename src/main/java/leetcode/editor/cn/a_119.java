//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 205 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class a_119 {
    public static void main(String[] args) {
        a_119.Solution solution = new a_119().new Solution();
        List<Integer> row = solution.getRow(6);
        System.out.println(row);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> res = new LinkedList<>();
            List<Integer> pre;
            rowIndex = rowIndex + 1;
            if (rowIndex == 1) {
                res.add(1);
                return res;
            }

            if (rowIndex == 2) {
                res = new ArrayList<>();
                res.add(1);
                res.add(1);
                return res;
            }
            pre = new ArrayList<>();
            pre.add(1);
            pre.add(1);
            for (int i = 2; i <= rowIndex; i++) {
                res = new LinkedList<>();
                res.add(1);
                for (int j = 1; j < i - 1; j++) {
                    res.add(pre.get(j - 1) + pre.get(j));
                }
                res.add(1);
                pre = new ArrayList<>(res);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}