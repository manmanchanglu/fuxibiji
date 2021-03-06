151. 翻转字符串里的单词
给定一个字符串，逐个翻转字符串中的每个单词。
示例 1：
输入: "the sky is blue"
输出: "blue is sky the"
示例 2：
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

class Solution {
    public String reverseWords(String s) {
        if(s==null||s.length()==0)
            return "";
        String[] ch=s.trim().split(" +");//split(" +")的意思是按照多个空格来拆分数组；
        int m=0;
        int n=ch.length-1;
        while(m<n){
            String f=ch[m];
            ch[m]=ch[n];
            ch[n]=f;
            m++;
            n--;
        }
        StringBuffer buffer1=new StringBuffer();
        for(int j=0;j<ch.length;j++){
            buffer1.append(ch[j]);
            buffer1.append(" ");

        }
        return buffer1.toString().trim();

    }
}


//简易解法
class Solution {
    public String reverseWords(String s) {
        if(s==null||s.length()==0)
            return "";
        String[] ch=s.trim().split(" +");//split(" +")的意思是按照多个空格来拆分数组；
        Collections.reverse(Arrays.asList(ch));
        return String.join(" ",ch);

    }
}