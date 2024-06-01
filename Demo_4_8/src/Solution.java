import java.util.LinkedList;
import java.util.Queue;

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
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null ) {
            if (targetSum == 0) {
                return true;
            } else {
                return false;
            }
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.offer(root);
        queue2.offer(root.val);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode cur = queue1.poll();
            int temp = queue2.poll();
            if (cur.left != null) {
                queue1.offer(cur.left);
                queue2.offer(temp + cur.val);
            }
            if (cur.right != null) {
                queue1.offer(cur.right);
                queue2.offer(temp + cur.val);
            }
            if (cur.left == null && cur.right == null) {
                if (temp == targetSum) {
                    return true;
                }
            }
        }

        return false;
    }
}
