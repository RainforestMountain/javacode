public class BinarySearchTree {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode root;

    public boolean search(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.value == val) {
                return true;
            } else if (cur.value > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }

    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        TreeNode parent = root;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.value < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.value > val) {
                parent = cur;
                cur = cur.left;
            } else {
                return;
            }
        }
        if (parent.value > val) {
            parent.left = new TreeNode(val);
        } else if (parent.value < val) {
            parent.right = new TreeNode(val);
        }
    }
}
