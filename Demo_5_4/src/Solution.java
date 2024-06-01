
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
            }
            if (root != null) {
                list.add(root.val);
                //根节点会比右子树先出栈,不用担心又将已经遍历的右子树节点入栈
                root = root.right;
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;//刚刚已经处理的节点,离现在最近的一个
        //栈为空且root指向null(没有要处理的子树了)结束循环
        while (!stack.isEmpty() || root != null) {
            //左子树不为null,依次进栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();

                if (root.right != null && root.right != pre) {
                    //如果右子树不为null且未被访问过,
                    // 即root.right 不是刚刚已经处理的节点,离现在最近的一个
                    // 那么把根节点重新进栈,root指向右子树,
                    // 开始处理右子树
                    stack.push(root);
                    root = root.right;
                } else {
                    //右子树为null,或者已经处理过了,把根节点加入结果集
                    // 且pre指向刚处理的节点,
                    // root指向null,因为根节点在处理右子树后还在栈中,是最后处理的,如果指向右孩子会导致已经遍历过的节点重复进栈
                    //避免影响下次循环的开头处理左子树的过程
                    ans.add(root.val);
                    pre = root;
                    root = null;
                }
            }
        }
        return ans;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                ans.add(root.val);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                //根节点会比右子树先出栈,不用担心又将已经遍历的右子树节点入栈
                root = root.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Solution solution = new Solution();
        solution.inorderTraversal(root);
    }
}
