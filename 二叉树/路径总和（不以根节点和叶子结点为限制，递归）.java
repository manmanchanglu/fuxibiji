437. ·���ܺ� III
����һ��������������ÿ����㶼�����һ������ֵ��

�ҳ�·���͵��ڸ�����ֵ��·��������

·������Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��

������������1000���ڵ㣬�ҽڵ���ֵ��Χ�� [-1000000,1000000] ��������

ʾ����

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

���� 3���͵��� 8 ��·����:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
���
������Ҫȥ����·���͵��ڸ�����ֵ��·������������������ѭ��ģ�͵Ľ���˼·�����յݹ�ķ�ʽȥ��⣨�ݹ��һ����Ҫ˼����������֣�1.�ҵ���򵥵���������⣬2.�������ⲻ��������ϸ�ڣ�ֻ���������߼�������������������Ƶݹ��ϵ��
���ȣ���򵥵���������ʲô�أ�����������������Ŀ���£������������뵽�ľ��Ǳ�������ֹ������
if(root == null){
    return 0;
}
��������������������������һ����Σ���ĿҪ�� ·������Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩 �����Ҫ������ֻ��Ҫȥ�������ּ��ɣ�
�Ե�ǰ�ڵ���Ϊͷ����·������
�Ե�ǰ�ڵ��������Ϊͷ����·������
�Ե�ǰ�ڵ���Һ�����Ϊͷ��㰡·������
����������֮����Ϊ��������ɡ�
���������ǣ�����Ӧ�����ȥ���Ե�ǰ�ڵ���Ϊͷ����·�������������������ǰ������ı�����ʽģ�壬ÿ��һ���ڵ���sum-root.val�����ж�sum�Ƿ�Ϊ0�����Ϊ��Ļ������ҵ�����������һ��·����
����
���ߣ�ming-zhi-shan-you--m9RfkvKDad
���ӣ�https://leetcode-cn.com/problems/path-sum-iii/solution/437lu-jing-zong-he-iii-di-gui-fang-shi-by-ming-zhi/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int result = countPath(root,sum);
        int a = pathSum(root.left,sum);
        int b = pathSum(root.right,sum);
        return result+a+b;

    }
    public int countPath(TreeNode root,int sum){
        if(root == null){
            return 0;
        }
        sum = sum - root.val;
        int result = sum == 0 ? 1:0;
        return result + countPath(root.left,sum) + countPath(root.right,sum);
    }
}

���ߣ�ming-zhi-shan-you--m9RfkvKDad
���ӣ�https://leetcode-cn.com/problems/path-sum-iii/solution/437lu-jing-zong-he-iii-di-gui-fang-shi-by-ming-zhi/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������