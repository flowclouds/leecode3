//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1146 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;

public class a_101 {
    public static void main(String[] args) {
        a_101.Solution solution = new a_101().new Solution();

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            ArrayList<TreeNode> li = new ArrayList<>();
            li.add(root);

            while (!li.isEmpty()) {
                int size = li.size();
                //判断首尾是否相等
                int left = 0;
                int right = size - 1;
                while (left < right && left < size && right >= 0) {
                    TreeNode leftNode = li.get(left++);
                    TreeNode rightNode = li.get(right--);
                    if ((leftNode == null) == (rightNode == null)) {
                        if (leftNode != null && leftNode.val != rightNode.val) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                for (int i = 0; i < size; i++) {
                    TreeNode remove = li.remove(0);
                    if (remove != null) {
                        li.add(remove.left);
                        li.add(remove.right);
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}