/*面试题27. 二叉树的镜像
请完成一个函数，输入一个二叉树，该函数输出它的镜像。
例如输入：
     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 
示例 1：
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*方法一：递归法
根据二叉树镜像的定义，考虑递归遍历（dfs）二叉树，交换每个节点的左 / 右子节点，即可生成二叉树的镜像。
递归解析：
终止条件： 当节点 root为空时（即越过叶节点），则返回 null ；
递推工作：
初始化节点 tmp ，用于暂存 root 的左子节点；
开启递归 右子节点 mirrorTree(root.right) ，并将返回值作为 root 的 左子节点 。
开启递归 左子节点 mirrorTree(tmp) ，并将返回值作为 root的 右子节点 。
返回值： 返回当前节点 root ；
作者：jyd
链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/solution/mian-shi-ti-27-er-cha-shu-de-jing-xiang-di-gui-fu-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)
            return null;
        if(root!=null&(root.left==null&&root.right==null))//递归终止条件，到叶子结点就返回
            return root;
        TreeNode node=new TreeNode();
        node=root.left;
        root.left=root.right;
        root.right=node;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;

    }
}