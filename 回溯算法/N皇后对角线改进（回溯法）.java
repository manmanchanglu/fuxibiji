/*������ 08.12. �˻ʺ�
���һ���㷨����ӡ N �ʺ��� N �� N �����ϵĸ��ְڷ�������ÿ���ʺ󶼲�ͬ�С���ͬ�У�Ҳ���ڶԽ����ϡ�
����ġ��Խ��ߡ�ָ�������еĶԽ��ߣ���ֻ��ƽ���������̵��������Խ��ߡ�
ע�⣺�������ԭ��������չ
ʾ��:
 ���룺4
 �����[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 ����: 4 �ʺ������������������ͬ�Ľⷨ��
[
 [".Q..",  // �ⷨ 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // �ⷨ 2
  "Q...",
  "...Q",
  ".Q.."]
]*/

class Solution {
    private List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        char[][] queen = new char[n][n];
        for (int i = 0; i < n; i++) { //��'.'���
            Arrays.fill(queen[i], '.');
        }
        backtrack(queen, 0, n);
        return result;
    }

    private void backtrack(char[][] queen, int i, int n) {
        if (i == n) { //i = n��ƥ�����������һ�ֽ��
            List<String> item = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                item.add(String.valueOf(queen[k]));
            }
            result.add(item);
            return;
        }//���������ȳ䵱��ѡ���б�Ҳ�䵱��·��
        for (int j = 0; j < n; j++) {
            if (!judge(queen, i, j)) continue; //�ж��ڡ�i,j����һ��'Q'�Ƿ������������j++
            queen[i][j] = 'Q';
            backtrack(queen, i + 1, n); //ÿһ��ֻ�ܷ�һ��'Q'������һ��
            queen[i][j] = '.'; //���ݣ���ԭ��i,j����j++��һ��
        }
    }
    
    private boolean judge(char[][] queen, int i, int j) { 
        for (int k = 0; k < i; k++) { //��һ��
            if (queen[k][j] == 'Q') return false;
        }
        for (int k = i - 1, z = j - 1; k >= 0 && z >= 0; k--, z--) { //��i,j�� �� ���Ͻ�
            if (queen[k][z] == 'Q') return false;
        }
        for (int k = i - 1, z = j + 1; k >= 0 && z < queen.length; k--, z++) { //��i,j�� �� ���Ͻ�
            if (queen[k][z] == 'Q') return false;
        }
        return true;
    }

}



//�Լ�д�İ汾�����ⲻ֪����������
class Solution {
    List<List<String>> res;   
    public List<List<String>> solveNQueens(int n) {
        char[][] nums=new char[n][n];
        res=new ArrayList<>();
        for(int i=0;i<n;i++){
            Arrays.fill(nums[i], '.');
        }
        xunzhao(nums,n,0);
        return res;
    }
    public void xunzhao(char[][] nums,int n,int i){
        if(i==n){
            List<String> list=new ArrayList<>();
            for(int a=0;a<n;a++){
                list.add(String.valueOf(nums[a]));
            }
            res.add(list);
            return;
        }     
        for(int j=0;j<n;j++){
            if(��panduan(i,j,nums,n)){continue;}
            nums[i][j]='Q';
            xunzhao(nums,n,i+1);
            nums[i][j]='.';            
        }

    }
    public boolean panduan(int i,int j,char[][]nums,int n){       
        for(int s=0;s<i;s++){//�ж���
            if(nums[s][j]=='Q');
            return false;
        }
        int z=i-1;
        int v=j+1;
        while(z>=0&&v<n){//�ж����϶Խ���
            if(nums[z][v]=='Q'){
                return false;
            }
            else{
                z--;
                v++;
          }  
        }
        int c=i-1;
        int x=j-1;
        while(c>=0&&x>=0){//�ж����϶Խ���
            if(nums[c][x]=='Q'){
                return false;
            }
            else{
                c--;
                x--;
            }
        }      
        return true;
    }
}