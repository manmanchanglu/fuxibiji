/*面试题52. 两个链表的第一个公共节点
输入两个链表，找出它们的第一个公共节点。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
思路分析：
如果让两指针分别走一步便判断一次，如果是同一结点就是交结点。这样的做法是错误的，
原因在于：两条链表不一样长，其到达交点的路程不一样。如何处理这个问题？我让路程长指针先走几个结点，
就可以保证两根指针最后同时到达链表尾，也就可以同时到达交结点（如果有的话）
所以得先确定哪个指针路程长，让其先走几个结点。
辅助函数int getLength(ListNode head)用于计数某个链表的长度：通过移动指针temp的循环确定链表长度。
通过lengthA与lengthB大小，判断哪个指针先走，先走的指针要走的步数即为abs(lengthA-lengthB)。
"站在同一起跑线后"，就可以指针每移动一次，判断是否走到同一个结点，若是，该结点即为交结点。
对于没有交点的情况，最终a与b会同时成为null，然后while循环结束，返回a也就是null。
时间复杂度涉及到遍历链表O(m+n)，空间复杂度，由于只使用了四个常量（两个int，两个node）,所以是O(1)的。

作者：ustcyyw
链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/mian-shi-ti-52java-shuang-zhi-zhen-da-bai-100-by-u/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA), lengthB = getLength(headB);
        ListNode a = headA, b = headB;
        if(lengthA > lengthB){
            for(int i = 0; i < lengthA - lengthB; i++)
                a = a.next;
        } else {
            for(int i = 0; i < lengthB - lengthA; i++)
                b = b.next;
        }
        while(a != b){
            a = a.next;
            b = b.next;
        }
        return a;
    }
    private int getLength(ListNode head){
        int length = 0;
        for(ListNode temp = head; temp != null; temp = temp.next, length++);
        return length;
    }
}
//另一种思路利用栈的先进后出思想，从两链表最后一个元素开始比较，当不相同时，找到第一个公共节点