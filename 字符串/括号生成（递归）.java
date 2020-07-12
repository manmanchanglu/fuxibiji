22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例：
输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
//思路：考虑基本的递归模板，在不考虑有效的情况下递归，然后再把有效的条件加进去就行了，条件：左括号<n才能加左括号，右括号<左括号个数才能加右括号
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