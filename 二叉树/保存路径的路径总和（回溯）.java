113. ·���ܺ� II
����һ����������һ��Ŀ��ͣ��ҵ����дӸ��ڵ㵽Ҷ�ӽڵ�·���ܺ͵��ڸ���Ŀ��͵�·����
˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
ʾ��:
�������¶��������Լ�Ŀ��� sum = 22��

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
����:

[
   [5,4,11,2],
   [5,8,4,5]
]

�����leetcode112�������������������������path�����������ҵ���ͣ������Ҫ�������е�path��
˼·��
Ҫ����list��ɵ�list�������յ�result��Ҫ����listȥ�浱ǰ�����·����
������˼·��֮ǰ������ͬ������recursion�ķ������ȱ�����࣬���û��������������leaf,����һ��node��������֦������еĻ�����
��ÿһ����������node����curPath��Ȼ��ı�������sum-node.val��
�����������������µ�ǰ��һ��list��Ҳ����curPath�������������������sum��Ϊsum-node.val��������recursion��
����Ҫ��һ�㣬�����ǵ�����ĳһ��leaf��ʱ�����Ƿ��ֵ�ǰpath���������Ϊsum��ʱ�������ڵ��˻���һ��node��ͬʱ��Ҫ��curPath�������ǰ�ڵ㣡������

���ߣ�donoghl
���ӣ�https://leetcode-cn.com/problems/path-sum-ii/solution/java-dfs-2-by-donoghl/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curPath = new LinkedList<>();
        recur(result, curPath, root, sum);
        return result;
    }

    private void recur(List<List<Integer>> result, List<Integer> curPath, TreeNode curNode, int sum){
        if(curNode == null){
            return;
        }
        curPath.add(curNode.val);
        if(curNode.val == sum && curNode.left == null && curNode.right == null){
            result.add(new ArrayList<>(curPath));
        }else{
            recur(result, curPath, curNode.left, sum - curNode.val);
            recur(result, curPath, curNode.right, sum - curNode.val);
        }
        curPath.remove(curPath.size() - 1);
    }
}

���ߣ�donoghl
���ӣ�https://leetcode-cn.com/problems/path-sum-ii/solution/java-dfs-2-by-donoghl/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������