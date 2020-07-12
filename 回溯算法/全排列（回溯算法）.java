46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
class Solution {
    List<List<Integer>> res=new LinkedList<>();//用来存储全部结果集
    public List<List<Integer>> permute(int[] nums) {
        
        LinkedList<Integer> track=new LinkedList<>();//用来存储路径
        int n=nums.length;
        biaojao(track,nums);
        return res;
     
    }
    public void biaojao(LinkedList<Integer> track,int[] nums){
        if(track.size()==nums.length){
            res.add(new LinkedList(track));
            return;
        }
        for(int i=0;i<nums.length;i++){//路径：选择
            if(track.contains(nums[i]))//排除不符合的选择
                continue;
            track.add(nums[i]);//做选择
            biaojao(track,nums);//递归
            track.removeLast();//撤销选择
        }
    }
}