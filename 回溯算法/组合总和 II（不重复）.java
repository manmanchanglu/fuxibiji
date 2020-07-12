/*40. ����ܺ� II�����ظ���
����һ������ candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
candidates �е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�
˵����
�������֣�����Ŀ������������������
�⼯���ܰ����ظ�����ϡ� 
ʾ�� 1:
����: candidates = [10,1,2,7,6,1,5], target = 8,
����⼯Ϊ:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
ʾ�� 2:
����: candidates = [2,5,2,1,2], target = 5,
����⼯Ϊ:
[
  [1,2,2],
  [5]
]*/
import java.util.LinkedList;
import java.util.Arrays;
class Solution {
    public List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);
        comSum2(candidates,target,0,new LinkedList<Integer>());
        return result;

    }
    public void comSum2(int[] candidates, int target, int index, LinkedList<Integer> trace){
        //�����������
        if(target == 0){
            result.add(new LinkedList(trace));
            return ;
        }
        if(target > 0){
            //ѡ���б�������Լ��
            for(int i = index; i<candidates.length; i++){//�൱�ڱ���������ʼ�ڵ�
                //����Ե�ǰ���Ϊͷ����������϶������ˣ���ô��һ����������ͬ��ͷ���Ͳ���ȥ���ˡ�
                if(i > index && candidates[i] == candidates[i - 1]) continue;
                //����ѡ��
                trace.add(candidates[i]);
                comSum2(candidates,target - candidates[i],i+1,trace);//��ΪҪ���ظ����´�ֻ������һ���ڵ㿪ʼ��
                //����ѡ��
                trace.removeLast();
            }
        }
    }
}
