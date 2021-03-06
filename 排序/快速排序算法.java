//快速排序算法
public void quaipai(int[] num,int begin,int end){
		if(end>=begin){
			return;
		}
		int povid=partition(num,begin,end);//找到中间位置的值，使其左边小于其值，右边大于其值
		quaipai(num,begin,povid-1);//递归左子序列
		quaipai(num,povid+1,end);//递归右子序列
}
public int partition(int[] num,int begin,int end){
	int povid=end;每次选取最后一个元素作为中间值，进行比较
	int count=begin;
	for(int i=begin;i<end;i++){//小于就进行替换，这里不太好理解，使小于的位于右边，大于的位于左边
		if(num[i]<num[povid]){
			int tem=num[count];
			num[count]=num[i];
			num[i]=tem;
			count++;
		}

	}
	int tem=num[count];
	num[count]=num[povid];
	num[povid]=num[count];
	return count;//count为选取出来的中间值
}