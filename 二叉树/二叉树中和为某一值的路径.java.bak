/*面试题34. 二叉树中和为某一值的路径
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
示例:
给定如下二叉树，以及目标和 sum = 22，
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:
[
   [5,4,11,2],
   [5,8,4,5]
]
 
提示：
节点总数 <= 10000*/
/*解题思路：
本问题是典型的二叉树方案搜索问题，使用回溯法解决，其包含 先序遍历 + 路径记录 两部分。
先序遍历： 按照 “根、左、右” 的顺序，遍历树的所有节点。
路径记录： 在先序遍历中，记录从根节点到当前节点的路径。当路径为 ① 根节点到叶节点形成的路径 且 ② 各节点值的和等于目标值 sum 时，
将此路径加入结果列表。
算法流程：
pathSum(root, sum) 函数：
初始化： 结果列表 res ，路径列表 path 。
返回值： 返回 res 即可。
recur(root, tar) 函数：
递推参数： 当前节点 root ，当前目标值 tar 。
终止条件： 若节点 root 为空，则直接返回。
递推工作：
路径更新： 将当前节点值 root.val 加入路径 path ；
目标值更新： tar = tar - root.val（即目标值 tar 从 sum 减至 000 ）；
路径记录： 当 ① root 为叶节点 且 ② 路径和等于目标值 ，则将此路径 path 加入 res 。
先序遍历： 递归左 / 右子节点。
路径恢复： 向上回溯前，需要将当前节点从路径 path 中删除，即执行 path.pop() 。

作者：jyd
链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/mian-shi-ti-34-er-cha-shu-zhong-he-wei-mou-yi-zh-5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    LinkedList<List<Integer>> list=new LinkedList<>();
    LinkedList<Integer> list1=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {       
        luJing(root,sum);
        return list;
    }
    void luJing(TreeNode root,int sum){
        if(root==null)
            return;
        list1.add(root.val);
        sum=sum-root.val;
        if(sum==0&&root.left==null&&root.right==null){
            list.add(new LinkedList(list1));

        }
        luJing(root.left,sum);
        luJing(root.right,sum);
        list1.removeLast();
    }
}