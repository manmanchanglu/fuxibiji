15. ����֮��

����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��ʹ�� a + b + c = 0 �������ҳ��������������Ҳ��ظ�����Ԫ�顣
ע�⣺���в����԰����ظ�����Ԫ�顣
 
ʾ����
�������� nums = [-1, 0, 1, 2, -1, -4]��

����Ҫ�����Ԫ�鼯��Ϊ��
[
  [-1, 0, 1],
  [-1, -1, 2]
]

���ⷽ��
˼·

��ǩ���������
���ȶ�����������������̶�һ���� nums[i]����ʹ������ָ��ָ�� nums[i]��������ˣ����ֱַ�Ϊ nums[L] �� nums[R]��
�����������ĺ� sum �ж��Ƿ�����Ϊ 0����������ӽ������
��� nums[i]���� 0��������֮�ͱ�Ȼ�޷����� 0������ѭ��
��� nums[i] == nums[i?1]����˵���������ظ����ᵼ�½���ظ�������Ӧ������
�� sum == 0 ʱ��nums[L] == nums[L+1] ��ᵼ�½���ظ���Ӧ��������L++
�� sum == 0 ʱ��nums[R] == nums[R?1] ��ᵼ�½���ظ���Ӧ��������R??
ʱ�临�Ӷȣ�O(n^2)��n Ϊ���鳤��

���ߣ�guanpengchn
���ӣ�https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // ����
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // �����ǰ���ִ���0��������֮��һ������0�����Խ���ѭ��
            if(i > 0 && nums[i] == nums[i-1]) continue; // ȥ��
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // ȥ��
                    while (L<R && nums[R] == nums[R-1]) R--; // ȥ��
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }        
        return ans;
    }
}

���ߣ�guanpengchn
���ӣ�https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������