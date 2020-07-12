//堆排序
PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
			public int compare(ListNode o1, ListNode o2) {
				return (o1.val - o2.val);//构建的小顶堆
                return (o2.val-o1.val);//构建的大顶堆
			}
		});

PriorityQueue<ListNode> queue=new PriorityQueue(new Comparator<ListNode>(){
	public int compare(ListNode o1,ListNode o2){
		return o1.val-o2.val;//小顶堆
		return o2.val-o1.val;//大顶堆
	}
});
//二叉堆
/**
 *“上浮”调整
 *array 待调整的堆
 */
public static void upAdjust(int[] array){
	int childIndex=array.length-1;
	int parentIndex=(childIndex-1)/2;
	//temp保存插入的叶子结点值，用于最后的赋值
	int temp=array[childIndex];
	while(childIndex>0&&temp<array[parentIndex]){
		array[childIndex]=array[parentIndex];
		childIndex=parentIndex;
		parentIndex=(parentIndex-1)/2;
	}
	array[childIndex]=temp;
}
/**
 *"下沉调整"
 *array 待调整的堆
 *parentIndex 要“下沉”的父节点
 *length 堆的有效大小
*/
public static void downAdjust(int[] array,int parentIndex,int length){
	int temp=array[parentIndex];//temp保存父节点值，用于最后的赋值
	int childIndex=2*parentIndex+1;
	while(childrenIndex<length){//如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
		if(childIndex+1<length&&array[childIndex+1]<array[children]){
			childIndex++;
		}
		if(temp<=array[childIndex])//如果父节点小于任何一个孩子的值，则直接跳出
			break;
		array[parentIndex]=array[childIndex];//无须真正的交换，单向赋值即可
		parentIndex=childIndex;
		childIndex=2*childIndex+1;
	}
	array[parentIndex]=temp;
}
/**
 *构建堆
 *array 待调整的堆
 */
public static void buildHeap(int[] array){
	for(int i=(array.length-2)/2;i>=0;i--){
		downAdjust(array,i,array.length);
	}
}

public static void main(String[] args){
	int[] array=new int[] {1,3,2,6,5,7,8,9,10,0};
	upAdjust(array);
	System.out.println(Arrays.toString(array));

	array=new int[] {7,1,3,10,5,2,8,9,6};
	buildHeap(array);
	System.out.println(Arrays.toString(array));
}