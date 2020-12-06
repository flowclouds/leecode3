//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 404 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class a_118 {
    public static void main(String[] args) {
        a_118.Solution solution = new a_118().new Solution();
        List<List<Integer>> generate = solution.generate(6);

        System.out.println(generate);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> generate(int numRows) {

            if (numRows == 0) return res;
            ArrayList<Integer> objects = new ArrayList<>();
            objects.add(1);
            res.add(objects);
            if (numRows == 1) return res;

            ArrayList<Integer> objects2 = new ArrayList<>();
            objects2.add(1);
            objects2.add(1);
            res.add(objects2);
            ArrayList<Integer> pre = objects2;
            if (numRows == 2) return res;

            for (int i = 3; i <= numRows; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(1);
                for (int j = 1; j < i - 1; j++) {
                    list.add(pre.get(j - 1) + pre.get(j));
                }
                list.add(1);
                pre = list;
                res.add(list);
            }

            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}