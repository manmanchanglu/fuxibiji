5. ������Ӵ�
����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
ʾ�� 1��
����: "babad"
���: "bab"
ע��: "aba" Ҳ��һ����Ч�𰸡�
ʾ�� 2��
����: "cbbd"
���: "bb"
//���м���������ɢ
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

//ʹ�ö�̬�滮�ⷨ
//dp[i][j]�����i,j��������ַ����������±�
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