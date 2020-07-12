/*322. ��Ǯ�һ�
������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ����� -1�� 
ʾ�� 1:
����: coins = [1, 2, 5], amount = 11
���: 3 
����: 11 = 5 + 5 + 1
ʾ�� 2:
����: coins = [2], amount = 3
���: -1

����������̬�滮-���϶��� [ͨ��]
�����ܸĽ������ָ��ʱ�临�ӶȵĽ��𣿵�Ȼ���ԣ����ö�̬�滮�����ǿ����ڶ���ʽ��ʱ�䷶Χ����⡣���ȣ����Ƕ��壺
F(S)����ɽ�� S���������Ӳ������
[c0��cn?1]0����ѡ�� nöӲ�����ֵ
����ע�⵽���������һ�����ŵ��ӽṹ���ʣ����ǽ����̬�滮����Ĺؼ������Ž���Դ�������������Ž⹹�������
��ν�����ֽ�������⣿��������֪�� F(S)F(S)F(S) ������ɽ�� SSS ���ٵ�Ӳ���������һöӲ�ҵ���ֵ�� C����ô��������������ӽṹ��ת�Ʒ���ӦΪ��
F(S)=F(S?C)+1
�����ǲ�֪�����һöӲ�ҵ���ֵ�Ƕ��٣�����������Ҫö��ÿ��Ӳ�����ֵ c0,c1,c2��cn?1��ѡ�����е���Сֵ�����е��ƹ�ϵ������
F(S)=(min?i=0...n?1)[F(S?ci)]+1 
F(S)=0 ,when S=0
F(S)=?1 ,when n=0

���ߣ�LeetCode-Solution
���ӣ�https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������*/


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1)
            return 0;
        return xunzhao(coins,amount,new int[amount]);

    }
    public int xunzhao(int[] coins,int amount ,int[] cunchu){//�ÿռ任ʱ��
        if(amount<0)
            return -1;
        if(amount==0)
            return 0;
        if(cunchu[amount-1]!=0)//��֦�������ظ�����
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