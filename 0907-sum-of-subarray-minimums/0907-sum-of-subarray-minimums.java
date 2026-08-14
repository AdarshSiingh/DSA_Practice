class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int[] nse = NSE(arr) , pse = PSEE(arr);
        long sum =0 , mod = (int)1e9+7;

       for(int i = 0; i < n; i++)
{
    int l = i - nse[i];
    int r = pse[i] - i;

    long val = (long) l * r % mod * arr[i] % mod;
    sum = (sum + val) % mod;
}

return (int)sum;
        
    }

    int[] NSE(int[] a)
    {
        int n = a.length;
        Stack<Integer> s = new Stack<>();
        int r[] = new int[n];

        for(int i = n-1;i>=0;i--)
        {
            while(!s.isEmpty() && a[s.peek()] >= a[i]) s.pop();

            r[i] = s.isEmpty() ? n : s.peek();

            s.push(i);
        }
        return r;
    }

    int[] PSEE(int[] a)
    {
        int n = a.length;
        Stack<Integer> s = new Stack<>();
        int r[] = new int[n];

        for(int i =0;i<n;i++)
        {
            while(!s.isEmpty() && a[s.peek()] > a[i]) s.pop();

            r[i] = s.isEmpty() ? -1 : s.peek();

            s.push(i);
            
        }
        return r;

    }
}

