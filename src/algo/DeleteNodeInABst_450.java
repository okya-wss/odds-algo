package algo;

import structure.TreeNode;

// 450 delete-node-in-a-bst	删除二叉搜索树中的节点

public class DeleteNodeInABst_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                TreeNode next = root.right;
                while (next.left != null) {
                    next = next.left;
                }
                root.right = deleteNode(root.right, next.val);
                root.val = next.val;
            }
        }
        return root;
    }
}
