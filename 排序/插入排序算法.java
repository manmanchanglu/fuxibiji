public void insertionSort(int[] arr){
	int l=arr.length;
	int pre,current;
	for(int i=1;i<l;i++){
		pre=i-1;
		current=arr[i];
		while(pre>=0&&arr[pre]>current){//�ҵ�����λ�ã���һ��С����ֹͣ
			arr[pre+1]=arr[pre];//�����ƶ�Ԫ��
			pre--;
		}
		arr[pre+1]=current;
	}

}