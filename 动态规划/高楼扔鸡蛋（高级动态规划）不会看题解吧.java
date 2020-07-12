/*887. ��������
�㽫��� K ��������������ʹ��һ���� 1 �� N  ���� N ��¥�Ľ�����
ÿ�����Ĺ��ܶ���һ���ģ����һ�������ˣ���Ͳ����ٰ�������ȥ��
��֪������¥�� F ������ 0 <= F <= N �κδӸ��� F ��¥�����µļ��������飬�� F ¥�������͵�¥�����µļ����������ơ�
ÿ���ƶ��������ȡһ��������������������ļ���������������һ¥�� X ���£����� 1 <= X <= N����
���Ŀ����ȷ�е�֪�� F ��ֵ�Ƕ��١�
���� F �ĳ�ʼֵ��Σ���ȷ�� F ��ֵ����С�ƶ������Ƕ��٣�
ʾ�� 1��
���룺K = 1, N = 2
�����2
���ͣ�
������ 1 ¥���䡣��������ˣ����ǿ϶�֪�� F = 0 ��
���򣬼����� 2 ¥���䡣��������ˣ����ǿ϶�֪�� F = 1 ��
�����û�飬��ô���ǿ϶�֪�� F = 2 ��
��ˣ�����������������Ҫ�ƶ� 2 ����ȷ�� F �Ƕ��١�
ʾ�� 2��
���룺K = 2, N = 6
�����3
ʾ�� 3��
���룺K = 3, N = 14
�����4*/
class Solution {
    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    Map<Integer, Integer> memo = new HashMap();
    public int dp(int K, int N) {
        if (!memo.containsKey(N * 100 + K)) {
            int ans;
            if (N == 0)
                ans = 0;
            else if (K == 1)
                ans = N;
            else {
                int lo = 1, hi = N;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp(K-1, x-1);
                    int t2 = dp(K, N-x);

                    if (t1 < t2)
                        lo = x;
                    else if (t1 > t2)
                        hi = x;
                    else
                        lo = hi = x;
                }

                ans = 1 + Math.min(Math.max(dp(K-1, lo-1), dp(K, N-lo)),
                                   Math.max(dp(K-1, hi-1), dp(K, N-hi)));
            }

            memo.put(N * 100 + K, ans);
        }

        return memo.get(N * 100 + K);
    }
}

���ߣ�LeetCode-Solution
���ӣ�https://leetcode-cn.com/problems/super-egg-drop/solution/ji-dan-diao-luo-by-leetcode-solution-2/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������