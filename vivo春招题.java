在vivo产线上，每位职工随着对手机加工流程认识的熟悉和经验的增加，日产量也会不断攀升。 
假设第一天量产1台，接下来2天(即第二、三天)每天量产2件，接下来3天(即第四、五、六天)每天量产3件 ... ...  
以此类推，请编程计算出第n天总共可以量产的手机数量。
class Solution {
public:
    /**
     *
     * @param n int整型 第n天
     * @return int整型
     */
    int solution(int n) {
        // write code here
        int ans = 0;
        for(int i=1; n>0; ++i){
            ans += i * min(i, n);
            n -= i;
        }
        return ans;
    }
};

现给定任意正整数 n，请寻找并输出最小的正整数 m（m>9），使得 m 的各位（个位、十位、百位 ... ...）之乘积等于n，若不存在则输出 -1。
//对于小于10的数n，输出1n。
//对于大于10的数，需要分解为若干个个位数之积，数字的个数尽可能少。这个数字可以分解为以9，8，...，2的因子之积。然后从小到大输出即可。
class Solution {
public:
    /**
     * 输入一个整形数值，返回一个整形值
     * @param n int整型 n>9
     * @return int整型
     */
    int solution(int n) {
        // write code here
        if (n < 10) return 10 + n;
        int res = 0, base = 1;
        for (int i = 9; i > 1; i--) {
            while (n % i == 0) {
                res += i * base;
                base*=10;
                n /= i;
            }
        }
        if (n > 1) return -1;
        else return res;
    }
};


链接：https://www.nowcoder.com/questionTerminal/c552248efdbd41a18d35b7a2329f7ad8
来源：牛客网

链接：https://www.nowcoder.com/questionTerminal/c552248efdbd41a18d35b7a2329f7ad8
来源：牛客网

现有一个 3x3 规格的 Android 智能手机锁屏程序和两个正整数 m 和 n ，请计算出使用最少m 个键和最多 n个键可以解锁该屏幕的所有有效模式总数。     
其中有效模式是指：     
1、每个模式必须连接至少m个键和最多n个键；     
2、所有的键都必须是不同的；     
3、如果在模式中连接两个连续键的行通过任何其他键，则其他键必须在模式中选择，不允许跳过非选择键（如图）；     
4、顺序相关，单键有效（这里可能跟部分手机不同）。             
输入：m,n        代表允许解锁的最少m个键和最多n个键 
输出：       满足m和n个键数的所有有效模式的总数 

public static int solution (int m, int n) {
	//         递归实现         
	int count = 0;         
	n = n>9 ? 9 : n;         
	for(int i=m;i<=n;i++) {             
		boolean[][] flags = new boolean[3][3];             
		for(int j=0;j<3;j++) {                 
			for(int t=0;t<3;t++) {                     
				count += findNext(flags, j, t, 0, i);                 
			}             
		}         
	}         
	return count;     
}


public static int findNext(boolean[][] flags,int curRow, int curCol, int steps, int n) {         
	int count = 0;         
	steps ++;         
	flags[curRow][curCol] = true;
	//         步数走完返回         
	if(steps == n)             
		return 1;
	//         如果可以走，那么返回 1         
	for(int i=0;i<3;i++) {             
		for(int j=0;j<3;j++) {                 
			if(flags[i][j] == false && canStep(flags, curRow, curCol, i, j)) {                     
				count += findNext(flags, i, j, steps, n);
				//                     恢复状态                     
				flags[i][j] = false;                 
			}             
		}         
	}        
	flags[curRow][curCol] = false;         
	return count;     
}


public static boolean canStep(boolean[][] flags, int curRow, int curCol, int targetRow, int targetCol) {
	//         在同一行         
	if(curRow == targetRow) {             
		int low = curCol < targetCol?curCol:targetCol;             
		if(Math.abs(curCol - targetCol) >1 && flags[curRow][low+1] == false)                 
			return false;         
		}
	//         在同一列         
	if(curCol == targetCol) {             
		int low = curRow < targetRow?curRow:targetRow;             
		if(Math.abs(curRow - targetRow) >1 && flags[low+1][curCol] == false)                 
			return false;         
		}
	//         斜对角         
	if(Math.abs(curRow-targetRow)==2 && Math.abs(curCol-targetCol)==2 && flags[1][1] == false)             
		return false;         
	return true;     
	}