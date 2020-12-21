//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 702 👎 0

package leetcode.editor.cn;

public class a_48 {
    public static void main(String[] args) {
        a_48.Solution solution = new a_48().new Solution();
        solution.rotate(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {

//            printArray(matrix);
            int length = matrix.length;
            int tier = 0;

            //搜索层数
            while (tier <= (length + 1) / 2) {
                int times = tier;
                while (times < length - 1 - tier) {

                    //缓存目标用于旋转
                    int temp1 = matrix[tier][times];
                    int temp2 = matrix[times][length - 1 - tier];
                    int temp3 = matrix[length - 1 - tier][length - 1 - times];
                    int temp4 = matrix[length - 1 - times][tier];

                    matrix[tier][times] = temp4;
                    matrix[times][length - 1 - tier] = temp1;
                    matrix[length - 1 - tier][length - 1 - times] = temp2;
                    matrix[length - 1 - times][tier] = temp3;

                    times++;
//                    System.out.println("第" + times + "次旋转");
//                    printArray(matrix);
                }
                tier++;
            }

        }
    }

//    private void printArray(int[][] arrays) {
//        for (int[] array : arrays) {
//            System.out.println(Arrays.toString(array));
//        }
//    }

//leetcode submit region end(Prohibit modification and deletion)

}