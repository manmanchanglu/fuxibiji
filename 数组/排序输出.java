//��Ŀ�������������ƽ��ֵ��Ȼ�������ƽ��ֵ��С�������������ǰ�����ƽ��ֵԶ�����д�С�����������

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
					if(!list.contains(j)) {//��¼ǰ������Сֵ�±꣬��Ҫ��ѡ�����������±��䵼�²���ȷ
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