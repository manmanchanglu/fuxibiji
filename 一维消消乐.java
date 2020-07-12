class Solution {
        int n;
        int[][] F;
        int[] prev;
 
        public int removeBoxes(int[] boxes) {
            n = boxes.length;
            prev = new int[n];
            F = new int[n][n];
            for (int i = 0; i < n; i++) {
                prev[i] = -1;
                for (int j = 0; j < n; j++) {
                    F[i][j] = -1;
                }
                for (int j = i - 1; j >= 0; --j) {
                    if (boxes[i] == boxes[j]) {
                        prev[i] = j;
                        break;
                    }
                }
            }
            return f(0, n - 1);
        }
 
        public int f(int i, int j) {
            if (i > j) {
                return 0;
            }
            if (F[i][j] != -1) {
                return F[i][j];
            }
            if (i == j) {
                return F[i][j] = 1;
            }
            return F[i][j] = g(i, j, prev[j], 1);
        }
 
 
        public int g(int i, int j, int r, int m) {
            if (i > j) {
                return 0;
            }
            if (r < i) {
                return f(i, j - 1) + m * m;
            }
            // 如果相邻，可以消除许多中间状态
            if (r + 1 == j) {
                return g(i, r, prev[r], m + 1);
            }
            int rv = prev[r];
            return Math.max(
                    g(i, r, rv, m + 1) + f(r + 1, j - 1),
                    g(i, j, rv, m)
            );
        }
    }


