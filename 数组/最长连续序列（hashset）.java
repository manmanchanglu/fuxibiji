/*128. 最长连续序列
给定一个未排序的整数数组，找出最长连续序列的长度。
要求算法的时间复杂度为 O(n)。
示例:
输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

思路：
首先想一下最直接的暴力破解。我们可以用一个 HashSet 把给的数组保存起来。然后再考虑数组的每个数，比如这个数是 n
，然后看 n + 1 在不在 HashSet 中，然后再看 n + 2 在不在，接下来 n + 3、n + 4 直到在 HashSet 中找不到，记录当前的长度。
然后继续考虑下一个数，并且更新最长的长度
换句话讲，我们只考虑从序列最小的数开始即可。实现的话，当考虑 n 的时候，我们先看一看 n - 1 是否存在，如果不存在，
那么从 n 开始就是我们需要考虑的序列了。否则的话，直接跳过。

作者：windliang
链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
作者：windliang
链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0)
            return 0;
        HashSet<Integer> set=new HashSet<>();//用于数组的去重
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int max1=1;
        for(int m:nums){
            if(!set.contains(m-1)){//防止回溯已经遍历过的长度
                int current=1;
                int qwer=m;
                while(set.contains(qwer+1)){
                    qwer+=1;
                    current+=1;
                }
                max1=Math.max(max1,current);
            }
        }
        return max1;
    }
}