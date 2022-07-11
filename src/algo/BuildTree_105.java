package algo;

import structure.TreeNode;

/**
 * 105 根据前序和中序还原二叉树
 *
 * @author shuaishuai.wang
 * @date 2022-03-15
 **/
public class BuildTree_105 {

    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return build(0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode build(int l1, int r1, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[l1]);
        int mid = l2;
        while (inorder[mid] != root.val) {
            mid++;
        }
        // l1 + (mid - l2) 子树的节点个数
        root.left = build(l1 + 1, l1 + (mid - l2), l2, mid - 1);
        root.right = build(l1 + (mid - l2) + 1, r1, mid + 1, r2);
        return root;
    }
}
