/*面试题21. 调整数组顺序使奇数位于偶数前面（双指针，清晰图解）
解题思路：
考虑定义双指针 i, j分列数组左右两端，循环执行：
指针 i 从左向右寻找偶数；
指针 j 从右向左寻找奇数；
将 偶数 nums[i]和 奇数 nums[j]交换。
可始终保证：指针 i左边都是奇数，指针j右边都是偶数 。
作者：jyd
链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/solution/mian-shi-ti-21-diao-zheng-shu-zu-shun-xu-shi-qi-4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
算法流程：
初始化： i, j双指针，分别指向数组 nums左右两端；
循环交换： 当 i=j时跳出；
指针 i 遇到奇数则执行 i=i+1 跳过，直到找到偶数；
指针 j 遇到偶数则执行 j=j?1跳过，直到找到奇数；
交换 nums[i]和 nums[j]值；
返回值： 返回已修改的 nums数组*/
class Solution {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && (nums[i] & 1) == 1) i++;
            while(i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}

//自己写的版本
class Solution {
    public int[] exchange(int[] nums) {
        int n=nums.length;
        int b=n-1;
        for(int a=0;a<n;a++){
            if(nums[a]%2==0&&a<b){
                if(nums[b]%2!=0){
                    int m=nums[a];
                    nums[a]=nums[b];
                    nums[b]=m;
                    b--;
                    continue;
                }
                
                b=b-1;
                while(a!=b&&a<b){
                    if(nums[b]%2!=0){
                        int q=nums[a];
                        nums[a]=nums[b];
                        nums[b]=q;
                        b--;
                        break;
                        
                    }
                    b--;
                }
                
            }
            if(a==b)
                break;
        }
        return nums;

    }
}

