//计算给定二叉树的所有左叶子之和。
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 264 👎 0


package leetcode.editor.cn;

public class a_404 {
    public static void main(String[] args) {
        Solution solution = new a_404().new Solution();
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
    class Solution {

        int res = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return res;
            travel(root);
            return res;
        }

        private void travel(TreeNode root) {
            if (root == null) return;

            if (root.left != null && root.left.left == null && root.left.right == null) {
                res += root.left.val;
            }
            travel(root.left);
            travel(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}