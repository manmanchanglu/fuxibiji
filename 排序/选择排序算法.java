public void selectionSort(int[] arr){
	int l=arr.length;
	for(int i=0;i<l-1;i++){
		int temp=arr[i];
		int w=i;
		for(int j=i+1;j<l;j++){
			if(arr[j]<temp){//Ѱ����С��
				temp=arr[j];
				w=j;//����С����������
			}
		}
		arr[w]=arr[i];
		arr[i]=temp;
	}
}