package algo.tree;

import structure.TreeNode;

/**
 * 236 二叉树公共祖先
 *
 * @author shuaishuai.wang
 * @date 2022-03-15
 **/
public class LowestCommonAncestor_236 {



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}
