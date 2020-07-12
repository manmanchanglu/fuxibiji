/*98. 验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。
假设一个二叉搜索树具有如下特征：
节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:
输入:
    2
   / \
  1   3
输出: true
示例 2:
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。*/
//思路：二叉搜索树在中序遍历时，满足递增的条件
中序遍历时，判断当前节点是否大于中序遍历的前一个节点，如果大于，说明满足 BST，继续遍历；否则直接返回 false。
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
}

作者：sweetiee
链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/zhong-xu-bian-li-qing-song-na-xia-bi-xu-miao-dong-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//自己写的递归的方式，注意整体符合root值大于左子树任一个值小于右子树任一个值，每个分支又符合上述情况
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