public void insertionSort(int[] arr){
	int l=arr.length;
	int pre,current;
	for(int i=1;i<l;i++){
		pre=i-1;
		current=arr[i];
		while(pre>=0&&arr[pre]>current){//找到合适位置，第一个小于则停止
			arr[pre+1]=arr[pre];//往后移动元素
			pre--;
		}
		arr[pre+1]=current;
	}

}