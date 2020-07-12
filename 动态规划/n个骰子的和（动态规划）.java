public double[] twoSum(int n) {
    //dp[i][j]代表i枚色子和为j的概率
    double[][] dp=new double[n+1][6*n+1];
    double probability=1.0/6.0;
    //base初始化
    for(int i=1;i<=6;i++) dp[1][i]=probability;
    for(int i=2;i<=n;i++){ //枚举色子
        for(int j=i;j<=i*6;j++){ //枚举点数
            for(int k=1;k<=j && k<=6;k++){ //枚举当前色子的点数
                dp[i][j]+=(probability*dp[i-1][j-k]);
            }
        }
    }
    double[] res=new double[5*n+1];//
    System.arraycopy(dp[n],n,res,0,res.length);
    return res;
}

作者：resolmi
链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/java-dong-tai-gui-hua-by-im1gw0/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
