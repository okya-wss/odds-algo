package algo.recursion;

import structure.TreeNode;

/**
 * @author shuaishuai.wang
 * @date 2023-05-14
 **/
public class MergeTree {


    /**
     * 合并二叉树   深度优先
     *
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        TreeNode mergeNode = new TreeNode(root1.val + root2.val);
        mergeNode.left = mergeTrees(root1.left, root2.left);
        mergeNode.right = mergeTrees(root1.right, root2.right);
        return mergeNode;
    }
}
