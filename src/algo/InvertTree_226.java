package algo;

/**
 * 226 翻转二叉树
 *
 * @author shuaishuai.wang
 * @date 2022-03-09
 **/
public class InvertTree_226 {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
