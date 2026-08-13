class MinStack {

    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min=Long.MAX_VALUE;
        
    }
    
    public void push(int value) {
        long x = value;

        if(st.isEmpty())
        {
            st.push(x);
            min = x;
        }
        else if(x>min)
        st.push(x);
        else
        {
            st.push(2*x-min);
            min=x;
        }
        
    }
    
    public void pop() {
        long x = st.pop();
        if(x<min)
        min = 2*min-x;
        
    }
    
    public int top() {
        if(st.peek() < min)
        return (int)min;

        return st.peek().intValue();
        
    }
    
    public int getMin() {
        return (int)min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */