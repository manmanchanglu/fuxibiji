//������Ӵ�
������������е������ǣ�������ͬ���������ַ���������ͨ��ɾ��ĳ���ַ����ﵽ��ͬ
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
                    dp[i][j]=0;//������������е�����
                }
            }
        }
        //return dp[m][n];�ҳ����ֵ
		int temp=0;
		for(int i=1;i<=m;i++)
			for(int j=1;j<=n;j++){
			if(temp<dp[i][j])
				temp=dp[i][j];
		}

		return temp;

    }
}