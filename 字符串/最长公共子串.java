//最长公共子串
与最长公共子序列的区别是，它们相同是连续的字符串，不能通过删除某个字符来达到相同
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else{
                    dp[i][j]=0;//与最长公共子序列的区别
                }
            }
        }
        //return dp[m][n];找出最大值
		int temp=0;
		for(int i=1;i<=m;i++)
			for(int j=1;j<=n;j++){
			if(temp<dp[i][j])
				temp=dp[i][j];
		}

		return temp;

    }
}