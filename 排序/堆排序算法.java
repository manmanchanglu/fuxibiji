//������
PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
			public int compare(ListNode o1, ListNode o2) {
				return (o1.val - o2.val);//������С����
                return (o2.val-o1.val);//�����Ĵ󶥶�
			}
		});

PriorityQueue<ListNode> queue=new PriorityQueue(new Comparator<ListNode>(){
	public int compare(ListNode o1,ListNode o2){
		return o1.val-o2.val;//С����
		return o2.val-o1.val;//�󶥶�
	}
});
//�����
/**
 *���ϸ�������
 *array �������Ķ�
 */
public static void upAdjust(int[] array){
	int childIndex=array.length-1;
	int parentIndex=(childIndex-1)/2;
	//temp��������Ҷ�ӽ��ֵ���������ĸ�ֵ
	int temp=array[childIndex];
	while(childIndex>0&&temp<array[parentIndex]){
		array[childIndex]=array[parentIndex];
		childIndex=parentIndex;
		parentIndex=(parentIndex-1)/2;
	}
	array[childIndex]=temp;
}
/**
 *"�³�����"
 *array �������Ķ�
 *parentIndex Ҫ���³����ĸ��ڵ�
 *length �ѵ���Ч��С
*/
public static void downAdjust(int[] array,int parentIndex,int length){
	int temp=array[parentIndex];//temp���游�ڵ�ֵ���������ĸ�ֵ
	int childIndex=2*parentIndex+1;
	while(childrenIndex<length){//������Һ��ӣ����Һ���С�����ӵ�ֵ����λ���Һ���
		if(childIndex+1<length&&array[childIndex+1]<array[children]){
			childIndex++;
		}
		if(temp<=array[childIndex])//������ڵ�С���κ�һ�����ӵ�ֵ����ֱ������
			break;
		array[parentIndex]=array[childIndex];//���������Ľ���������ֵ����
		parentIndex=childIndex;
		childIndex=2*childIndex+1;
	}
	array[parentIndex]=temp;
}
/**
 *������
 *array �������Ķ�
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