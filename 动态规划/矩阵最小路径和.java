64. ��С·����
����һ�������Ǹ������� m x n �������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
˵����ÿ��ֻ�����»��������ƶ�һ����
ʾ��:
����:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
���: 7
����: ��Ϊ·�� 1��3��1��1��1 ���ܺ���С��



�㷨
�����½�һ������� dp ���飬��ԭ�����С��ͬ������������У�dp(i,j) ��ʾ������ (i,j) �����½ǵ���С·��Ȩֵ��
���ǳ�ʼ�����½ǵ� dp ֵΪ��Ӧ��ԭ����ֵ��Ȼ��ȥ���������󣬶���ÿ��Ԫ�ؿ����ƶ����ұ߻������棬��˻����С·�������������µ��ƹ�ʽ��
dp(i,j)=grid(i,j)+min?(dp(i+1,j),dp(i,j+1))

���ߣ�LeetCode
���ӣ�https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-by-leetcode/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }
}

���ߣ�LeetCode
���ӣ�https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-by-leetcode/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
//���Ͻǿ�ʼ�Ĵ���
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
 
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n));
        
        for(int i = 0; i < grid.size(); i++)
        {
            for(int j = 0; j < grid[0].size(); j ++)
            {
                if(i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else if(i == 0 )
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                else if(j == 0)
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                else  
                    dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
};