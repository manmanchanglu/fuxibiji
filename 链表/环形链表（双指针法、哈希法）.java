//�ж������Ƿ��л�
//����˼·1������HashSet�����ظ��ԣ����������Ľڵ��Ž�ȥ������ظ���˵���л�����ʱ��Ϳռ临�Ӷȶ�ΪO(n)
//����˼·2���Ż��ռ�ⷨ��ʹ�ռ临�Ӷ�ΪO(1)������˫ָ��p1��p2������ʱ��p1��һ���ڵ㣬p2һ���������ڵ����������˵���л���
//ԭ��������ѧ�ϵ�׷�����⣬�ܵ��ϡ��ܵÿ�Ļ�׷���ܵ�����
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
