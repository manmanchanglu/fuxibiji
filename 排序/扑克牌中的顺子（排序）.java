面试题61. 扑克牌中的顺子
从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
示例 1:
输入: [1,2,3,4,5]
输出: True
示例 2:
输入: [0,0,1,2,5]
输出: True
思路：首先把数组排序，再统计数组中0的个数，最后统计排序之后的数组中相邻数字之间的空间总数，如果空缺的总数小于或者等于0的个数，那么连续
还要注意数组中非零数字重复，则不是顺子。
class Solution {
    public boolean isStraight(int[] nums) {
        int[] nums1=sort(nums);
        int a=0;
        int b=0;
        for(int i=0;i<5;i++){
            if(nums1[i]==0)
                a++;
        }
        for(int i=a;i<4;i++){
                int j=i+1;
                int q=nums1[j]-nums1[i];
                if(q==0)
                    return false;
                if(q==1)
                    continue;
                if(q>1){
                    b+=q-1;
                }
            
        }
        if(b<=a)
            return true;
        else
            return false;

    }
    public int[] sort(int[] sums){

        for(int i=0;i<4;i++){
            int a=i;
            for(int j=i+1;j<5;j++){
                if(sums[j]<sums[a]){
                    a=j;
                }

            }
            int m=sums[i];
            sums[i]=sums[a];
            sums[a]=m;
        }
        return sums;
    }
}