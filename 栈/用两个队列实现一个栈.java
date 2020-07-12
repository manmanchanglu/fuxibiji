/*225. �ö���ʵ��ջ
ʹ�ö���ʵ��ջ�����в�����
push(x) -- Ԫ�� x ��ջ
pop() -- �Ƴ�ջ��Ԫ��
top() -- ��ȡջ��Ԫ��
empty() -- ����ջ�Ƿ�Ϊ��
ע��:
��ֻ��ʹ�ö��еĻ�������-- Ҳ���� push to back, peek/pop from front, size, �� is empty ��Щ�����ǺϷ��ġ�
����ʹ�õ�����Ҳ��֧�ֶ��С� �����ʹ�� list ���� deque��˫�˶��У���ģ��һ������ , ֻҪ�Ǳ�׼�Ķ��в������ɡ�
����Լ������в���������Ч�ģ�����, ��һ���յ�ջ������� pop ���� top ��������*/
/*˼·�����ǵ������̣�����ջ�ĺ����ȳ�ԭ�����ѹ��ջ��cӦ�����ȱ�������
      ����cλ��queue1��β����������ÿ��ֻ�ܴӶ��е�ͷ��ɾ��Ԫ�أ�������ǿ���
      �ȴ�queue1������ɾ��Ԫ��a��b�����뵽queue2�У��ٴ�queue1��ɾ��Ԫ��c��
      �������൱�ڴ�ջ�е���Ԫ��c�ˡ�ͬ���ķ�������b��*/
//Ҳ����˵����������֮�䲻�ϵظ���Ԫ�أ�ջ��Ԫ��Ϊ���Ƶ���һ�����е����һ��Ԫ�أ���֤����Ԫ��ͬʱֻ��һ��������
class MyStack {
    LinkedList<Integer> list1=new LinkedList<>();
    LinkedList<Integer> list2=new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        
        if(list1.size()!=0)
            list1.add(x);
        else if(list2.size()!=0)
            list2.add(x);
        else{
            list1.add(x);
        }

    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        
        if(list2.size()!=0){
            while(list2.size()>1){
                list1.add(list2.pop());
            }
            return list2.pop();
        }
        if(list1.size()!=0){
            while(list1.size()>1){
                list2.add(list1.pop());
            }
            return list1.pop();
        }
        return 0;

    }
    
    /** Get the top element. */
    public int top() {//ֻ�鿴�����������Բ鿴��Ҫ��������һ�����У��м���n��ת��
        int n;
        
        if(list2.size()!=0){
            while(list2.size()>1){
                list1.add(list2.pop());
            }
            n=list2.pop();
            list1.add(n);
            return n;
        }
        if(list1.size()!=0){
            while(list1.size()>1){
                list2.add(list1.pop());
            }
            n=list1.pop();
            list2.add(n);
            return n;
        }
        return 0;

    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(list1.size()==0&&list2.size()==0)
            return true;
        return false;

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */


 //�ٷ����

 ����˼·
ʹ���������е�����ʹ�ã�ʼ�ձ���һ������Ϊ�ա�
��1��push()����ûʲô���⣬ֱ������ڿյĶ����оͺá�
��2��pop()�������ڽ�װ��Ԫ���еĶ��е�ǰn-1���Ƶ�����һ���ն����У�����size�����������һ��Ԫ��ֱ��ȡ�����ء�
��3��top()������pop()��������˼·һ�£�ֻ����ǰn-1��Ԫ���ƶ��󣬽����һ��Ԫ�ظ�ֵ��Ȼ����ѹ�������ȥ��
��4��empty()����ֱ���ж����������Ƿ�Ϊ�ռ��ɡ�

ע�⣺
��1�����еĽӿ���Java��ʹ�õ���LinkedList<>()��
��2�������е����Ԫ�ط���Ӧ��ʹ��offer(), add()��
��3�������е��Ƴ�����Ӧ��ʹ��poll(), remove();
 class MyStack {

    LinkedList<Integer> queue1 = new LinkedList<>();
    LinkedList<Integer> queue2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(queue1.isEmpty()){
            queue2.offer(x);
        }else{
            queue1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        if(queue1.isEmpty()){
            while(queue2.size()>1){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }else{
            while(queue1.size()>1){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        int top = 0;
        if(queue1.isEmpty()){
            while(queue2.size()>1){
                queue1.offer(queue2.poll());
            }
            top = queue2.poll();
            queue1.offer(top);
        }else{
            while(queue1.size()>1){
                queue2.offer(queue1.poll());
            }
            top =  queue1.poll();
            queue2.offer(top);
        }
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

���ߣ�Heroin_XX
���ӣ�https://leetcode-cn.com/problems/implement-stack-using-queues/solution/liang-ge-dui-lie-de-shi-xian-ji-bai-liao-10000-de-/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������