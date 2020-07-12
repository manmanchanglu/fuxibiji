1143. 最长公共子序列
给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
若这两个字符串没有公共子序列，则返回 0。
 
示例 1:
输入：text1 = "abcde", text2 = "ace" 
输出：3  
解释：最长公共子序列是 "ace"，它的长度为 3。
示例 2:
输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc"，它的长度为 3。
示例 3:
输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0。



在讲解动态规划之前，我们就以字符串s1="people"，s2="eplm"为例画个图来找一下他的递推公式。

我们通过上面的图分析发现，子序列不一定都是连续的，只要前面有相同的子序列，哪怕当前比较的字符不一样，
那么当前字符串之前的子序列也不会为0。换句话说，如果当前字符不一样，我们只需要把第一个字符串往前退一个字符或者第二个字符串往前退一个字符然后记录最大值即可。
举个例子，比如图中第4行第4列（就是图中灰色部分），p和m不相等，如果字符串"eplm"退一步是"epl"再和"epop"对比
我们发现有2个相同的子序列（也就是上面表格中数组（2，3）的位置）。如果字符串"peop"退一步是"peo"再和"eplm"对比
我们发现只有1个相同的子序列（这里的pe和ep只能有一个相同，要么p相同，要么e相同，因为子序列的顺序不能变）（也就是上面表格中数组（3，2）的位置）。
所以我们很容易找出递推公式

作者：sdwwld
链接：https://leetcode-cn.com/problems/longest-common-subsequence/solution/java-dong-tai-gui-hua-tu-wen-jie-xi-by-sdwwld/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public int  longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int length1 = t1.length;
        int length2 = t2.length;
        int[][] dp = new int[length1+1][length2+1];
        for (int i = 1; i < length1 +1; i++) {
            for (int j = 1; j < length2 +1; j++) {
                if (t1[i-1] == t2[j-1]){
                    // 这边找到一个 lcs 的元素，继续往前找
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else {
                    //谁能让 lcs 最长，就听谁的
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[length1][length2];
    }
}