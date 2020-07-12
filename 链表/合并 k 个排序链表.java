�ϲ� k �������������غϲ������������������������㷨�ĸ��Ӷȡ�
ʾ��:
����:
[
  1->4->5,
  1->3->4,
  2->6
]
���: 1->1->2->3->4->4->5->6

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/merge-k-sorted-lists
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) {
			return null;
		}
		//����һ���ѣ�������Ԫ�ص�����ʽ
		PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
			public int compare(ListNode o1, ListNode o2) {
				return (o1.val - o2.val);//��С��
                
			}
		});
		//�����������飬Ȼ��ÿ�������ÿ���ڵ㶼�������
		for(int i=0;i<lists.length;i++) {
			while(lists[i] != null) {
				queue.add(lists[i]);
                
				lists[i] = lists[i].next;
			}
		}
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		//�Ӷ��в���ȡ��Ԫ�أ�����ȡ����Ԫ�ش�������
		while( !queue.isEmpty() ) {
			dummy.next = queue.poll();
			dummy = dummy.next;
		}
		dummy.next = null;
		return head.next;
	

    }
}