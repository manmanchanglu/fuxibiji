115. ��ͬ��������
����һ���ַ��� S ��һ���ַ��� T�������� S ���������� T ���ֵĸ�����
һ���ַ�����һ����������ָ��ͨ��ɾ��һЩ��Ҳ���Բ�ɾ�����ַ��Ҳ�����ʣ���ַ����λ������ɵ����ַ����������磬"ACE" �� "ABCDE" ��һ�������У��� "AEC" ���ǣ�
��Ŀ���ݱ�֤�𰸷��� 32 λ������������Χ��
ʾ�� 1��
���룺S = "rabbbit", T = "rabbit"
�����3
���ͣ�
����ͼ��ʾ, �� 3 �ֿ��Դ� S �еõ� "rabbit" �ķ�����
(�ϼ�ͷ���� ^ ��ʾѡȡ����ĸ)
rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
ʾ�� 2��
���룺S = "babgbag", T = "bag"
�����5
���ͣ�
����ͼ��ʾ, �� 5 �ֿ��Դ� S �еõ� "bag" �ķ����� 
(�ϼ�ͷ���� ^ ��ʾѡȡ����ĸ)
babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^

class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] dp=new int[n+1][m+1];//Ĭ�ϳ�ʼ��Ϊ0
        for(int i=0;i<m+1;i++)
            dp[0][i]=1;
        for(int i=1;i<n+1;i++){
            for(int j=i;j<m+1;j++){
                if(t.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j-1];//�е㲻����
                }
                else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[n][m];
        
    }
}
