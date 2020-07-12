面试题42. 连续子数组的最大和
输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。
示例1:
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
动态规划是本题的最优解法，以下按照标准流程解题。
 动态规划解析：
状态定义：设动态规划列表 dp ，dp[i]代表以元素 nums[i] 为结尾的连续子数组最大和。
为何定义最大和 dp[i]中必须包含元素 nums[i]：保证 dp[i]递推到 dp[i+1]的正确性；如果不包含 nums[i]，递推时则不满足题目的连续子数组要求。
转移方程： 若 dp[i?1]≤0 ，说明 dp[i?1]对 dp[i]产生负贡献，即 dp[i?1]+nums[i]还不如 nums[i]本身大。
当 dp[i?1]>0时：执行 dp[i]=dp[i?1]+nums[i]；
当 dp[i?1]≤0时：执行 dp[i]=nums[i]；
初始状态： dp[0]=nums[0]，即以 nums[0]结尾的连续子数组最大和为 nums[0]。
返回值： 返回 dp列表中的最大值，代表全局最大值。
作者：jyd
链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/mian-shi-ti-42-lian-xu-zi-shu-zu-de-zui-da-he-do-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
//自己写的，
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        if(n==0)
            return 0;
        if(n==1)
            return nums[0];
        int a=0;
        int sum=0;//求和运算
        int max=nums[0];//用来记录最大值
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            if(sum<nums[i]){//小于，说明前i-1不如i大
                a=i;
                if(max<nums[i])
                    max=nums[i];
                sum=nums[i];
            }
            if(sum>max)
                max=sum;

        }
        return max;

    }
}