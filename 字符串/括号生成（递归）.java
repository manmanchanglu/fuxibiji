22. ��������
���� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
ʾ����
���룺n = 3
�����[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
//˼·�����ǻ����ĵݹ�ģ�壬�ڲ�������Ч������µݹ飬Ȼ���ٰ���Ч�������ӽ�ȥ�����ˣ�������������<n���ܼ������ţ�������<�����Ÿ������ܼ�������
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        xunzhao(0,0,n,"",res);
        return res;

    }
    public void xunzhao(int left,int right,int n,String s,List<String> res){
        if(left==n&&right==n){
            res.add(s);
            return;
        }
        if(left<n)
            xunzhao(left+1,right,n,s+"(",res);
        if(left>right)
            xunzhao(left,right+1,n,s+")",res);
        

    }
}