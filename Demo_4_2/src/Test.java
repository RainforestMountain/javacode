import jdk.incubator.vector.VectorOperators;

import java.util.*;

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

public class Test {

//    public static void postOrder(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = root;
//        TreeNode temp = null;
//        stack.push(root);
//        while (!stack.isEmpty() || cur.right != null) {
//
//            while (cur.left != null) {
//                stack.push(cur);
//                cur = cur.left;
//            }
//            if (cur.left == null && cur.right == null) {
//                temp = stack.pop();
//                temp.val = -1;
//                System.out.print(temp.val + " ");
//                cur = stack.peek();
//
//            }
//            if ((cur.left == null || cur.left.val == -1) && cur.right != null) {
//                temp = stack.pop();
//                cur = temp.right;
//                stack.push(cur);
//            }
//
//        }


    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev) {
                cur = stack.pop();
                res.add(cur.val);
                prev = cur;
                cur = null;//cur已经用过了置为空
            } else {
                cur = cur.right;
            }
        }
        return res;
    }

    //    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
//        List<Integer> list = new ArrayList<>();
//        list = postorderTraversal(root);
//        System.out.println(list.toString());
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            index = 0;
            String str = in.nextLine();
            TreeNode root = createTree(str);
            preOrder(root);
            System.out.println();
        }
    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lHeight = maxDepth(root.left);
        int rHeight = maxDepth(root.right);
        return 1 + Math.max(lHeight, rHeight);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        int lHeight = maxDepth(root.left);
        int rHeight = maxDepth(root.right);

        if (Math.abs(lHeight - rHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public static int index;
    public static TreeNode createTree(String str) {

        if (str.charAt(index) == '#') {
            return null;
        }

        TreeNode root = new TreeNode(str.charAt(index));
        index++;
        root.left = createTree(str);
        index++;
        root.right = createTree(str);
        return root;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


}
