�ַ����ƶ�
����һ���ַ���ֻ�����ַ�"*"��az��ĸ����������дһ�δ��룬�����е��ַ�*�ŵ���ĸ����ߣ���ĸ����ԭ�е�˳�򶼷����ұߡ�
��������
������ַ���
�������
������ַ���
ʾ��1
����
*c*m*b*n*t*
���
******cmbnt

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  input = sc.nextLine();
        
        char flagChar = '*';
        
        StringBuffer res1 = new StringBuffer();
        StringBuffer res2 = new StringBuffer();
        
        for (int i =0;i<input.length();i++){
            if (input.charAt(i)== flagChar){
                res1.append(flagChar);
            } else {
                res2.append(input.charAt(i));
            }
        }
        
       System.out.printf(res1.toString()+res2.toString());   }
}
��������������������������������
��Ȩ����������ΪCSDN��������������񡹵�ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/bravedence/article/details/104884415