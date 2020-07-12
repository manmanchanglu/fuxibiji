438. �ҵ��ַ�����������ĸ��λ��
����һ���ַ��� s ��һ���ǿ��ַ��� p���ҵ� s �������� p ����ĸ��λ�ʵ��Ӵ���������Щ�Ӵ�����ʼ������
�ַ���ֻ����СдӢ����ĸ�������ַ��� s �� p �ĳ��ȶ������� 20100��
˵����
��ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
�����Ǵ������˳��
ʾ�� 1:
����:
s: "cbaebabacd" p: "abc"
���:
[0, 6]
����:
��ʼ�������� 0 ���Ӵ��� "cba", ���� "abc" ����ĸ��λ�ʡ�
��ʼ�������� 6 ���Ӵ��� "bac", ���� "abc" ����ĸ��λ�ʡ�
 ʾ�� 2:
����:
s: "abab" p: "ab"
���:
[0, 1, 2]
����:
��ʼ�������� 0 ���Ӵ��� "ab", ���� "ab" ����ĸ��λ�ʡ�
��ʼ�������� 1 ���Ӵ��� "ba", ���� "ab" ����ĸ��λ�ʡ�
��ʼ�������� 2 ���Ӵ��� "ab", ���� "ab" ����ĸ��λ�ʡ�
//�Լ�д�İ汾�����ǳ�ʱ�ˣ���Щ�����ⷨ
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m=s.length();
        int n=p.length();
        List<Integer> list=new ArrayList();
        if(m<n)
            return list;
        for(int i=0;i<=m-n;i++){
            if(panduan(s,p,i,n))
                list.add(i);
        }
        return list;

    }
    public boolean panduan(String s,String p,int i,int n){
        char[] ch=s.substring(i,i+n).toCharArray();
        Arrays.sort(ch);
        char[] bh=p.toCharArray();
        Arrays.sort(bh);
        for(int e=0;e<bh.length;e++){
            if(bh[e]!=ch[e])
                return false;
        }
        return true;
    }
}




�����ǵ��͵Ĵ��ڻ���+��������ָ����㷨


һ��ʼ�����Ƚ��ַ���ת��Ϊ�ַ����飬����һ��ans�����ս��


����ʹ������������needs��window���ֱ��¼��Ҫ�õ���Ԫ�غͻ������ڱ�������Ԫ��


���Ȱ�Ŀ������arrP���е�Ԫ�ض�����needs�У�Ȼ��ͨ�������ƶ��������ڽ�Ŀ��Ԫ�صĸ������浽window��


���window�����м�¼��Ԫ�ظ���������needs�����Ԫ�ظ�������ʼ�ƶ��󴰿��������ٶ���ĸ���


���������������������з���Ҫ����󴰿������ŵ�ans�в����ؼ��ɡ�

���ߣ�jasion_han-r
���ӣ�https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/20200321438median-by-jasion_han-r/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // ���ڷ�����ĸ��λ�ʵ���ʼ����
        List<Integer> res = new ArrayList<>();
        // �� map �洢Ŀ��ֵ�и������ʳ��ֵĴ���
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : p.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        // ������һ�� map �洢������������Ч�ַ����ֵĴ���
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0; // ��ָ��
        int right = 0; // ��ָ��
        int valid = p.length(); // ֻ�е� valid == 0 ʱ����˵�� window �а�����Ŀ���Ӵ�
        while (right < s.length()) {
            // ���Ŀ���Ӵ��а����˸��ַ����Ŵ��� window ��
            if (map.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                // ֻ�е� window �и���Ч�ַ�����������map�и��ַ�������������һ����Ч����
                if (window.get(s.charAt(right)) <= map.get(s.charAt(right))) {
                    valid--;
                }
            }
            // ��� window ����Ҫ�󣬼����� map �洢����Ч�ַ���ͬ���Ϳ����ƶ���ָ����
            // ����ֻ�ж���map�洢��������ȫ��ͬ���ſ��Լ�¼��ǰ����ʼ������Ҳ����leftָ������λ��
            while (valid == 0) {
                if (right - left + 1 == p.length()) res.add(left);
                // �����ָ��ָ������Ч�ַ�,��Ҫ���� window �е� key ��Ӧ�� value
                // ��� ��Ч�ַ���Ӧ��������Ŀ���Ӵ��٣�˵���޷�ƥ����
                if (map.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                    if (window.get(s.charAt(left)) < map.get(s.charAt(left))) {
                        valid++;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }
}