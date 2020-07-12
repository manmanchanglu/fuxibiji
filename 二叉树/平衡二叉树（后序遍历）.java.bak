方法一：后序遍历 + 剪枝 （从底至顶）
/*面试题55 - II. 平衡二叉树
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

此方法为本题的最优解法，但剪枝的方法不易第一时间想到。
思路是对二叉树做后序遍历，从底至顶返回子树深度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。
 算法流程：
recur(root) 函数：
返回值：
当节点root 左 / 右子树的深度差 ≤1：则返回当前子树的深度，即节点 root 的左 / 右子树的深度最大值 +1 （ max(left, right) + 1 ）；
当节点root 左 / 右子树的深度差 >2：则返回 ?1 ，代表 此子树不是平衡树 。
终止条件：
当 root 为空：说明越过叶节点，因此返回高度 0 ；
当左（右）子树深度为 ?1 ：代表此树的 左（右）子树 不是平衡树，因此剪枝，直接返回 ?1 ；
isBalanced(root) 函数：
返回值： 若 recur(root) != -1 ，则说明此树平衡，返回 true ； 否则返回 false 。
作者：jyd
链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/solution/mian-shi-ti-55-ii-ping-heng-er-cha-shu-cong-di-zhi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}

