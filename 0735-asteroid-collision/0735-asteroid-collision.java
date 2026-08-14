class Solution {
    public int[] asteroidCollision(int[] a) {
        int n = a.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<n;i++)
        {
            if(a[i]>0)
            {
                st.push(a[i]);
                continue;
            }

            while(!st.isEmpty() && st.peek() >0 && -a[i]>st.peek()) st.pop();

            if(st.isEmpty() || st.peek() < 0) st.push(a[i]);
            else if(st.peek() == -a[i]) st.pop();

        
        }
        int ans[] = new int[st.size()];

        for(int i =0;i<ans.length;i++)
        ans[i] = st.get(i);

        return ans;
       
    }
}