package algo.recursion;

import structure.TreeNode;

/**
 * 98 验证二叉搜索树
 * @author shuaishuai.wang
 * @date 2023-05-14
 **/
public class IsBalance {

    /**
     * 自顶向下
     *
     * @param root
     * @return
     */
    public static boolean isBalance1(TreeNode root) {

        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalance1(root.left) && isBalance1(root.right);
        }
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }


    /**
     * 判断是否是平衡二叉树
     * 自下而上
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        return balanced(root) >= 0;
    }

    private static int balanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = balanced(root.left);
        int rightHeight = balanced(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
