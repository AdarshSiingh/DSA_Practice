class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length; int max = nums[0];
        int[] p = new int[n];
        int k =0; long sum =0;

        for(int i: nums)
        {
            max = Math.max(max,i);
            p[k++] = gcd(i,max);
        }

        Arrays.sort(p);

        for(int i = 0;i<n/2;i++)
        sum += gcd(p[i] , p[n-i-1]);

        return sum;
      
        
    }
    int gcd(int a , int b)
    {
        while(b!= 0)
        {
            int t = b;
            b = a%b;
            a = t;

        }
        return a;
    }
}