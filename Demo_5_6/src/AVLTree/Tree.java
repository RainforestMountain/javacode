package AVLTree;


class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public int bf;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent, int bf) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.bf = bf;
    }
}

public class Tree {

    public TreeNode root = null;

    public boolean insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return true;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        TreeNode node = new TreeNode(val);
        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                return false;
            }
        }
        if (parent.val > val) {
            parent.left = node;
            node.parent = parent;
        } else {
            parent.right = node;
            node.parent = parent;
        }
        //cur == null,parent 指向 插入的节点的双亲节点
        cur = node;//让cur 指向插入的叶子结点
        while (parent != null) {
            //更新平衡因子
            if (cur == parent.right) {
                parent.bf++;
            } else {
                parent.bf--;
            }

            if (parent.bf == 0) {
                break;
            } else if (parent.bf == 1 || parent.bf == -1) {
                cur = parent;
                parent = cur.parent;
            } else {
                if (parent.bf == -2) {
                    if (cur.bf == -1) {
                        //LL型,右单旋
                        rotateRight(parent);
                    } else {
                        //LR
                        rolateLR(parent);
                    }
                } else if (parent.bf == 2) {
                    if (cur.bf == -1) {
                        //RL
                        rolateRL(parent);
                    } else {
                        rotateLeft(parent);
                    }
                }

                break;
            }

        }
        return true;
    }

    public void rotateRight(TreeNode parent) {//LL型
        TreeNode cur = parent.left;
        TreeNode conflict = cur.right;
        TreeNode sup = parent.parent;
        int flag = 0;//为 - 1,sup左孩子是parent;为0,parent是根;为1,sup的右孩子是parent
        if (sup == null) {
            flag = 0;
        } else if (sup.left == parent) {
            flag = -1;
        } else {
            flag = 1;
        }
        if (conflict == null) {//没有冲突的cur的右孩子
            parent.left = null;//parent旋转节点的左孩子为null
            cur.right = parent;
            parent.parent = cur;
        } else {
            //有冲突的cur的右孩子为parent旋转节点的左孩子
            parent.left = conflict;
            conflict.parent = parent;
            cur.right = parent;
            parent.parent = cur;
        }
        //parent不是为根结点,那么还有改变一些指向,上层结点的指向
        if (flag == -1) {
            sup.left = cur;
            cur.parent = sup;
        } else if (flag == 1) {
            sup.right = cur;
            cur.parent = sup;
        } else {
            cur.parent = null;//cur就是根节点了
            root = cur;
        }
        //这里是固定的,旋转后都为0
        cur.bf = 0;
        parent.bf = 0;
    }

    public void rotateLeft(TreeNode parent) {//RR型
        TreeNode cur = parent.right;
        TreeNode conflict = cur.left;
        TreeNode sup = parent.parent;
        int flag = 0;//为 - 1,sup左孩子是parent;为0,parent是根;为1,sup的右孩子是parent
        if (sup == null) {
            flag = 0;
        } else if (sup.left == parent) {
            flag = -1;
        } else {
            flag = 1;
        }
        if (conflict == null) {//没有冲突的cur的左孩子
            parent.right = null;//parent旋转节点的右孩子为空
            cur.left = parent;
            parent.parent = cur;
        } else {
            //有冲突的cur的左孩子成为parent旋转节点的右孩子
            parent.right = conflict;
            conflict.parent = parent;
            cur.left = parent;
            parent.parent = cur;
        }
        //parent不是为根结点,那么还有改变一些指向,上层结点的指向
        if (flag == -1) {
            sup.left = cur;
            cur.parent = sup;
        } else if (flag == 1) {
            sup.right = cur;
            cur.parent = sup;
        } else {
            cur.parent = null;//cur就是根节点了
            root = cur;
        }
        cur.bf = 0;
        parent.bf = 0;
    }

    public void rolateLR(TreeNode parent) {//LR型
        //平衡因子改变了3个,parent, parent.left ,parent.left.right
        TreeNode L = parent.left;//即cur
        TreeNode LR = L.right;
        int bf = LR.bf;
        //LR不用旋转,parent和cur要旋转,先cur,在parent
        rotateLeft(parent.left);
        rotateRight(parent);

        if (bf == -1) {
            L.bf = 0;
            parent.bf = 1;
            LR.bf = 0;
        } else if (bf == 1) {
            L.bf = -1;
            parent.bf = 0;
            LR.bf = 0;
        }

    }

    public void rolateRL(TreeNode parent) {//RL型
        //平衡因子改变了3个,parent, parent.left ,parent.left.right
        TreeNode R = parent.right;//即cur
        TreeNode RL = R.left;
        int bf = RL.bf;
        //RL不用旋转,parent和cur要旋转,先cur,在parent
        rotateRight(parent.right);
        rotateLeft(parent);

        if (bf == -1) {
            R.bf = 1;
            parent.bf = 0;
            RL.bf = 0;
        } else if (bf == 1) {
            R.bf = 0;
            parent.bf = -1;
            RL.bf = 0;
        }
    }

    public boolean isBalanced(TreeNode rootNode) {
        int height = getHeight(rootNode);
        if (height != -1) {
            return true;
        } else {
            return false;
        }
    }

    public int getHeight(TreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        }

        int lHeight = getHeight(rootNode.left);
        int rHeight = getHeight(rootNode.right);
        if (lHeight == -1 || rHeight == -1) {
            return -1;
        }
        if (Math.abs(lHeight - rHeight) > 1) {
            return -1;
        }
        return Math.max(lHeight, rHeight) + 1;
    }

    public boolean delete(int val) {
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                break;
            }
        }
        if (cur == null) {
            return false;
        }
        int flag = 0;
        if (parent != null && parent.left == cur) {
            flag = -1;
        } else if (parent != null && parent.right == cur) {
            flag = 1;
        }
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else if (cur == parent.right) {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else if (cur == parent.right) {
                parent.right = cur.left;
            }
        } else {
            TreeNode t = cur.right;
            TreeNode tp = cur;
            while (t.left != null) {
                tp = t;
                t = t.left;
            }
            cur.val = t.val;

            if (tp.left == t) {
                tp.left = t.right;
            } else {
                tp.right = t.right;
            }
        }

        while (parent != null) {

        }


        return true;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10);
        tree.insert(7);
        tree.insert(12);
        tree.insert(1);
        tree.insert(8);
        tree.insert(11);
        tree.insert(16);
        tree.insert(0);
        tree.insert(4);
        tree.insert(15);
        tree.insert(17);
//        tree.insert(3);
        tree.insert(6);

        System.out.println(tree.isBalanced(tree.root));
        System.out.println();
    }
}
