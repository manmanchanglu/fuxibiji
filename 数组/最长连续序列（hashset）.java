/*128. ���������
����һ��δ������������飬�ҳ���������еĳ��ȡ�
Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(n)��
ʾ��:
����: [100, 4, 200, 1, 3, 2]
���: 4
����: ����������� [1, 2, 3, 4]�����ĳ���Ϊ 4��

˼·��
������һ����ֱ�ӵı����ƽ⡣���ǿ�����һ�� HashSet �Ѹ������鱣��������Ȼ���ٿ��������ÿ����������������� n
��Ȼ�� n + 1 �ڲ��� HashSet �У�Ȼ���ٿ� n + 2 �ڲ��ڣ������� n + 3��n + 4 ֱ���� HashSet ���Ҳ�������¼��ǰ�ĳ��ȡ�
Ȼ�����������һ���������Ҹ�����ĳ���
���仰��������ֻ���Ǵ�������С������ʼ���ɡ�ʵ�ֵĻ��������� n ��ʱ�������ȿ�һ�� n - 1 �Ƿ���ڣ���������ڣ�
��ô�� n ��ʼ����������Ҫ���ǵ������ˡ�����Ļ���ֱ��������

���ߣ�windliang
���ӣ�https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-4/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
���ߣ�windliang
���ӣ�https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-4/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������*/
class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0)
            return 0;
        HashSet<Integer> set=new HashSet<>();//���������ȥ��
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int max1=1;
        for(int m:nums){
            if(!set.contains(m-1)){//��ֹ�����Ѿ��������ĳ���
                int current=1;
                int qwer=m;
                while(set.contains(qwer+1)){
                    qwer+=1;
                    current+=1;
                }
                max1=Math.max(max1,current);
            }
        }
        return max1;
    }
}