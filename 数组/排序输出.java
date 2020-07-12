//题目：求整形数组的平均值，然后输出离平均值最小的三个数，他们按照离平均值远近进行从小到大排序输出

public static int[] jisuan(int[] nums) {
		int n=nums.length;
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=nums[i];
		}
		sum=sum/n;
		int[] qwer=new int[n];
		for(int i=0;i<n;i++) {
			qwer[i]=Math.abs(sum-nums[i]);
		}
		int[] as=new int[3];
		List<Integer> list=new ArrayList();
		int h=0;
		for(int i=0;i<3;i++) {
			int temp=0;
			for(int j=1;j<n;j++) {
				if(qwer[temp]>qwer[j]) {
					if(!list.contains(j)) {//记录前三个最小值下标，不要用选择排序，这样下标会变导致不正确
						temp=j;
						list.add(j);
					}
					else
						continue;
				}
			
			}
			as[h++]=nums[temp];
		
			//int r=qwer[i];
			//qwer[i]=qwer[temp];
			//qwer[temp]=r;
		}
		return as;
	}