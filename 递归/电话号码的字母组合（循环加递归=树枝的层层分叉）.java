17. �绰�������ĸ���

����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
�������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��

ʾ��:
���룺"23"
�����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
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
        for(int i=0;i<letters.length();i++){//���ѡ�������ѭ���ӵݹ�=��֦�ֲ��˼����ͬ
            pailie(s+letters.charAt(i),digits,n+1,res);
        }
    }
}