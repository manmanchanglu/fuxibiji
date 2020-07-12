public void bubbleSort(int[] arr){
	int l=arr.length;
	for(int i=0;i<l-1;i++){
		for(int j=0;j<l-1-i;j++){
			if(arr[j]>arr[j+1]){//相邻元素两两比较
				int temp=arr[j];//元素交换
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		}
	}

}