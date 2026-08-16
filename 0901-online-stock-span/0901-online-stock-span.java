class P
{
    int f , s;
    P(int x , int y)
    { f=x; s=y;}
}
class StockSpanner {
    Stack<P> st;
    int i;

    public StockSpanner() {
        st = new Stack<>();
        i = -1;
    }
    
    public int next(int price) {
        i++;

        while(!st.isEmpty() && st.peek().f <= price)
        st.pop();

        int ans = i - (st.isEmpty() ? -1 : st.peek().s);
        
        st.push(new P(price,i));

        return ans;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */