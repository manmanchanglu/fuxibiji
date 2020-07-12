面试题58 - I. 翻转单词顺序
输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
示例 1：
输入: "the sky is blue"
输出: "blue is sky the"
示例 2：
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
方法一：双指针
算法解析：
倒序遍历字符串 s ，记录单词左右索引边界 i , j ；
每确定一个单词的边界，则将其添加至单词列表 res ；
最终，将单词列表拼接为字符串，并返回即可。
复杂度分析：
时间复杂度 O(N) ： 其中 N 为字符串 s 的长度，线性遍历字符串。
空间复杂度 O(N) ： 新建的 list(Python) 或 StringBuilder(Java) 中的字符串总长度 ≤N ，占用 O(N) 大小的额外空间。
作者：jyd
链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/solution/mian-shi-ti-58-i-fan-zhuan-dan-ci-shun-xu-shuang-z/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }
}

//自己写的用栈实现的，先进后出
class Solution {
    public String reverseWords(String s) {
        String[] m=s.split(" ");
        Stack<String> stack=new Stack<>();
        for(int i=0;i<m.length;i++){
            if(!m[i].equals(""))
                stack.push(m[i]);
        }
        //String a=stack.pop();
        StringBuffer sb=new StringBuffer();
        while(!stack.empty()){
            sb.append(stack.pop());
            sb.append(" ");
        }
            
        return sb.toString().trim();

    }
}