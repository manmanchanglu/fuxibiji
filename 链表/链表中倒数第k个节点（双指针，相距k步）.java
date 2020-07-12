/*面试题22. 链表中倒数第k个节点
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
示例：
给定一个链表: 1->2->3->4->5, 和 k = 2.
返回链表 4->5.
解题思路：
第一时间想到的解法：
先遍历统计链表长度，记为 n ；
设置一个指针走 (n?k) 步，即可找到链表倒数第 k个节点。
使用双指针则可以不用统计链表长度。
作者：jyd
链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/solution/mian-shi-ti-22-lian-biao-zhong-dao-shu-di-kge-j-11/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
算法流程：
初始化： 前指针 former 、后指针 latter ，双指针都指向头节点 head? 。
构建双指针距离： 前指针 former 先向前走 k步（结束后，双指针 former 和 latter 间相距 k 步）。
双指针共同移动： 循环中，双指针 former 和 latter  每轮都向前走一步，
直至 former 走过链表 尾节点 时跳出（跳出后， latter 与尾节点距离为 k?1，即 latter 指向倒数第 k个节点）。
返回值： 返回 latter 即可。*/
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
		if(head==null || k==0)
			return null;
        for(int i = 0; i < k; i++)//先走k步，再同步走
            former = former.next;
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}

//自己写的
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode a=head;
        ListNode b=head;
        int m=1;
        while(a.next!=null){
            a=a.next;
            m++;
            if(m>k)
                b=b.next;
        }
        if(m<k)
            return null;
        else
            return b;

    }
}