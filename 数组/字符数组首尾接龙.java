/*�ַ���������β���򣬼�ÿ���ַ�������β�ַ����������ϣ��γ�һ����
��{"aqwfd","dertg","gtyui","iuhhm"}*/
import java.util.ArrayList;
import java.util.List;

public class Colution9 {
	public static void main(String[] args) {
		String[] arr= {"adce","edfv","vwthf","frya"};
		System.out.println(canArrangeWords(arr));
	}
	public static int canArrangeWords(String[] arr) {
		int n=arr.length;
		if(n<2)
			return -1;
		List<Character> list=new ArrayList();
		for(int i=0;i<n;i++) {
			char[] a=arr[i].toCharArray();
			int b=a.length;
			if(b<1) {
				return -1;
			}
			if(list.contains(a[0])) {
				list.remove(list.indexOf(a[0]));
			}
			else {
				list.add(a[0]);
			}
			if(list.contains(a[b-1])) {
				list.remove(list.indexOf(a[b-1]));//���ҵ��ַ���list�е�λ�����꣬��ͨ��λ������ȥɾ����list.remove(a[b-1])�ᷢ��Խ�磬��֪��Ϊɶ
			}
			else {
				list.add(a[b-1]);
			}
		}
		int z=list.size();
		if(z==2||z==0)
			return 1;
		else
			return -1;
		
	}
	

}
