package test2;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public int robTree(TreeNode root) {
        int[] dp = robTreeNode(root);
        return Math.max(dp[0], dp[1]);
    }

    public int[] robTreeNode(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] rootDp = new int[2];
        int[] leftDp = robTreeNode(root.left);
        int[] rightDp = robTreeNode(root.right);
        rootDp[0] = root.val + leftDp[1] + rightDp[1];
        rootDp[1] = Math.max(leftDp[0], leftDp[1]) + Math.max(rightDp[0], rightDp[1]);
        return rootDp;
    }

    public static int index = 0;

    public TreeNode createTree(String str) {
        index = 0;
        return createChild(str);
    }

    public TreeNode createChild(String str) {
        if (str.charAt(index) == '#') {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str.charAt(index) + ""));
        index++;
        root.left = createChild(str);
        root.right = createChild(str);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.createTree("32#3##3#1##");
        System.out.println(solution.robTree(root));
    }
}



