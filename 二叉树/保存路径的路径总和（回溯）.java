113. 路径总和 II
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
说明: 叶子节点是指没有子节点的节点。
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

相比于leetcode112，这个题是找满足条件的所有path，即并不是找到就停，而是要遍历所有的path。
思路：
要建立list组成的list来存最终的result，要建立list去存当前的这个路径。
接下来思路与之前近乎相同，采用recursion的方法，先遍历左侧，如果没有满足条件且是leaf,则倒退一个node，继续右枝（如果有的话）。
将每一个遍历到的node放入curPath，然后改变条件至sum-node.val。
如果满足条件，则存下当前的一个list，也就是curPath；如果不满足条件，则将sum改为sum-node.val继续进行recursion。
最重要的一点，当我们到达了某一个leaf的时候，我们发现当前path并不满足和为sum的时候，我们在倒退会上一个node的同时，要在curPath中清除当前节点！！！！

作者：donoghl
链接：https://leetcode-cn.com/problems/path-sum-ii/solution/java-dfs-2-by-donoghl/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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

作者：donoghl
链接：https://leetcode-cn.com/problems/path-sum-ii/solution/java-dfs-2-by-donoghl/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。