/*面试题 08.12. 八皇后
设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。
这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
注意：本题相对原题做了扩展
示例:
 输入：4
 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]*/

class Solution {
    private List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        char[][] queen = new char[n][n];
        for (int i = 0; i < n; i++) { //用'.'填充
            Arrays.fill(queen[i], '.');
        }
        backtrack(queen, 0, n);
        return result;
    }

    private void backtrack(char[][] queen, int i, int n) {
        if (i == n) { //i = n，匹配结束，这是一种结果
            List<String> item = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                item.add(String.valueOf(queen[k]));
            }
            result.add(item);
            return;
        }//这里的数组既充当了选择列表也充当了路径
        for (int j = 0; j < n; j++) {
            if (!judge(queen, i, j)) continue; //判断在【i,j】放一个'Q'是否合理，不合理，则j++
            queen[i][j] = 'Q';
            backtrack(queen, i + 1, n); //每一行只能放一个'Q'，换下一行
            queen[i][j] = '.'; //回溯，还原【i,j】，j++试一试
        }
    }
    
    private boolean judge(char[][] queen, int i, int j) { 
        for (int k = 0; k < i; k++) { //这一竖
            if (queen[k][j] == 'Q') return false;
        }
        for (int k = i - 1, z = j - 1; k >= 0 && z >= 0; k--, z--) { //【i,j】 到 左上角
            if (queen[k][z] == 'Q') return false;
        }
        for (int k = i - 1, z = j + 1; k >= 0 && z < queen.length; k--, z++) { //【i,j】 到 右上角
            if (queen[k][z] == 'Q') return false;
        }
        return true;
    }

}



//自己写的版本有问题不知道出在哪了
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
            if(！panduan(i,j,nums,n)){continue;}
            nums[i][j]='Q';
            xunzhao(nums,n,i+1);
            nums[i][j]='.';            
        }

    }
    public boolean panduan(int i,int j,char[][]nums,int n){       
        for(int s=0;s<i;s++){//判断列
            if(nums[s][j]=='Q');
            return false;
        }
        int z=i-1;
        int v=j+1;
        while(z>=0&&v<n){//判断右上对角线
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
        while(c>=0&&x>=0){//判断左上对角线
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