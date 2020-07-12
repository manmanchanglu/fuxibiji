493. 翻转对
给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
你需要返回给定数组中的重要翻转对的数量。
示例 1:
输入: [1,3,2,3,1]
输出: 2
示例 2:
输入: [2,4,3,5,1]
输出: 3


方法二：归并排序
当我们希望在数组中求出逆序对的数目时，我们可以使用归并排序的方法。这道题中 i < j 且 nums[i] > 2 * nums[j] 的要求与逆序对类似，
因此我们也可以使用归并排序的方法求出翻转对的数目。
在归并排序中，当我们归并两个子数组 nums[start .. mid] 和 nums[mid + 1 .. end] 时，
我们可以计算出对于前者中的每一个元素 nums[i]，后者中满足 nums[i] > 2 * nums[j] 的 j 的数目。
由于两个子数组已经排好序，因此对于固定的 i，满足条件的 j 的区间一定是从后者的左端点开始，并且随着 i 的增加，j 区间的右端点不会减小。
因此我们可以在 nums[mid + 1 .. end] 中维护一个指针 pt，表示对于当前的 i，nums[mid + 1 .. pt] 的两倍都小于 nums[i]。随着 i 的增加，
我们尝试向右移动 pt 使得更多的数满足条件。

作者：LeetCode
链接：https://leetcode-cn.com/problems/reverse-pairs/solution/fan-zhuan-dui-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {
    public int reversePairs(int[] nums) {
            int res = mergeAndCount(nums, 0, nums.length - 1);
            return res;
        }

        public int mergeAndCount(int[] nums, int l, int r) {
            if (l >= r) {
                return 0;
            } else {
                int mid = l + r >>> 1;
                int allCount = mergeAndCount(nums, l, mid) + mergeAndCount(nums, mid + 1, r);
                int l1 = l;
                int l2 = mid + 1;
                for (int i = l1; i < mid + 1; i++) {
                    while (l2 <= r && (long)nums[i] > (long)nums[l2] * 2) {
                        l2++;
                    }
                    allCount += l2 - (mid + 1);
                }
                doMerge(nums, l, mid, r);
                return allCount;
            }
        }

        public void doMerge(int[] nums, int l, int mid, int r) {
            int i1 = l, i2 = mid + 1;
            int[] arr = new int[r - l + 1];
            int i = 0;
            while (i1 <= mid && i2 <= r) {
                if (nums[i1] < nums[i2]) {
                    arr[i++] = nums[i1++];
                } else {
                    arr[i++] = nums[i2++];
                }
            }
            while (i1 <= mid) {
                arr[i++] = nums[i1++];
            }
            while (i2 <= r) {
                arr[i++] = nums[i2++];
            }

            for (int j = l; j <= r; j++) {
                nums[j] = arr[j - l];
            }
        }
}

//容易理解的寻找个数
class Solution {
    public int reversePairs(int[] nums) {
            int res = mergeAndCount(nums, 0, nums.length - 1);
            return res;
        }

        public int mergeAndCount(int[] nums, int l, int r) {
            if (l >= r) {
                return 0;
            } else {
                int mid = l + r >>> 1;
                int allCount = mergeAndCount(nums, l, mid) + mergeAndCount(nums, mid + 1, r);
                int l1 = l;
                for(int l2=mid+1;l2<=r;l2++){//相比较上面那个改动在这里，
                    while(l1<=mid&&(long)nums[l1]<=2*(long)nums[l2])
                        l1++;
                    allCount+=mid-l1+1;
                }
                doMerge(nums, l, mid, r);
                return allCount;
            }
        }

        public void doMerge(int[] nums, int l, int mid, int r) {
            int i1 = l, i2 = mid + 1;
            int[] arr = new int[r - l + 1];
            int i = 0;
            while (i1 <= mid && i2 <= r) {
                if (nums[i1] < nums[i2]) {
                    arr[i++] = nums[i1++];
                } else {
                    arr[i++] = nums[i2++];
                }
            }
            while (i1 <= mid) {
                arr[i++] = nums[i1++];
            }
            while (i2 <= r) {
                arr[i++] = nums[i2++];
            }

            for (int j = l; j <= r; j++) {
                nums[j] = arr[j - l];
            }
        }
}

