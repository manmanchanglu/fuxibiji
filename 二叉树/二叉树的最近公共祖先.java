/*������68 - II. �������������������
����һ��������, �ҵ�����������ָ���ڵ������������ȡ�
�ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x��
���� x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
���磬�������¶�����:  root = [3,5,1,6,2,0,8,null,null,7,4]
ʾ�� 1:
����: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
���: 3
����: �ڵ� 5 �ͽڵ� 1 ��������������ǽڵ� 3��
ʾ�� 2:
����: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
���: 5
����: �ڵ� 5 �ͽڵ� 4 ��������������ǽڵ� 5����Ϊ���ݶ�������������Ƚڵ����Ϊ�ڵ㱾��*/

�ⷨ1���ݹ�
����һ�����ݹ��⣬�ݹ���ܺ��뵽���ؼ����Ǳ߽������Ĵ���
��˼·��
��ΪlowestCommonAncestor(root, p, q)�Ĺ������ҳ���rootΪ���ڵ�������ڵ�p��q������������ȣ����Եݹ��������������ۣ�

���p��q�ֱ���root�����ҽڵ㣬��ôroot��������Ҫ�ҵ������������
���p��q����root����ڵ㣬��ô����lowestCommonAncestor(root.left,p,q)
���p��q����root���ҽڵ㣬��ô����lowestCommonAncestor(root.right,p,q)

�߽��������ۣ�

���root��null����˵�������Ѿ��ҵ�����ˣ�����null��ʾû�ҵ�
���root��p��Ȼ�����q��ȣ��򷵻�root
���������û�ҵ����ݹ麯������null��֤��p��qͬ��root���Ҳ࣬��ô���յĹ������Ⱦ����������ҵ��Ľ��
���������û�ҵ����ݹ麯������null��֤��p��qͬ��root����࣬��ô���յĹ������Ⱦ����������ҵ��Ľ��

���ߣ�yuanninesuns
���ӣ�https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/jian-dan-yi-dong-xiang-jie-ru-xia-by-yuanninesuns/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root==null || root==p || root==q)
        return root;
    
    TreeNode leftNode=lowestCommonAncestor(root.left,p,q);
    TreeNode rightNode=lowestCommonAncestor(root.right,p,q);

    if(leftNode==null)
        return rightNode;
    if(rightNode==null)
        return leftNode;

    return root;
}

���ߣ�yuanninesuns
���ӣ�https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/jian-dan-yi-dong-xiang-jie-ru-xia-by-yuanninesuns/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������

//�Լ�д�İ汾
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root.val==p.val||root.val==q.val)
            return root;
        if(zishu(root.left,p)&&zishu(root.left,q))
            return lowestCommonAncestor(root.left,p,q);
        if(zishu(root.right,p)&&zishu(root.right,q))
            return lowestCommonAncestor(root.right,p,q);
        return root;
        
    }
    public boolean zishu(TreeNode root, TreeNode l){
        if(root==null)
            return false;
        if(root.val==l.val)
            return true;

        return zishu(root.left,l)||zishu(root.right,l);
        
    }
}