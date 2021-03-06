//归并排序-分治
public void mergesort(int[] num,int begin,int end){
	if(begin>=end)
		return;
	int point=(begin+end)>>1;//(begin+end)/2
	mergesort(num,begin,point);
	mergesort(num,point+1,end);
	merge(num,begin,point,end);
}
public void merge(int[] num,int begin,int point,int end){
	int[] tem=new int[end-begin+1];//中间数组，用于存储排好序的序列
	int i=begin;
	int j=point+1;
	int k=0;
	while(i<=point&&j<=end){//合并的三段式，三个while,第一个while用于且的关系，
		tem[k++]=num[i]<num[j]?num[i++]:num[j++];//剩下两个用于剩余没排的放后面
	}
	while(i<=point)
		tem[k++]=num[i++];
	while(j<=end)
		tem[k++]=num[j++];
	for(int q=0;q<tem.length;q++){
		num[begin+q]=tem[q];
	}

}