/*98. ��֤����������
����һ�����������ж����Ƿ���һ����Ч�Ķ�����������
����һ��������������������������
�ڵ��������ֻ����С�ڵ�ǰ�ڵ������
�ڵ��������ֻ�������ڵ�ǰ�ڵ������
�������������������������Ҳ�Ƕ�����������
ʾ�� 1:
����:
    2
   / \
  1   3
���: true
ʾ�� 2:
����:
    5
   / \
  1   4
     / \
    3   6
���: false
����: ����Ϊ: [5,1,4,null,null,3,6]��
     ���ڵ��ֵΪ 5 �����������ӽڵ�ֵΪ 4 ��*/
//˼·���������������������ʱ���������������
�������ʱ���жϵ�ǰ�ڵ��Ƿ�������������ǰһ���ڵ㣬������ڣ�˵������ BST����������������ֱ�ӷ��� false��
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // ����������
        if (!isValidBST(root.left)) {
            return false;
        }
        // ���ʵ�ǰ�ڵ㣺�����ǰ�ڵ�С�ڵ������������ǰһ���ڵ㣬˵��������BST������ false���������������
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // ����������
        return isValidBST(root.right);
    }
}

���ߣ�sweetiee
���ӣ�https://leetcode-cn.com/problems/validate-binary-search-tree/solution/zhong-xu-bian-li-qing-song-na-xia-bi-xu-miao-dong-/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������

//�Լ�д�ĵݹ�ķ�ʽ��ע���������rootֵ������������һ��ֵС����������һ��ֵ��ÿ����֧�ַ����������
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        return panduan(root);

    }
    public boolean panduan(TreeNode root){
        if(root==null)
            return true;
        boolean f1=true;
        boolean f2=true;
        TreeNode p=root.left;
        TreeNode q=root.right;
        if(p!=null){
            if(!xunzhao1(root,p))
                return false;
            f1=panduan(p);
        }
        if(q!=null){
            if(!xunzhao2(root,q))
                return false;
            f2=panduan(q);
        }
        return f1&&f2;
    }
    public boolean xunzhao1(TreeNode root,TreeNode l){
        if(l==null)
            return true;
        if(l.val>=root.val)
            return false;        
        return xunzhao1(root,l.left)&&xunzhao1(root,l.right);

    }
    public boolean xunzhao2(TreeNode root,TreeNode r){
        if(r==null)
            return true;
        if(r.val<=root.val)
            return false;        
        return xunzhao2(root,r.left)&&xunzhao2(root,r.right);

    }
}