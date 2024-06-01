import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(inorderTraversal(root).toString());
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null && root.right != null || root.left != null && root.right == null || root.left.val != root.right.val) {
            return false;
        }
        return isSymmetricTreeNode(root.left, root.right);

    }

    public boolean isSymmetricTreeNode(TreeNode left, TreeNode right) {
        if (left == null && right != null || left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricTreeNode(left.left, right.right) && isSymmetricTreeNode(left.right, right.left);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            if (targetSum == 0) {
                return true;
            } else {
                return false;
            }
        }

        
    }
}