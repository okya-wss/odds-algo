package algo.tree;

import structure.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * @author shuaishuai.wang
 * @date 2021-03-10
 **/
public class BinarySearchTree {

    private TreeNode node;

    public TreeNode find(int data) {
        TreeNode p = node;
        while (p != null) {
            if (data < p.val) {
                p = p.left;
            } else if (data > p.val) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (node == null) {
            node = new TreeNode(data);
            return;
        }
        TreeNode p = node;
        while (true) {
            if (data > p.val) {
                if (p.right == null) {
                    p.right = new TreeNode(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new TreeNode(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        TreeNode p = node;
        // pp记录的是p的父节点
        TreeNode pp = null;
        while (p != null && p.val != data) {
            pp = p;
            if (data > p.val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) {
            return;
        }

        // 要删除的节点有两个子节点  使用该节点右子树的最小子节点
        if (p.left != null && p.right != null) {
            TreeNode minP = p.right;
            // minPP表示minP的父节点
            TreeNode minpp = p;
            while (minP.left != null) {
                minpp = minP;
                minP = minP.left;
            }
            p.val = minP.val;
            p = minP;
            pp = minpp;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        TreeNode child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        //删除的是根节点
        if (pp == null) {
            node = child;
        } else if (pp.left != null) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }


    void deleteNode(int data) {
        TreeNode p = node;
        TreeNode pp = null;
        while (p != null && p.val != data) {
            pp = p;
            if (p.val > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }
        if (p.right != null && p.left != null) {
            TreeNode minPp = p;
            TreeNode minP = p.right;
            while (minP.left != null) {
                    minPp = minP;
                    minP = minP.left;
            }
            p.val = minP.val;
            p = minP;
            pp = minPp;
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a,b,c,d".split(","));
        System.out.println(list.contains("a"));;
        System.out.println(list);
    }
}
