package fzk;

import java.util.Scanner;

public class Qwer1 {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		String s;
		double q=0,min=0;
		for(int i=0;i<a;i++) {
			int[][] c=new int[b*2][2];
			s=sc.nextLine();
			for(int j=0;j<b*2;j++) {
				//int[][] c=new int[b*2][2];
				s=sc.nextLine();
				//System.out.println(s);
				if(s.contains(" ")) {//不加这个判断会出现String index out of range: 0异常
				c[j][0]=s.split(" ")[0].charAt(0)-'0';
				c[j][1]=s.split(" ")[1].charAt(0)-'0';
				}
			}
			//int d=b-1;
			for(int m=0;m<b;m++) {
				for(int n=b;n<b*2;n++) {
					q=qiuzhi(c[m],c[n]);
					if(q<min)
						min=q;
				}
			}
			System.out.printf("%.3f\r\n",min);
			if(i==a-1)
				break;
			else
				b=sc.nextInt();
		}
	}
	public static double qiuzhi(int[]m,int[]n) {
		double sum;
		double x1=m[0];
		double x2=n[0];
		double y1=m[1];
		double y2=n[1];
		sum=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		return sum;

		//System.out.printf("%.2f\r\n",sum);
	}

}
