8. �ַ���ת������ (atoi)

�����Ŀ��ʵ�����е���ģ���Ҫ�Ƚ���ϸ�ſ���ͨ������Ȼ����������ĵ���Ҫ��Ҫʶ���ѧ��������
ʶ�������(0b01)���˽��ƣ�012)��ʮ�����ƣ�0xab������֪��leetcode�᲻��ɥ�Ĳ������������Ŀ�������Ѿ����ˣ�������
��������������������
ȥ��ǰ���ո�
���Ǵ���������
ʶ�����֣�ע��Խ�������

�����Ŀ���ֻ�Ǽ򵥵��ַ���ת�����Ļ������Ǽ򵥵� ans = ans * 10 + digit��
����ע�������Ŀ���ܻᳬ��integer������ʾ��
Ҳ����˵����ĳһ�� ans * 10 + digit > Integer.MAX_VALUE��
*10 �� +digit ���п���Խ�磬��ôֻҪ����Щ���Ƶ��ұ�ȥ�Ϳ����ˡ�
ans > (Integer.MAX_VALUE - digit) / 10 ����Խ�硣

���ߣ�sweetiee
���ӣ�https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������

public class Solution {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            // ȥ��ǰ���ո�
            idx++;
        }
        if (idx == n) {
            //ȥ��ǰ���ո��Ժ���ĩβ��
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            //��������
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // ��������
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // ��������
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // ����Ӧ���� ans * 10 + digit > Integer.MAX_VALUE
                // ���� *10 �� + digit ���п���Խ�磬���ж��ƶ����ұ�ȥ�Ϳ����ˡ�
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative? -ans : ans;
    }
}

���ߣ�sweetiee
���ӣ�https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������

//�Լ�д���д���ע���ж�Խ������
class Solution {
    public int myAtoi(String str) {
		if(str==null||str.length()==0)
			return 0;
		String a=str.trim();
		char[] ch=a.toCharArray();
		StringBuffer q=new StringBuffer();
		int v=1;
        int i=0;
        if(ch[i]=='-'){
            v=-1;
            i++;
        }
		for(int t=i;t<ch.length;t++){
			if(Character.isDigit(ch[t])){
				q.append(ch[t]);
			}
			else{
				break;
			}

		}
		if(q==null)
            return 0;
		if(Integer.valueOf(q.toString())>Integer.MAX_VALUE){//����ᱨ����������д���ο���׼��
			if(v==1)
				return Integer.MAX_VALUE;
			else
				return Integer.MIN_VALUE;
		}
		else{
			int r=Integer.valueOf(q.toString());
			if(v==1)
			return r;
		else
			return -r;

		}
		

	}
}