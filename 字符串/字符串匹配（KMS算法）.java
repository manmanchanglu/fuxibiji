public class Colution11 {
	public static void main(String[] args) {
		String s="qwertyu";
		String module="ert";
		boolean n=piPei(s,module);
	}
	public static boolean piPei(String s,String module) {//�������̻��ǻ����ı�����ֻ������ƥ�䲻���ʵ�ʱ��ָ�뾡�������ˣ�����ƥ���ʹģʽ����������
		int s1=s.length();
		int m1=module.length();
		boolean f=false;
		int i=0;
		int[] qwer=yingShe(s);
		while(i<=s1-m1) {
			int q=i;
			for(int j=0;j<m1;j++) {
				char a1=s.charAt(i);
				char a2=module.charAt(j);
				if(a1==a2) {
					if(j==m1-1) {
						f=true;
						break;
					}
					else {
						i++;
					}
					
				}
				else {
					int z=i-q-qwer[j];//�ƶ�λ��=��ƥ�䳤��-��Ӧ�Ĳ���ƥ��ֵ
					i=q+z;
					break;
				}
			}
		}
		return f;
	}
	public static int[] yingShe(String s) {
		char[] a=s.toCharArray();
		int[] b=new int[a.length];
		for(int i=0;i<a.length;i++) {//
			if(i==0)
				b[i]=0;
			else if(i==1) {
				if(a[0]==a[1])
					b[i]=1;
				else
					b[i]=0;
			}
			else {
				int theLength2=i;				 
				boolean hasEqual=false;				 				 
				for(int j=theLength2-1;j>=0;j--){//����ƥ��ֵ					 
					String prefix_str=s.substring(0, j+1);					 
					String suffix_str=s.substring(theLength2-j,theLength2+1);					 
					if(prefix_str.endsWith(suffix_str)){						 
						hasEqual=true;						 
						b[i]=prefix_str.length();//ƥ��ֵ��Ϊ�ҵ���ƥ���ַ�����С						 						 
						break;					 
						}					 
								 
					}				 
				if(hasEqual==false){					 
					b[i]=0;				 
				}
				
			}
		}
	}

}
