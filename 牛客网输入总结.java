import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//输入为一个字符串时
abcd

        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取字符串
        String line = br.readLine();
        // 测试输入是否正确
        System.out.println(line);

//若输入为多个数字
1   2
        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取第一行数据
        String line = br.readLine();
        // 将字符串根据空格进行分隔
        String[] strings = line.trim().split(" ");
        // 分别将其中的每个数值读出
        int n = Integer.parseInt(strings[0]);
        int v = Integer.parseInt(strings[1]);
       // 测试输入是否正确
        System.out.println("n: " + n + "\tv: " + v);

//若输入中有一个数组，且有数组的长度
7 6
1 2 3 4 5 6 7

        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取第一行数据
        String line = br.readLine();
        // 将字符串根据空格进行分隔
        String[] strings = line.trim().split(" ");
        // 分别将其中的每个数值读出
        int n = Integer.parseInt(strings[0]);
        int v = Integer.parseInt(strings[1]);
        // 读取第二行数据
        line = br.readLine();
        strings = line.trim().split(" ");
        // 创建一个int型的数组用来储存第二行的多个数字
        int[] nums = new int[n];
        for (int i = 0; i < n; i ++) {
            nums[i] = Integer.parseInt(strings[i]);
        } 
        // 测试输入是否正确
        for (int num: nums) {
            System.out.print(num + " ");
        }



 

    public static void main1(String[] args) {

        Scanner sc = new Scanner(System.in);

        //获取输入的整数序列

        String str = sc.nextLine();

        String[] strings = str.split(" ");

        //转为整数数组

        int[] ints = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {

            ints[i] = Integer.parseInt(strings[i]);

        }

        System.out.println(getTargetMax(ints));

    }

 



//1.输入两行数据，每行的数据用逗号分开
如：1,3,5

    2,4,6

		import java.util.Scanner;
		public static void main(String[] args){		
			Scanner sc = new Scanner(System.in);
			// 存储两行数据
			String[] str1 = new String[2];             
			for(int i=0; i<2; i++) {
				str1[i] = sc.nextLine();
			}	
			// 转化存储第一行数据	
			String[] string0 = str1[0].split(",");     
			int[] arr0 = new int[string0.length];   
			for(int i=0; i<string0.length; i++) {
				arr0[i] = Integer.valueOf(string0[i]);
			}   
		   // 转化存储第二行数据    
			String[] string1 = str1[1].split(",");     
			int[] arr1 = new int[string1.length];   
			for(int i=0; i<string1.length; i++) {
				arr1[i] = Integer.valueOf(string1[i]);
			}        
			// 测试打印
			for(String s:string0) {
			   System.out.print(s);
			}
			for(String s:string1) {
			   System.out.print(s);
			}	    
		}


////.......................................................................................................///////
如果使用Scanner sc=new Scanner(System.in)的模式的话
sc.nextLine()//每次读取一行
sc.nextInt()//每次只读取一个字节，回车或空格都算读取结束
///////////注意点
如果我们先读取一个整数，再读取一个字符串，像这样输入
3
qwerrr
然后代码如下：
int a=sc.nextInt()
String s=sc.nextLine();
则实际上s读取到的是/n,而不是字符串，因为nextInt读取完字节后，nextLine是以回车/n作为该行结束的，
所以第一行结束后回车被nextLine()读取了，就结束了，第二行根本没读取，想要真正读取代码得如下：
int a=sc.nextInt()
String s=sc.nextLine();
s=sc.nextLine();