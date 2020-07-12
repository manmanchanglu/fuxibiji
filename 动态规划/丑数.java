面试题49. 丑数
我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
示例:
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:  
1 是丑数。
n 不超过1690。
思路：动态规划
丑数的递推性质： 丑数只包含因子 2,3,52, 3, 52,3,5 ，因此有 “丑数 === 某较小丑数 ×\times× 某因子” （例如：10=5×2）。
设已知长度为 n的丑数序列 x1,x2,??,xn，求第 n+1个丑数 xn+1。根根据递推性质，丑数 xn+1只可能是以下三种情况其中之一
（索引 a,b,c为未知数）：
xn+1={xa×2,a∈[1,n]xb×3,b∈[1,n]xc×5,c∈[1,n]x_{n+1} =
\begin{cases}
x_{a} \times 2 & ,a \in [1, n] \\
x_{b} \times 3 & ,b \in [1, n] \\
x_{c} \times 5 & ,c \in [1, n]
\end{cases}
xn+1?=??????xa?×2xb?×3xc?×5?,a∈[1,n],b∈[1,n],c∈[1,n]?
由于 xn+1x_{n+1}xn+1? 是 最接近 xnx_nxn? 的丑数，因此索引 a,b,ca, b, ca,b,c 需满足以下条件：
{xa×2>xn≥xa?1×2，即xa为首个乘以2后大于xn的丑数xb×3>xn≥xb?1×3，即xb为首个乘以3后大于xn的丑数xc×5>xn≥xc?1×5，即xc为首个乘以5后大于xn的丑数\begin{cases}
x_{a} \times 2 > x_n \geq x_{a-1} \times 2 & ，即 x_a 为首个乘以 2 后大于 x_n 的丑数 \\
x_{b} \times 3 > x_n \geq x_{b-1} \times 3 & ，即 x_b 为首个乘以 3 后大于 x_n 的丑数 \\
x_{c} \times 5 > x_n \geq x_{c-1} \times 5 & ，即 x_c 为首个乘以 5 后大于 x_n 的丑数 \\
\end{cases}
??????xa?×2>xn?≥xa?1?×2xb?×3>xn?≥xb?1?×3xc?×5>xn?≥xc?1?×5?，即xa?为首个乘以2后大于xn?的丑数，即xb?为首个乘以3后大于xn?的丑数，即xc?为首个乘以5后大于xn?的丑数?
若索引 a,b,c满足以上条件，则可使用递推公式计算下个丑数 xn+1，其为三种情况中的最小值，即：
xn+1=min?(xa×2,xb×3,xc×5)
因此，可设置指针 a,b,c指向首个丑数（即1），循环根据递推公式得到下个丑数，并每轮将对应指针执行 +1即可。



作者：jyd
链接：https://leetcode-cn.com/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public int nthUglyNumber(int n) {
        if(n==1)
            return 1;
        if(n<1)
            return 0;
        int[] sum=new int[n];
        int a=0,b=0,c=0;
        sum[0]=1;
        for(int i=1;i<n;i++){
            sum[i]=minsmall(sum[a]*2,sum[b]*3,sum[c]*5);
            if(sum[i]==sum[a]*2)
                a++;
            if(sum[i]==sum[b]*3)
                b++;
            if(sum[i]==sum[c]*5)
                c++;

        }
        return sum[n-1];

    }
    public int minsmall(int a,int b, int c){
        int m=Math.min(a,b);
        int n=Math.min(m,c);
        return n;
    }
}