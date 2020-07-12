/*面试题25. 合并两个排序的链表
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
示例1：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
算法流程：

初始化： 伪头节点 dum ，节点 cur 指向 dum 。
循环合并： 当 l1 或 l2 为空时跳出；
	当 l1?.val<l2?.val 时： cur 的后继节点指定为 l1? ，并 l1? 向前走一步；
	当 l1?.val≥l2?.val 时： cur 的后继节点指定为 l2? ，并 l2? 向前走一步 ；
	节点 cur向前走一步，即 cur=cur.next 。
合并剩余尾部： 跳出时有两种情况，即 l1为空 或 l2? 为空。
若 l1≠null ： 将 l1? 添加至节点 cur 之后；
否则： 将 l2? 添加至节点 cur 之后。
返回值： 合并链表在伪头节点 dumd之后，因此返回 dum.next 即可。

作者：jyd
链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/solution/mian-shi-ti-25-he-bing-liang-ge-pai-xu-de-lian-b-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
}

//使用递归求解，重点是找到递归的边界
/*一、算法思想
1.当链表1为空链表时，直接返回链表2；当链表2为空链表时，返回链表1。这两种情况都是递归的边界。
2.当链表1和链表2均不为空时，找出两个链表头节点中值较小者作为新链表的头节点，对于剩余的部分使用递归求解。*/
class Solution {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
        return l2;
        if(l2==null)
        return l1;
        ListNode newNode;
        if(l1.val<l2.val){
            newNode = l1;
            newNode.next = mergeTwoLists(l1.next,l2);
        }else{
            newNode = l2;
            newNode.next = mergeTwoLists(l1,l2.next);
        }

        return newNode;

    }
}


