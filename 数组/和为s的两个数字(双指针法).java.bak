/*面试题57. 和为s的两个数字
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
解题思路：
利用 HashMap 可以通过遍历数组找到数字组合，时间和空间复杂度均为 O(N)；
注意本题的 nums是 排序数组 ，因此可使用 双指针法 将空间复杂度降低至 O(1)。
算法流程：
初始化： 双指针 i , j 分别指向数组 nums 的左右两端 （俗称对撞双指针）。
循环搜索：当双指针相遇时跳出；
计算和 s=nums[i]+nums[j]；
若 s>target ，则指针 j 向左移动，即执行 j=j?1 ；
若 s<target ，则指针 i 向右移动，即执行 i=i+1 ；
若 s=target ，立即返回数组 [nums[i],nums[j]] ；
返回空数组，代表无和为 target 的数字组合。

作者：jyd
链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/solution/mian-shi-ti-57-he-wei-s-de-liang-ge-shu-zi-shuang-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        if(n<2)
            return new int[0];
        if(n==2){
            if((nums[0]+nums[1])==target)
                return nums;
            else
                return new int[0];
        }
        int a=0;
        int b=n-1;
        boolean f=false;
        while(a<b){
            if(nums[a]+nums[b]>target)
                b--;
            if(nums[a]+nums[b]<target)
                a++;
            if(nums[a]+nums[b]==target){
                f=true;
                break;
            }
        }
        int[] c=new int[2];
        if(f){
            c[0]=nums[a];
            c[1]=nums[b];
            return c;
        }
        else
            return new int[0];

    }
}
