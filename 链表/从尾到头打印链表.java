/*面试题06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
示例 1：
输入：head = [1,3,2]
输出：[2,3,1]
限制：
0 <= 链表长度 <= 10000*/
//思路：反转输出，符合先进后出原则，把链表数据存入一个栈中，然后再输出，就反序了
//递归底层实现也是栈
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> ac=new Stack<Integer>();
        ListNode p=head;
        while(p!=null){
            ac.push(p.val);
            p=p.next;
        }
        int n=ac.size();
        int[] m=new int[n];
        for(int i=0;i<n;i++){
            m[i]=ac.pop();
        }
        return m;

    }
}
//官方递归法
class Solution {
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }
    void recur(ListNode head) {
        if(head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-d/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
