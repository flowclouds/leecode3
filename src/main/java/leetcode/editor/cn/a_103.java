//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 307 👎 0


package leetcode.editor.cn;

import java.util.*;

public class a_103 {
    public static void main(String[] args) {
        Solution solution = new a_103().new Solution();
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
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            traverse(root);
            return res;
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> leftStack = new Stack<>();
            Stack<TreeNode> rightStack = new Stack<>();

            rightStack.push(root);

            while (!leftStack.isEmpty() || !rightStack.empty()) {
                List<Integer> item = new ArrayList<>();

                if (!leftStack.empty()) {
                    while (!leftStack.empty()) {
                        TreeNode pop = leftStack.pop();
                        if (pop.right != null) rightStack.push(pop.right);
                        if (pop.left != null) rightStack.push(pop.left);
                        item.add(pop.val);
                    }
                } else {
                    while (!rightStack.empty()) {
                        TreeNode pop = rightStack.pop();
                        if (pop.left != null) leftStack.push(pop.left);
                        if (pop.right != null) leftStack.push(pop.right);
                        item.add(pop.val);
                    }
                }
                res.add(item);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}