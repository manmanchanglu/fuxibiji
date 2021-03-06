/*面试题18. 删除链表的节点
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
返回删除后的链表的头节点。
注意：此题对比原题有改动
示例 1:
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:
输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val&&head.next!=null){//边界条件：头结点、尾结点，只有一个结点
            return head.next;
        }
        if(head.val==val&&head.next==null){
            return null;
        }
        ListNode p=head;
        ListNode p2=p;
        while(p!=null){
            if(p.val==val){
                
                ListNode p1=p.next;
                if(p1==null){
                    p2.next=null;
                }
                else{
                    
                    p.val=p1.val;
                    p.next=p1.next;
                    break;
                }
            }
            p2=p;
            p=p.next;
        }
        return head;

    }
}
//第二种情形给的是删除的节点，不是节点的值，使时间复杂度为O（1），思路考虑将下一个节点覆盖删除的节点即可满足