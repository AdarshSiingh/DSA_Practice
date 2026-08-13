class Solution {
    public int[] nextGreaterElements(int[] a) {
        int n = a.length;
        int[] r = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i = 2*n-1;i>=0;i--)
        {
            while(!s.isEmpty() && s.peek()<=a[i%n]) s.pop();

            if(i<n)
            r[i] = s.isEmpty()?-1:s.peek();
            s.push(a[i%n]);
        }

        return r;
        
    }
}