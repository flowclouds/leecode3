//有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
//
// 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。 
//
// 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。 
//
// 返回尽可能高的分数。 
//
// 
//
// 
// 
//
// 示例： 
//
// 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：
//转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
//0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20 
// 1 <= A[0].length <= 20 
// A[i][j] 是 0 或 1 
// 
// Related Topics 贪心算法 
// 👍 113 👎 0


package leetcode.editor.cn;

public class a_861 {
    public static void main(String[] args) {
        Solution solution = new a_861().new Solution();
        solution.matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int matrixScore(int[][] A) {

            //尽可能将最高位变为1，2尽可能将除第一位之后的数量尽量多
            int row = A.length;
            int column = A[0].length;
            //遍历第一位 全部变成0
            for (int i = 0; i < row; i++) {
                if (A[i][0] == 0) {
                    reverseRow(A, i);
                }
            }
            //翻转列
            for (int i = 1; i < column; i++) {
                reverseColumn(A, i);
            }

            return obtainRes(A);
        }

        //翻转行
        public void reverseRow(int[][] A, int row) {
            int[] ints = A[row];
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == 1) {
                    ints[i] = 0;
                } else if (ints[i] == 0) {
                    ints[i] = 1;
                }
            }
        }

        public void reverseColumn(int[][] A, int column) {
            int count0 = 0;
            int count1 = 0;

            for (int i = 0; i < A.length; i++) {
                if (A[i][column] == 0) {
                    ++count0;
                } else {
                    ++count1;
                }
            }
            if (count0 > count1) {
                for (int i = 0; i < A.length; i++) {
                    if (A[i][column] == 0) {
                        A[i][column] = 1;
                    } else {
                        A[i][column] = 0;
                    }
                }
            }
        }

        private int obtainRes(int[][] A) {
            int res = 0;
            for (int[] ints : A) {
                StringBuilder sb = new StringBuilder();
                for (int anInt : ints) {
                    sb.append(anInt);
                }
                res += Integer.valueOf(sb.toString(), 2);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}