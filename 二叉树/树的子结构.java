/*面试题26. 树的子结构
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
B是A的子结构， 即 A中有出现和B相同的结构和节点值。
例如:
给定的树 A:
     3
    / \
   4   5
  / \
 1   2
给定的树 B：
   4 
  /
 1
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
示例 1：
输入：A = [1,2,3], B = [3,1]
输出：false
示例 2：
输入：A = [3,4,5,1,2], B = [4,1]
输出：true*/

/*解题思路：
若树 B 是树 A 的子结构，则子结构的根节点可能为树 A 的任意一个节点。因此，判断树 B 是否是树 A 的子结构，需完成以下两步工作：
先序遍历树 A 中的每个节点 nA ；（对应函数 isSubStructure(A, B)）
判断树 A 中 以 nA 为根节点的子树 是否包含树 B 。（对应函数 recur(A, B)）
算法流程：
名词规定：树 A 的根节点记作 节点 A ，树 B 的根节点称为 节点 B  。
recur(A, B) 函数：
终止条件：
当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true；
当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false ；
当节点 A 和 B 的值不同：说明匹配失败，返回 false ；
返回值：
判断 A 和 B 的左子节点是否相等，即 recur(A.left, B.left) ；
判断 A 和 B 的右子节点是否相等，即 recur(A.right, B.right) ；
isSubStructure(A, B) 函数：
特例处理： 当 树 A为空 或 树 B为空 时，直接返回 false；
返回值： 若树 B 是树 A 的子结构，则必满足以下三种情况之一，因此用或 || 连接；
以 节点 A 为根节点的子树 包含树 BBB ，对应 recur(A, B)；
树 B 是 树 A 左子树 的子结构，对应 isSubStructure(A.left, B)；
树 B 是 树 A 右子树 的子结构，对应 isSubStructure(A.right, B)；
作者：jyd
链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
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
    public boolean isSubStructure(TreeNode A, TreeNode B) {//前序遍历节点找到root匹配的节点
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
    public boolean DoesTree1HaveTree2(TreeNode A,TreeNode B){//判断root匹配的节点是否是其子结构
        if(B==null)
            return true;
        if(A==null)
            return false;
        if(A.val!=B.val)
            return false;
        return DoesTree1HaveTree2(A.left,B.left)&&DoesTree1HaveTree2(A.right,B.right);
    }
}