50. Pow(x, n)
ʵ�� pow(x, n) �������� x �� n ���ݺ�����
ʾ�� 1:
����: 2.00000, 10
���: 1024.00000
ʾ�� 2:
����: 2.10000, 3
���: 9.26100
ʾ�� 3:
����: 2.00000, -2
���: 0.25000
����: 2-2 = 1/22 = 1/4 = 0.25
˵��:
-100.0 < x < 100.0
n �� 32 λ�з�������������ֵ��Χ�� [?231, 231 ? 1] ��
//����˼�룬�����⻯��С��������ڹ���
class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            n=-n;
            x=1/x;
        }
        if(n==0)
            return 1.0;
        return jisuan(x,n);

    }
    public double jisuan(double x,int n){
        if(n==0)
            return 1.0;
        double half=jisuan(x,n/2);
        if(n%2==0)
            return half*half;
        else{
            return half*half*x;
        }

    }
}