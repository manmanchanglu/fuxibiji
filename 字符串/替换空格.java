/*面试题05. 替换空格

请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 
示例 1：
输入：s = "We are happy."
输出："We%20are%20happy."*/
//思路：（1）只能在原基础上修改，暴力解法每遇到空格就移动后面的字符
//思路：（2）如果使用s.split(" ")切割，则同时连续出现多个空格的情况无法保证
//思路：（3）官方解法，遍历每个字符，将每个字符放到StringBuilder中，遇到空格就替换
//知识点；StringBuilder一个可变的字符序列。此类提供一个与 StringBuffer 兼容的 API，但不保证同步。
		//该类被设计用作 StringBuffer 的一个简易替换，用在字符串缓冲区被单个线程使用的时候（这种情况很普遍）。
		//如果可能，建议优先采用该类，因为在大多数实现中，它比 StringBuffer 要快。 
		//在 StringBuilder 上的主要操作是 append 和 insert 方法，可重载这些方法，以接受任意类型的数据。
		//每个方法都能有效地将给定的数据转换成字符串，然后将该字符串的字符添加或插入到字符串生成器中。
		//append 方法始终将这些字符添加到生成器的末端；而 insert 方法则在指定的点添加字符。

class Solution {
    public String replaceSpace(String s) {
         StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    

    }
}
