������68 - I. �����������������������
����һ������������, �ҵ�����������ָ���ڵ������������ȡ�
�ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x��
���� x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
���磬�������¶���������:  root = [6,2,8,0,4,7,9,null,null,3,5] 
ʾ�� 1:
����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
���: 6 
����: �ڵ� 2 �ͽڵ� 8 ��������������� 6��
ʾ�� 2:
����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
���: 2
����: �ڵ� 2 �ͽڵ� 4 ��������������� 2, ��Ϊ���ݶ�������������Ƚڵ����Ϊ�ڵ㱾��
//˼·��ǰ��������ڱ�����ʱ������ж��������ж����ڵ㵽���������������������Ǳ���ڵ��������֮һ
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        
        if(root.val==p.val||root.val==q.val)
            return root;
        if(root.val>p.val&&root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        if(root.val<p.val&&root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        return root;
        

        
    }
}