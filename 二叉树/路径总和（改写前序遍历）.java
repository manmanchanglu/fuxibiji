112. ·���ܺ�
����һ����������һ��Ŀ��ͣ��жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽڵ��·��������·�������нڵ�ֵ��ӵ���Ŀ��͡�
˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
ʾ��: 
�������¶��������Լ�Ŀ��� sum = 22��

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
���� true, ��Ϊ����Ŀ���Ϊ 22 �ĸ��ڵ㵽Ҷ�ӽڵ��·�� 5->4->11->2��
//��д��ȱ�����ǰ��������ڱ�����ʱ�����ж�
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        sum-=root.val;
        if(root.left==null&&root.right==null)//���������������������Ϊ�жϵ�ǰ�ڵ��Ƿ�Ϊ����Ϊ�����������Ļ����߽�������ȫ
            return sum==0;
        else
            return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
        

    }
   
}