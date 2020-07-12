242. ��Ч����ĸ��λ��
���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
ʾ�� 1:
����: s = "anagram", t = "nagaram"
���: true
ʾ�� 2:
����: s = "rat", t = "car"
���: false

����һ������
�㷨��
ͨ����s����ĸ�������г�t�����ɱ�λ�ʡ���ˣ����T��S�ı�λ�ʣ��������ַ����������򽫲���������ͬ���ַ�����
���⣬���s��t�ĳ��Ȳ�ͬ��t������s�ı�λ�ʣ����ǿ�����ǰ���ء�

public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
}

���Ӷȷ���

ʱ�临�Ӷȣ�O(nlog?n)������ n �� s �ĳ��ȣ�����ɱ� O(nlog?n) �ͱȽ������ַ����ĳɱ� O(n)������ʱ��ռ������λ������ʱ�临�Ӷ�Ϊ O(nlog?n)��
�ռ临�Ӷȣ�O(1)���ռ�ȡ��������ʵ�֣����ʹ�� heapsort��ͨ����Ҫ O(1) �����ռ䡣
ע�⣬�� Java �У�toCharArray() ������һ���ַ����Ŀ��������������� O(n) ����Ŀռ䣬�������Ǻ�������һ�����Է�������Ϊ��

�����������Ե�ϸ�ڡ�
��ȡ���ں�������Ʒ�ʽ�����磬���Խ������������͸���Ϊ char[]��

����������ϣ��
�㷨��

Ϊ�˼�� t �Ƿ��� s ���������У����ǿ��Լ��������ַ�����ÿ����ĸ�ĳ��ִ��������бȽϡ���ΪS��T��ֻ����A?Z����ĸ������һ���򵥵� 26 λ����������㹻�ˡ�
������Ҫ����������������бȽ���ʵ���ϲ��ǣ���Ϊ���ǿ�����һ�������������s��ĸ��Ƶ�ʣ���t���ټ��������е�ÿ����ĸ�ļ�������Ȼ����������Ƿ�ص��㡣
class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(m!=n)
            return false;
        if(m==0&&n==0)
            return true;
        char[] a=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(a[i]))
                map.put(a[i],1);
            else{
                map.put(a[i],map.get(a[i])+1);
            }
        }
        char[] b=t.toCharArray();
        for(int i=0;i<m;i++){
            if(!map.containsKey(b[i]))
                return false;
            else{
                map.put(b[i],map.get(b[i])-1);
            }
        }
        for(char c:map.keySet()){
            if(map.get(c)!=0)
                return false;
        }
        return true;



    }
}

���ߣ�LeetCode
���ӣ�https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������

���ߣ�LeetCode
���ӣ�https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������