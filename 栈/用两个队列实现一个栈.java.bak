/*225. 用队列实现栈
使用队列实现栈的下列操作：
push(x) -- 元素 x 入栈
pop() -- 移除栈顶元素
top() -- 获取栈顶元素
empty() -- 返回栈是否为空
注意:
你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。*/
/*思路：考虑弹出过程：根据栈的后入先出原则，最后被压入栈的c应该最先被弹出。
      由于c位于queue1的尾部，而我们每次只能从队列的头部删除元素，因此我们可以
      先从queue1中依次删除元素a、b并插入到queue2中，再从queue1中删除元素c。
      这样就相当于从栈中弹出元素c了。同样的方法弹出b。*/
//也就是说在两个队列之间不断地复制元素，栈顶元素为复制到另一个队列的最后一个元素，保证所有元素同时只在一个队列里
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
    public int top() {//只查看不弹出，所以查看后要弹出到另一个队列，中间用n做转换
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