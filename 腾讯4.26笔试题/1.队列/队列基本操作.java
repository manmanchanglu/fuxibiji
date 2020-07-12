package fzk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class qwer {
	static LinkedList<String> queue=new LinkedList<String>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		String s=null;
		for(int n=0;n<a;a++) {
			s=sc.nextLine();
			for(int d=0;d<b;d++) {
				s=sc.nextLine();
				queue1(s);
				
			}
			b=sc.nextInt();
			
		}
		
	}
	private static  void queue1(String s) {
		
						
			if(s.equals("TOP")) {
				if(queue.size()==0)
					System.out.println(-1);
				else {
					
					System.out.println(queue.getFirst());
				}
				
				
			}
		    if(s.equals("POP")) {
				if(queue.size()==0)
					System.out.println(-1);
				else {
					String a=queue.poll();
					
				}
				
			}
			if(s.equals("SIZE")) {
				int c=queue.size();
				System.out.println(c);
			}
			if(s.equals("CLEAR"))
				queue.clear();
		
			if(s.contains(" ")) {
                queue.add(s.split(" ")[1]);
                
            }
			
			
			
		
	}

}
