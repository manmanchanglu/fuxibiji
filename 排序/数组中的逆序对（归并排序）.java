面试题51. 数组中的逆序对
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
示例 1:
输入: [7,5,6,4]
输出: 5
分治思想（借助归并排序统计逆序数）
说明：理解这个算法需要对「归并排序」比较熟悉。掌握如果编写递归函数，每一次都一分为二拆分数组的子区间，然后在方法栈弹出的时候，一步一步合并两个有序数组，最后完成排序工作。
而计算逆序数就发生在排序的过程中，利用了「排序」以后数组的有序性。
利用「归并排序」计算逆序对，是非常经典的做法；
关键在于「合并两个有序数组」的步骤，利用数组的部分有序性，一下子计算出一个数之前或者之后元素的逆序的个数；
前面「分」的时候什么都不做，「合」的过程中计算「逆序对」的个数；
「排序」的工作是必要的，正是因为「排序」才能在下一轮利用顺序关系加快逆序数的计算，也能避免重复计算；
在代码实现上，只需要在「归并排序」代码的基础上，加上「逆序对」个数的计算，计算公式需要自己在草稿纸上推导。
思想是「分治算法」，所有的「逆序对」来源于 3 个部分：
左边区间的逆序对；
右边区间的逆序对；
横跨两个区间的逆序对。
下面提供两种写法：
1、在第 2 个子区间元素归并回去的时候，计算逆序对的个数（参考代码 2）；
2、在第 1 个子区间元素归并回去的时候，计算逆序对的个数（参考代码 3）。
注意：两者不能同时计算，否则会计算重复。
作者：liweiwei1419
链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/bao-li-jie-fa-fen-zhi-si-xiang-shu-zhuang-shu-zu-b/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//在归并排序并的过程中进行逆序对的计算
class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        if(n<2)
            return 0;
        int[] temp=new int[n];
        int a=mergeSort(nums,0,n-1,temp);
        return a;

    }
    public int mergeSort(int[] nums,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;
            int left1=mergeSort(nums,left,mid,temp);
            int right1=mergeSort(nums,mid+1,right,temp);
            //if(nums[mid]<nums[mid+1]);
                //return left1+right1;
            int m=merge(nums,left,mid,right,temp);
            return left1+right1+m;
        }
        return 0;
    }
    public int merge(int[] nums,int left,int mid, int right,int[] temp){
        int i=left;
        int j=mid+1;
        int t=0;
        int count=0;
        while(i<=mid&&j<=right){
            if(nums[i]<=nums[j]){
                temp[t]=nums[i];
                t+=1;
                i+=1;
            }
            else{
                temp[t]=nums[j];
                t+=1;
                j+=1;
                count+=mid-i+1;
            }
        }
        while(i<=mid){
            temp[t]=nums[i];
            t+=1;
            i+=1;
        }
        while(j<=right){
            temp[t]=nums[j];
            t+=1;
            j+=1;
            count+=mid-i+1;
        }
        t=0;
        int tempLeft=left;
        while(tempLeft<=right){
            nums[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }
        return count;
    }
}