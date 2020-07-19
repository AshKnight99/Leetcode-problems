/*
155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
Constraints:
Methods pop, top and getMin operations will always be called on non-empty stacks.
*/
class MinStack {
    Stack <Integer> s=new Stack <Integer>();
    Stack <Integer>min=new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {    
    }    
    public void push(int x) {
        s.push(x);
        if(min.isEmpty())
            min.push(x);
        else{
            if(x<min.peek())
                min.push(x);
            else
                min.push(min.peek());
        }        
    }    
    public void pop() {
        s.pop();
        min.pop();
    }    
    public int top() { 
          return s.peek();        
    }    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
/*
Using O(1) space
class MinStack {
    /** initialize your data structure here. */
    Stack <Integer> s;
    int min;
    public MinStack() {
        s = new Stack<Integer>();  
    min = Integer.MAX_VALUE;
    }    
    public void push(int x) {
        if(s.isEmpty()){
            min = x;
            s.push(x);
        }
        else if(x >= min)
            s.push(x);
        else{
            s.push(2 * x - min);
            min = x;
        }        
    }    
    public void pop() {
        if(s.isEmpty())
            return ;        
        else if(s.peek() >= min)
            s.pop();        
        else{
            min = 2 * min  - s.peek();
            s.pop();
        }                  
    }
    
    public int top() {
        //if(s.isEmpty())
          //  return -1;
        //if(s.peek() >= min)
        return s.peek();
        //else
          //  return min;
        
    }
    
    public int getMin() {
        //if(s.isEmpty())
           // return -1;
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
*/