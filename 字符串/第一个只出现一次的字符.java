/*面试题50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
示例:
s = "abaccdeff"
返回 "b"
s = "" 
返回 ' '
本题考察 哈希表 的使用，本文介绍 “哈希表” 和 “有序哈希表” 两种解法。
其中，在字符串很长时， “有序哈希表” 解法理论上效率更高。
方法一：哈希表
遍历字符串 s ，使用哈希表统计 “各字符数量是否 >1 ”。
再遍历字符串 s ，在哈希表中找到首个 “数量为 1的字符”，并返回
作者：jyd
链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/mian-shi-ti-50-di-yi-ge-zhi-chu-xian-yi-ci-de-zi-3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }
}

//自己写的代码，但没有官方的简洁
class Solution {
    public char firstUniqChar(String s) {
        if(s=="")
            return ' ';
        char[] c=s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        int n=c.length;
        for(int i=0;i<n;i++){
            if(!map.containsKey(c[i]))
                map.put(c[i],1);
            else{
                map.put(c[i],map.get(c[i])+1);
            }
        }
        if(!map.containsValue(1))
            return ' ';
        else{
            for(int i=0;i<n;i++){
                if(map.get(c[i])==1){
                    return c[i];
                }

            }
        }
        return ' ';


    }
}