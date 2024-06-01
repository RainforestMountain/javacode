package test1;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinarySearchTree {

    public TreeNode root;

    public boolean insert(int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            root = node;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val == val) {
                return false;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }

        if (parent.val < val) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        return true;
    }

    public boolean delete(int val) {
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val == val) {
                if (cur.left == null) {
                    if (cur == root) {
                        root = root.right;
                    } else if (parent.left == cur) {
                        parent.left = cur.right;
                    } else if (parent.right == cur) {
                        parent.right = cur.right;
                    }
                } else if (cur.right == null) {
                    if (cur == root) {
                        root = root.left;
                    } else if (parent.left == cur) {
                        parent.left = cur.left;
                    } else if (parent.right == cur) {
                        parent.right = cur.left;
                    }
                } else {
                    //cur左子树的最右边节点
                    TreeNode t = cur.left;
                    TreeNode tp = cur;
                    while (t.right != null) {
                        tp = t;
                        t = t.right;
                    }
                    cur.val = t.val;
                    //t的右为null
                    if (tp.left == t) {
                        tp.left = t.left;
                    } else if (tp.right == t) {
                        tp.right = t.left;
                    }
                }
                return true;
            } else if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }

        return false;
    }

    public boolean search(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) {
                return true;
            } else if (cur.val < val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(4);
        tree.insert(6);
        tree.insert(1);
        tree.insert(9);
        tree.insert(7);
        tree.insert(3);
        tree.insert(0);

        tree.insert(2);
        System.out.println(tree.search(7));
        System.out.println(tree.delete(10));
        System.out.println(tree.search(7));
    }
}
