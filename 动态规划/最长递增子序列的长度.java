673. ����������еĸ���

����һ��δ������������飬�ҵ�����������еĸ�����
ʾ�� 1:
����: [1,3,5,4,7]
���: 2
����: ����������������У��ֱ��� [1, 3, 4, 7] ��[1, 3, 5, 7]��
ʾ�� 2:
����: [2,2,2,2,2]
���: 5
����: ����������еĳ�����1�����Ҵ���5�������еĳ���Ϊ1��������5��
//�������������������еĳ���
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res=0;
        for(int i=0;i<dp.length;i++)
            res=Math.max(res,dp[i]);
        return res;

    }
}