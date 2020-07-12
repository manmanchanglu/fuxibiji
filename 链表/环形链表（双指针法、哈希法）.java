//判断链表是否有环
//解题思路1：利用HashSet的无重复性，将遍历过的节点存放进去，如果重复则说明有环，则时间和空间复杂度都为O(n)
//解题思路2：优化空间解法，使空间复杂度为O(1)，利用双指针p1和p2，遍历时，p1走一个节点，p2一次走两个节点如果相遇则说明有环，
//原理利用数学上的追及问题，跑道上。跑得快的会追上跑得慢的
import java.util.LinkedList;

public class Colution13 {
	public static void main(String[] args) {
		LinkedList head;
		System.out.println(panduan(head));
		
	}
	public static boolean panduan(LinkedList head) {
		LinkedList p1=head,p2=head;
		boolean f=false;
		while(p1!=null&&p2!=null) {
			if(p1==p2) {
				f=true;
				break;
			}
			else {
				p1=p1.next();
				p2=p2.next().next();
			}
		}
		return f;
	}

}
