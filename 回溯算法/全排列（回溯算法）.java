46. ȫ����
����һ�� û���ظ� ���ֵ����У����������п��ܵ�ȫ���С�
class Solution {
    List<List<Integer>> res=new LinkedList<>();//�����洢ȫ�������
    public List<List<Integer>> permute(int[] nums) {
        
        LinkedList<Integer> track=new LinkedList<>();//�����洢·��
        int n=nums.length;
        biaojao(track,nums);
        return res;
     
    }
    public void biaojao(LinkedList<Integer> track,int[] nums){
        if(track.size()==nums.length){
            res.add(new LinkedList(track));
            return;
        }
        for(int i=0;i<nums.length;i++){//·����ѡ��
            if(track.contains(nums[i]))//�ų������ϵ�ѡ��
                continue;
            track.add(nums[i]);//��ѡ��
            biaojao(track,nums);//�ݹ�
            track.removeLast();//����ѡ��
        }
    }
}