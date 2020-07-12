10. ������ʽƥ��
����һ���ַ��� s ��һ���ַ����� p��������ʵ��һ��֧�� '.' �� '*' ��������ʽƥ�䡣

'.' ƥ�����ⵥ���ַ�
'*' ƥ���������ǰ�����һ��Ԫ��
��νƥ�䣬��Ҫ���� ���� �ַ��� s�ģ������ǲ����ַ�����

˵��:

s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ��
p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� . �� *��
ʾ�� 1:

����:
s = "aa"
p = "a"
���: false
����: "a" �޷�ƥ�� "aa" �����ַ�����
ʾ�� 2:

����:
s = "aa"
p = "a*"
���: true
����: ��Ϊ '*' �������ƥ���������ǰ�����һ��Ԫ��, ������ǰ���Ԫ�ؾ��� 'a'����ˣ��ַ��� "aa" �ɱ���Ϊ 'a' �ظ���һ�Ρ�
ʾ�� 3:

����:
s = "ab"
p = ".*"
���: true
����: ".*" ��ʾ��ƥ�����������'*'�������ַ���'.'����
ʾ�� 4:

����:
s = "aab"
p = "c*a*b"
���: true
����: ��Ϊ '*' ��ʾ������������� 'c' Ϊ 0 ��, 'a' ���ظ�һ�Ρ���˿���ƥ���ַ��� "aab"��
ʾ�� 5:

����:
s = "mississippi"
p = "mis*is*p*."
���: false

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        if(p.length() != 0)   dp[0][1] = false;
        int i = 0, j = 0;
        //��ʼ��dp������
        for(i = 1; i < p.length(); i++){
            if(p.charAt(i) == '*')  dp[0][i + 1] = dp[0][i - 1];
            else    dp[0][i + 1] = false;
        }
        //��ʼ��dp������
        for(i = 0; i < s.length(); i++){
            dp[i + 1][0] = false;
        }
        //��ʼdp
        for(i = 0; i < s.length(); i++){
            for(j = 0; j < p.length(); j++){
                if(p.charAt(j) == '.')  dp[i + 1][j + 1] = dp[i][j];
                else if(p.charAt(j) == '*'){
                    if(p.charAt(j - 1) == '.') dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j - 1];
                    else{
                        if(s.charAt(i) != p.charAt(j - 1))  dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        else    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j - 1];
                    }
                }
                else{
                    if(p.charAt(j) == s.charAt(i))  dp[i + 1][j + 1] = dp[i][j];
                    else    dp[i + 1][j + 1] = false;
                }
            }
        }    
        return dp[s.length()][p.length()];
    }
}

