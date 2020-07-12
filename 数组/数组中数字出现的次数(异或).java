/*面试题56 - I. 数组中数字出现的次数
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
示例 1：
输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：
输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
这是一道非常经典的题目，用异或可以轻松解决 —— 所有的数字异或起来，就是答案。
我们先来看下异或的性质（数学里异或的符号是⊕)：
交换律：p⊕q=q⊕p
结合律：p⊕(q⊕r)=(p⊕q)⊕r
恒等率：p⊕0=p
归零率：p⊕p=0
那么，如果有若干个数字进行异或操作：
a1⊕a2⊕...⊕anan?
我们可以根据交换律、结合律将相同的数字优先两两进行异或运算。此时根据归零率,每两个相同的数字都变成了0，再根据恒等率,把式子里所有的0去了，此时就只剩下只出现一次的那个数了！
作者：sweetiee
链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shi-yao-zhe-ti-huan-ke-yi-yong-er-fen-cha-zhao-bi-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
我们回到今天的这道题上来。如果我们对所有的数字进行异或，假设只出现一次的数字分别是 p和q，那么最终的结果 p⊕q，此时我们不知道p和q分别
是什么。但是如果我们能把p和q从数组里面区分开来呢？假设我们知道了某个数r,r是介于p和q之间，那么我们可以把整个数组分成两部分
—— ai<=r或ai>r。并且，一个数组里有p，另一个数组里有q。那么对这两部分的数字分别求异或和，结果就变成了p和q。完美！
这样就把问题转换成了我们已经解决的问题上了！

作者：sweetiee
链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shi-yao-zhe-ti-huan-ke-yi-yong-er-fen-cha-zhao-bi-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class Solution {
    public int[] singleNumbers(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, zeroCount = 0;
        for (int num: nums) {
            if (num == 0) {
                zeroCount += 1;
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum ^= num;
        }
        // 需要特判一下某个数是0的情况。
        if (zeroCount == 1) {
            return new int[]{sum, 0};
        }
        int lo = min, hi = max;
        while (lo <= hi) {
            // 根据 lo 的正负性来判断二分位置怎么写，防止越界。
            int mid = (lo < 0 && hi > 0)? (lo + hi) >> 1: lo + (hi - lo) / 2;
            int loSum = 0, hiSum = 0;
            for (int num: nums) {
                if (num <= mid) {
                    loSum ^= num;
                } else {
                    hiSum ^= num;
                }
            }
            if (loSum != 0 && hiSum != 0) {
                // 两个都不为0，说明 p 和 q 分别落到2个数组里了。
                return new int[] {loSum, hiSum};
            }
            if (loSum == 0) {
                // 说明 p 和 q 都比 mid 大，所以比 mid 小的数的异或和变为0了。
                lo = mid + 1;
            } else {
                // 说明 p 和 q 都不超过 mid
                hi = mid - 1;
            }
        }
        // 其实如果输入是符合要求的，程序不会执行到这里，为了防止compile error加一下
        return null;
    }
}
