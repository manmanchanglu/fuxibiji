/*面试题24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
好理解的双指针
定义两个指针： pre和 cur ；pre 在前 cur 在后。
每次让 pre 的 next 指向 cur ，实现一次局部反转
局部反转完成之后， pre 和 cur 同时往前移动一个位置
循环上述过程，直至 pre 到达链表尾部
要提前把pre下一个节点保存起来防止链表断裂
作者：huwt
链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/fan-zhuan-lian-biao-yi-dong-de-shuang-zhi-zhen-jia/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
       
        ListNode prehead=null;
        ListNode p1=head;
        ListNode pPrev=null;
        while(p1!=null){
            ListNode pnext=p1.next;//先把下一节点保存起来，防止链表断裂
            if(pnext==null)
                prehead=p1;
            p1.next=pPrev;
            pPrev=p1;
            p1=pnext;
        }
        return prehead;

    }
}