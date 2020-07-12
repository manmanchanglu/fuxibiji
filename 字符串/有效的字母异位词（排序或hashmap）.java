242. 有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
示例 1:
输入: s = "anagram", t = "nagaram"
输出: true
示例 2:
输入: s = "rat", t = "car"
输出: false

方法一：排序
算法：
通过将s的字母重新排列成t来生成变位词。因此，如果T是S的变位词，对两个字符串进行排序将产生两个相同的字符串。
此外，如果s和t的长度不同，t不能是s的变位词，我们可以提前返回。

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

复杂度分析

时间复杂度：O(nlog?n)，假设 n 是 s 的长度，排序成本 O(nlog?n) 和比较两个字符串的成本 O(n)。排序时间占主导地位，总体时间复杂度为 O(nlog?n)。
空间复杂度：O(1)，空间取决于排序实现，如果使用 heapsort，通常需要 O(1) 辅助空间。
注意，在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费 O(n) 额外的空间，但是我们忽略了这一复杂性分析，因为：

这依赖于语言的细节。
这取决于函数的设计方式。例如，可以将函数参数类型更改为 char[]。

方法二：哈希表
算法：

为了检查 t 是否是 s 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。因为S和T都只包含A?Z的字母，所以一个简单的 26 位计数器表就足够了。
我们需要两个计数器数表进行比较吗？实际上不是，因为我们可以用一个计数器表计算s字母的频率，用t减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。
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

作者：LeetCode
链接：https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

作者：LeetCode
链接：https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。