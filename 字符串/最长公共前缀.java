14. �����ǰ׺
��дһ�������������ַ��������е������ǰ׺��
��������ڹ���ǰ׺�����ؿ��ַ��� ""��
ʾ�� 1:
����: ["flower","flow","flight"]
���: "fl"
ʾ�� 2:
����: ["dog","racecar","car"]
���: ""
����: ���벻���ڹ���ǰ׺��

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs==null)
            return "";
        if(strs.length==1)
            return strs[0];
        int n=strs.length;
        for(int i=0;i<strs[0].length();i++){
            for(int j=1;j<n;j++){
                if(i==strs[j].length()||strs[0].charAt(i)!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}