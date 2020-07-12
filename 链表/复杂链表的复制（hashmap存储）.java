/*面试题35. 复杂链表的复制
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
还有一个 random 指针指向链表中的任意节点或者 null。
示例 1：
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：
输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
示例 4：
输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。
解决方案一：对应推荐解法一
还是分为两步:第一步仍然是将原始链表上的每个节点 N复制为N',然后把这些创建出来的节点N’连接起来。
同时我们把<N,N'>的配对信息放到一个HashMap<Node,Node> map中;
第二步设置每个节点的random指针:如果在原始链表中节点 N的random指针指向节点 S,那么在复制链表中,对应的 N'节点应该指向 S'。
由于有了map,我们可以用O(1)的时间根据 S找到 S';
这种解决方案相当于用空间换时间。对于有n个节点的链表,我们需要一个大小为O(n)的HashMap,
也就是说我们以O(n)的空间消耗把时间复杂度由O(n^2)降低至O(n).

作者：mo-fei-25
链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/javashi-xian-jian-zhi-offerliang-chong-si-lu-hashm/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Map<Node,Node> hashMap=new HashMap<>();
        Node res=new Node(head.val);
        Node a1=head;
        Node a2=res;
        hashMap.put(a1,a2);
        while(a1.next!=null){
            Node tem=new Node(a1.next.val);
            a2.next=tem;
            a2=tem;
            a1=a1.next;
            hashMap.put(a1,a2);
        }
         a1=head;
         a2=res;
        while(a1!=null){
            if(a1.random!=null){
                a2.random=hashMap.get(a1.random);
            }
            a1=a1.next;
            a2=a2.next;
        }
        return res;
        
    }
}
