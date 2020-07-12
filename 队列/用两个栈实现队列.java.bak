/*面试题09. 用两个栈实现队列
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
示例 1：
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]*/


/*思路；删除一个元素的步骤：当stack2中不为空时，在stack2中的栈顶元素是最先进入队列的元素，
      可以弹出。如果stack2为空时，我们把stack1中的元素逐个弹出并压入stack2。由于先进入队列的元素
      被压到stack1的底端，经过弹出和压入之后就处于stack2的顶端了，又可以直接弹出*/

class CQueue {
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();

    public CQueue() {

    }
    
    public void appendTail(int value) {
        stack1.push(value);

    }
    
    public int deleteHead() {
        //if(stack1.empty()&&stack2.empty())
            //return -1;
        if(!stack2.empty())
            return stack2.pop();
        if(stack2.empty()&&!stack1.empty()){//只有stack2为空时，才将stack1中的元素出栈
            while(!stack1.empty()){
            stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        return -1;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */