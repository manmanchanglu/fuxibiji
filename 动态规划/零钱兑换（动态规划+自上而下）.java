/*322. 零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。 
示例 1:
输入: coins = [1, 2, 5], amount = 11
输出: 3 
解释: 11 = 5 + 5 + 1
示例 2:
输入: coins = [2], amount = 3
输出: -1

方法二、动态规划-自上而下 [通过]
我们能改进上面的指数时间复杂度的解吗？当然可以，利用动态规划，我们可以在多项式的时间范围内求解。首先，我们定义：
F(S)：组成金额 S所需的最少硬币数量
[c0…cn?1]0：可选的 n枚硬币面额值
我们注意到这个问题有一个最优的子结构性质，这是解决动态规划问题的关键。最优解可以从其子问题的最优解构造出来。
如何将问题分解成子问题？假设我们知道 F(S)F(S)F(S) ，即组成金额 SSS 最少的硬币数，最后一枚硬币的面值是 C。那么由于问题的最优子结构，转移方程应为：
F(S)=F(S?C)+1
但我们不知道最后一枚硬币的面值是多少，所以我们需要枚举每个硬币面额值 c0,c1,c2…cn?1并选择其中的最小值。下列递推关系成立：
F(S)=(min?i=0...n?1)[F(S?ci)]+1 
F(S)=0 ,when S=0
F(S)=?1 ,when n=0

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1)
            return 0;
        return xunzhao(coins,amount,new int[amount]);

    }
    public int xunzhao(int[] coins,int amount ,int[] cunchu){//用空间换时间
        if(amount<0)
            return -1;
        if(amount==0)
            return 0;
        if(cunchu[amount-1]!=0)//剪枝，避免重复计算
            return cunchu[amount-1];
        int min=Integer.MAX_VALUE;
        for(int coin:coins){
            int res=xunzhao(coins,amount-coin,cunchu);
            if(res>=0&&res<min)
                min=res+1;
        }
        cunchu[amount-1]=(min==Integer.MAX_VALUE) ? -1 : min;
        return cunchu[amount-1];
    }
}