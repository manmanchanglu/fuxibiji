493. ��ת��
����һ������ nums ����� i < j �� nums[i] > 2*nums[j] ���Ǿͽ� (i, j) ����һ����Ҫ��ת�ԡ�
����Ҫ���ظ��������е���Ҫ��ת�Ե�������
ʾ�� 1:
����: [1,3,2,3,1]
���: 2
ʾ�� 2:
����: [2,4,3,5,1]
���: 3


���������鲢����
������ϣ�����������������Ե���Ŀʱ�����ǿ���ʹ�ù鲢����ķ������������ i < j �� nums[i] > 2 * nums[j] ��Ҫ������������ƣ�
�������Ҳ����ʹ�ù鲢����ķ��������ת�Ե���Ŀ��
�ڹ鲢�����У������ǹ鲢���������� nums[start .. mid] �� nums[mid + 1 .. end] ʱ��
���ǿ��Լ��������ǰ���е�ÿһ��Ԫ�� nums[i]������������ nums[i] > 2 * nums[j] �� j ����Ŀ��
���������������Ѿ��ź�����˶��ڹ̶��� i������������ j ������һ���ǴӺ��ߵ���˵㿪ʼ���������� i �����ӣ�j ������Ҷ˵㲻���С��
������ǿ����� nums[mid + 1 .. end] ��ά��һ��ָ�� pt����ʾ���ڵ�ǰ�� i��nums[mid + 1 .. pt] ��������С�� nums[i]������ i �����ӣ�
���ǳ��������ƶ� pt ʹ�ø����������������

���ߣ�LeetCode
���ӣ�https://leetcode-cn.com/problems/reverse-pairs/solution/fan-zhuan-dui-by-leetcode/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������


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

//��������Ѱ�Ҹ���
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
                for(int l2=mid+1;l2<=r;l2++){//��Ƚ������Ǹ��Ķ������
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

