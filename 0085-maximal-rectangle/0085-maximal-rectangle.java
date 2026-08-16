class Solution {
    public int maximalRectangle(char[][] mat) {
        int r = mat.length , c = mat[0].length , mm =0 , sum =0;
        int[][] a = new int[r][c];

        for(int j=0;j<c;j++)
        {
            sum =0;
            for(int i =0;i<r;i++)
            {
                if(mat[i][j] == '1') sum++;
                else sum = 0;

                a[i][j] = sum;
            }
        }

        for(int[] i:a)
        mm = Math.max(mm,largestRectangleArea(i));

        return mm;
        
    }

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