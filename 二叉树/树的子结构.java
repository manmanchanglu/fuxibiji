/*������26. �����ӽṹ
�������ö�����A��B���ж�B�ǲ���A���ӽṹ��(Լ��������������һ�������ӽṹ)
B��A���ӽṹ�� �� A���г��ֺ�B��ͬ�Ľṹ�ͽڵ�ֵ��
����:
�������� A:
     3
    / \
   4   5
  / \
 1   2
�������� B��
   4 
  /
 1
���� true����Ϊ B �� A ��һ������ӵ����ͬ�Ľṹ�ͽڵ�ֵ��
ʾ�� 1��
���룺A = [1,2,3], B = [3,1]
�����false
ʾ�� 2��
���룺A = [3,4,5,1,2], B = [4,1]
�����true*/

/*����˼·��
���� B ���� A ���ӽṹ�����ӽṹ�ĸ��ڵ����Ϊ�� A ������һ���ڵ㡣��ˣ��ж��� B �Ƿ����� A ���ӽṹ���������������������
��������� A �е�ÿ���ڵ� nA ������Ӧ���� isSubStructure(A, B)��
�ж��� A �� �� nA Ϊ���ڵ������ �Ƿ������ B ������Ӧ���� recur(A, B)��
�㷨���̣�
���ʹ涨���� A �ĸ��ڵ���� �ڵ� A ���� B �ĸ��ڵ��Ϊ �ڵ� B  ��
recur(A, B) ������
��ֹ������
���ڵ� B Ϊ�գ�˵���� B ��ƥ����ɣ�Խ��Ҷ�ӽڵ㣩����˷��� true��
���ڵ� A Ϊ�գ�˵���Ѿ�Խ���� A Ҷ�ӽڵ㣬��ƥ��ʧ�ܣ����� false ��
���ڵ� A �� B ��ֵ��ͬ��˵��ƥ��ʧ�ܣ����� false ��
����ֵ��
�ж� A �� B �����ӽڵ��Ƿ���ȣ��� recur(A.left, B.left) ��
�ж� A �� B �����ӽڵ��Ƿ���ȣ��� recur(A.right, B.right) ��
isSubStructure(A, B) ������
�������� �� �� AΪ�� �� �� BΪ�� ʱ��ֱ�ӷ��� false��
����ֵ�� ���� B ���� A ���ӽṹ��������������������֮һ������û� || ���ӣ�
�� �ڵ� A Ϊ���ڵ������ ������ BBB ����Ӧ recur(A, B)��
�� B �� �� A ������ ���ӽṹ����Ӧ isSubStructure(A.left, B)��
�� B �� �� A ������ ���ӽṹ����Ӧ isSubStructure(A.right, B)��
���ߣ�jyd
���ӣ�https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������*/
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
    public boolean isSubStructure(TreeNode A, TreeNode B) {//ǰ������ڵ��ҵ�rootƥ��Ľڵ�
        boolean result=false;
        if(A!=null&&B!=null){
            if(A.val==B.val)
                result=DoesTree1HaveTree2(A,B);
            if(!result)
                result=isSubStructure(A.left,B);
            if(!result)
                result=isSubStructure(A.right,B);
        }
        return result;

    }
    public boolean DoesTree1HaveTree2(TreeNode A,TreeNode B){//�ж�rootƥ��Ľڵ��Ƿ������ӽṹ
        if(B==null)
            return true;
        if(A==null)
            return false;
        if(A.val!=B.val)
            return false;
        return DoesTree1HaveTree2(A.left,B.left)&&DoesTree1HaveTree2(A.right,B.right);
    }
}