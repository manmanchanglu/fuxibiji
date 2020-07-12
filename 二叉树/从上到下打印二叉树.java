/*面试题32 - I. 从上到下打印二叉树
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
例如:
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回：
[3,9,20,15,7]*/
//思路：二叉树的层序遍历，利用队列的先进先出层层遍历
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
    public int[] levelOrder(TreeNode root) {
        LinkedList<TreeNode> list=new LinkedList<>();
        LinkedList<TreeNode> tem;
        if(root==null)
            return new int[0];
        list.add(root);
        ArrayList<Integer> res=new ArrayList<>(); 
        while(!list.isEmpty()){
            tem=new LinkedList();
            for(TreeNode node : list){
                if(node.left!=null)
                    tem.add(node.left);
                if(node.right!=null)
                    tem.add(node.right);
                res.add(node.val);
            }
            list=tem;

        }
        int[] a=new int[res.size()];
        for(int i=0;i<res.size();i++){
            a[i]=res.get(i);
        }

        return a;

    }
}