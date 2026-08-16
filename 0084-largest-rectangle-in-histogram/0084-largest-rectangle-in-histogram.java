class Solution {
    public int largestRectangleArea(int[] h) {
        Stack<Integer> s = new Stack<>();
        int max = 0;
        int n = h.length;

        for(int i=0;i<n;i++)
        {
            while(!s.isEmpty() && h[s.peek()] > h[i])
            {
                int e = s.pop();
                int pse = s.isEmpty() ? -1 : s.peek();
                max=Math.max(max,( h[e] * (i - pse - 1) ));
            }
            s.push(i);
        }

        while(!s.isEmpty())
        {
            int e = s.pop();
            int nse = n;
            int pse = s.isEmpty() ? -1 : s.peek();

            max=Math.max(max,( h[e] * (nse - pse - 1) ));
        }

        return max;
        
    }
}