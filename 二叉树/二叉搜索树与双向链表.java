/*面试题36. 二叉搜索树与双向链表
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
解题思路：
本文解法基于性质：二叉搜索树的中序遍历为 递增序列 。
将 二叉搜索树 转换成一个 “排序的循环双向链表” ，其中包含三个要素：

排序链表： 节点应从小到大排序，因此应使用 中序遍历 “从小到大”访问树的节点；
双向链表： 在构建相邻节点（设前驱节点 preprepre ，当前节点 curcurcur ）关系时，不仅应 pre.right=curpre.right = curpre.right=cur ，也应 cur.left=precur.left = precur.left=pre 。
循环链表： 设链表头节点 headheadhead 和尾节点 tailtailtail ，则应构建 head.left=tailhead.left = tailhead.left=tail 和 tail.right=headtail.right = headtail.right=head 。

作者：jyd
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
//重点在于重写中序遍历算法，在中序遍历的同时，将节点变成双向链表，靠着pre,root,tail指针完成遍历和双向过程
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node head,pre,tail;
    public Node treeToDoublyList(Node root) {
        if(root==null)
            return null;
        process(root);
        head.left=tail;
        tail.right=head;
        return head;
        
    }
    private void process(Node root){
        if(root==null)
            return;
        process(root.left);
        if(pre!=null)
            pre.right=root;
        else
            head=root;
        root.left=pre;
        pre=root;
        tail=root;
        
        process(root.right);

    }
}