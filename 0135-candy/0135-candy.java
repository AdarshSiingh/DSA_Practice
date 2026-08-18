class Solution {
    public int candy(int[] r) {

        int n = r.length , c = n , i =1, p=0 , v=0;

        while(i<n)
        {
            if(r[i-1] == r[i])
            { i++; continue; }

            p=0;
            while(i<n && r[i-1]<r[i])
            {
                p++;
                c+=p;
                i++;
            }
            v=0;
            while(i<n && r[i-1]>r[i])
            {
                v++;
                c+=v;
                i++;
            }

            c-=Math.min(p,v);


        }
        return c;
        
        
    }
}