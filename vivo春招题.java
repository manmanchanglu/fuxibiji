��vivo�����ϣ�ÿλְ�����Ŷ��ֻ��ӹ�������ʶ����Ϥ�;�������ӣ��ղ���Ҳ�᲻�������� 
�����һ������1̨��������2��(���ڶ�������)ÿ������2����������3��(�����ġ��塢����)ÿ������3�� ... ...  
�Դ����ƣ����̼������n���ܹ������������ֻ�������
class Solution {
public:
    /**
     *
     * @param n int���� ��n��
     * @return int����
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

�ָ������������� n����Ѱ�Ҳ������С�������� m��m>9����ʹ�� m �ĸ�λ����λ��ʮλ����λ ... ...��֮�˻�����n��������������� -1��
//����С��10����n�����1n��
//���ڴ���10��������Ҫ�ֽ�Ϊ���ɸ���λ��֮�������ֵĸ����������١�������ֿ��Էֽ�Ϊ��9��8��...��2������֮����Ȼ���С����������ɡ�
class Solution {
public:
    /**
     * ����һ��������ֵ������һ������ֵ
     * @param n int���� n>9
     * @return int����
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


���ӣ�https://www.nowcoder.com/questionTerminal/c552248efdbd41a18d35b7a2329f7ad8
��Դ��ţ����

���ӣ�https://www.nowcoder.com/questionTerminal/c552248efdbd41a18d35b7a2329f7ad8
��Դ��ţ����

����һ�� 3x3 ���� Android �����ֻ�������������������� m �� n ��������ʹ������m ��������� n�������Խ�������Ļ��������Чģʽ������     
������Чģʽ��ָ��     
1��ÿ��ģʽ������������m���������n������     
2�����еļ��������ǲ�ͬ�ģ�     
3�������ģʽ��������������������ͨ���κ�����������������������ģʽ��ѡ�񣬲�����������ѡ�������ͼ����     
4��˳����أ�������Ч��������ܸ������ֻ���ͬ����             
���룺m,n        �����������������m���������n���� 
�����       ����m��n��������������Чģʽ������ 

public static int solution (int m, int n) {
	//         �ݹ�ʵ��         
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
	//         �������귵��         
	if(steps == n)             
		return 1;
	//         ��������ߣ���ô���� 1         
	for(int i=0;i<3;i++) {             
		for(int j=0;j<3;j++) {                 
			if(flags[i][j] == false && canStep(flags, curRow, curCol, i, j)) {                     
				count += findNext(flags, i, j, steps, n);
				//                     �ָ�״̬                     
				flags[i][j] = false;                 
			}             
		}         
	}        
	flags[curRow][curCol] = false;         
	return count;     
}


public static boolean canStep(boolean[][] flags, int curRow, int curCol, int targetRow, int targetCol) {
	//         ��ͬһ��         
	if(curRow == targetRow) {             
		int low = curCol < targetCol?curCol:targetCol;             
		if(Math.abs(curCol - targetCol) >1 && flags[curRow][low+1] == false)                 
			return false;         
		}
	//         ��ͬһ��         
	if(curCol == targetCol) {             
		int low = curRow < targetRow?curRow:targetRow;             
		if(Math.abs(curRow - targetRow) >1 && flags[low+1][curCol] == false)                 
			return false;         
		}
	//         б�Խ�         
	if(Math.abs(curRow-targetRow)==2 && Math.abs(curCol-targetCol)==2 && flags[1][1] == false)             
		return false;         
	return true;     
	}