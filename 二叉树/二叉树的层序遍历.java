/*102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
示例：
二叉树：[3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]*/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)
            return list;
        List<Integer> qwer;
        List<TreeNode> queue=new ArrayList<>();
        List<TreeNode> cunchu;
        queue.add(root);
        while(!queue.isEmpty()){
            cunchu=new ArrayList<>();
            qwer=new ArrayList<>();
            for(TreeNode node:queue){
                qwer.add(node.val);
                if(node.left!=null)
                    cunchu.add(node.left);
                if(node.right!=null)
                    cunchu.add(node.right);
            }
            list.add(qwer);
            queue=cunchu;
        }
        return list;

    }
}