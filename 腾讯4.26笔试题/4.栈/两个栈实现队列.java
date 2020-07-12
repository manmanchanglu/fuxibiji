package fzk;

import java.util.Scanner;
import java.util.Stack;

public class Qwer2 {
	static Stack stack1=new Stack();
	static Stack stack2=new Stack();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		String s=null;
		s=sc.nextLine();
		for(int n=0;n<a;n++) {
			s=sc.nextLine();
			queue(s);
		}
	}
	public static void queue(String s) {
		if(s.contains(" ")) {
			stack1.push(s.split(" ")[1]);
		}
		if(s.equals("peek")) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			System.out.println(stack2.peek());
		}
		if(s.equals("poll")) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			stack2.pop();
			
		}
	}

}
