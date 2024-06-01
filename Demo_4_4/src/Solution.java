

import java.util.HashSet;

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

public class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        index = 0;
        return buildChildTree(preorder, inorder, 0, inorder.length - 1);
    }

    public static int index;

    public static TreeNode buildChildTree(int[] preorder, int[] inorder, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int rootIndex = 0;
        for (; rootIndex < inorder.length; rootIndex++) {
            if (inorder[rootIndex] == preorder[index]) {
                break;
            }
        }

        index++;
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = buildChildTree(preorder, inorder, begin, rootIndex - 1);
        root.right = buildChildTree(preorder, inorder, rootIndex + 1, end);

        return root;
    }

    public static void main1(String[] args) {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode root = buildTree(preorder, inorder);

        System.out.println();
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        index = postorder.length - 1;
        return buildChildTree2(postorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildChildTree2(int[] postorder, int[] inorder, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int rootIndex = 0;
        for (; rootIndex < inorder.length; rootIndex++) {
            if (inorder[rootIndex] == postorder[index]) {
                break;
            }
        }

        index--;
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = buildChildTree(postorder, inorder, begin, rootIndex - 1);
        root.right = buildChildTree(postorder, inorder, rootIndex + 1, end);

        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) {
            return root;
        }

        if (!isExist(root, p) && !isExist(root, q)) {
            return null;
        }

        if (isExist(root.left, p) && isExist(root.right, q) || isExist(root.right, p) && isExist(root.left, q)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    public static boolean isExist(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root.val == node.val) {
            return true;
        }
        return isExist(root.left, node) || isExist(root.right, node);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 5, 6, 2, 7, 4, 1, 0, 8};
        int[] inorder = {6, 5, 7, 2, 4, 3, 0, 1, 8};
        TreeNode root = buildTree(preorder, inorder);

        boolean b = isExist(root.right, new TreeNode(2));
        System.out.println(b);


    }
}
