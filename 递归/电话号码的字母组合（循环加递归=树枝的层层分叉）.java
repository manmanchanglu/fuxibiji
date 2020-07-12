17. 电话号码的字母组合

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
class Solution {
    Map<Character,String> map;
   
    public List<String> letterCombinations(String digits) {
        map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> res=new ArrayList<>();
        if(digits.length()==0)
            return res;
        pailie("",digits,0,res);
        return res;
    }
    public void pailie(String s,String digits,int n,List<String> res){
        if(n==digits.length()){
            res.add(s);
            return;
        }
        String letters=map.get(digits.charAt(n));
        for(int i=0;i<letters.length();i++){//层层选择遍历，循环加递归=树枝分叉的思想相同
            pailie(s+letters.charAt(i),digits,n+1,res);
        }
    }
}