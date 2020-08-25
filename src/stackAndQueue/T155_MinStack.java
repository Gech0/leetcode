package stackAndQueue;

import java.util.Stack;

public class T155_MinStack {
    private Stack<Integer> stack; //这里可以定义为private
    private Stack<Integer> minSta;
    public T155_MinStack() {
        stack = new Stack<>();
        minSta = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (x <= minSta.peek()) {
            /*
            注意：等于的时候，必须放进去
            如果不放入的话，出栈的时候无法判断辅助栈要不要出栈
             */
            minSta.push(x);
        }
    }

    public void pop() {
        int cur = stack.pop();
        if (cur == minSta.peek()) {
            minSta.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minSta.peek();
    }
}
