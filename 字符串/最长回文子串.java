5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：
输入: "cbbd"
输出: "bb"
//从中间向两边扩散
class Solution {
    private int lengh=0;
    private int d=0;
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==1)
            return s;
        if(n==0)
            return "";
        for(int i=0;i<n;i++){
            bijiao(s,i,i);
            bijiao(s,i,i+1);

        }
        return s.substring(d,d+lengh);
        
    }
    public void bijiao(String s,int a,int b){
        while(a>=0&&b<s.length()&&s.charAt(a)==s.charAt(b)){
            a--;
            b++;
        }
        if(lengh<b-a-1){
            lengh=b-a-1;
            d=a+1;
        }
    }
}

//使用动态规划解法
//dp[i][j]里面的i,j代表的是字符串的左右下标
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        String res="";
        boolean[][] dp=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                dp[i][j]=s.charAt(i)==s.charAt(j)&&(j-i<2||dp[i+1][j-1]);
                if(dp[i][j]&&j-i+1>res.length()){
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;

    }
}