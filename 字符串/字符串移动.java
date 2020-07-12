字符串移动
假设一个字符串只含有字符"*"和az字母。现在请你写一段代码，把所有的字符*放到字母的左边，字母则按照原有的顺序都放在右边。
输入描述
输入的字符串
输出描述
输出的字符串
示例1
输入
*c*m*b*n*t*
输出
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
————————————————
版权声明：本文为CSDN博主「大大大大大大旭」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/bravedence/article/details/104884415