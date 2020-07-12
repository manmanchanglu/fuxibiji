/*面试题11. 旋转数组的最小数字
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
示例 1：
输入：[3,4,5,1,2]
输出：1
示例 2：
输入：[2,2,2,0,1]
输出：0*/
/*算法流程：
循环二分： 设置 iii, jjj 指针分别指向 numbers 数组左右两端，m=(i+j)//2为每次二分的中点（ "//" 代表向下取整除法，因此恒有 i≤m<j），
可分为以下三种情况：
当 numbers[m] > numbers[j]时： mmm 一定在 左排序数组 中，即旋转点 xxx 一定在 [m+1,j][m + 1, j][m+1,j] 闭区间内，因此执行 i=m+1；
当 numbers[m] < numbers[j] 时： mmm 一定在 右排序数组 中，即旋转点 xxx 一定在[i,m][i, m][i,m] 闭区间内，因此执行 j=m；
当 numbers[m] == numbers[j] 时： 无法判断 mmm 在哪个排序数组中，即无法判断旋转点 x在[i,m]还是 [m+1,j]区间中。
解决方案：执行 j=j?1缩小判断范围 （分析见以下内容） 。
返回值： 当 i=j时跳出二分循环，并返回 numbers[i] 即可。
j=j?1 操作的正确性证明： 只需证明每次执行此操作后，旋转点x仍在 [i,j]区间内即可。
作者：jyd
链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class Solution {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
}
//剑指offer解法
class Solution {
    public int minArray(int[] numbers) {
        int n=numbers.length;
        int a=0;
        int b=n-1;
        int mid=0;
        if(numbers[a]<numbers[b])
            return numbers[a];
        while(a<b){
            if(b-a==1)
                break;
            mid=(a+b)/2;
            if(numbers[a]==numbers[b]&&numbers[mid]==numbers[a]){//当三者同时相等时二分查找失效，只能按顺序查找
                return shunXu(numbers,a,b);
            }
            if(numbers[mid]>=numbers[a]){
                a=mid;
                continue;
            }
            if(numbers[mid]<=numbers[b]){
                b=mid;
                continue;
            }
        }
        return numbers[b];

    }
    public int shunXu(int[] numbers,int a,int b){
        int result=numbers[a];
        for(int i=a+1;i<=b;i++){
            if(result>numbers[i])
                result=numbers[i];
        }
        return result;
    }
}
