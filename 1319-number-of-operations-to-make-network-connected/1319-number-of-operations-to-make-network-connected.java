class DS
{
    int p[] , s[];
    DS(int n)
    {
        p = new int[n] ; s = new int[n];

        for(int i = 0;i<n;i++)
        {
            p[i] = i;  s[i] = 1;
        }
    }

    int par(int n)
    {
        if(p[n]==n)
        return n;

        return p[n] = par(p[n]); 
    }
    void size(int u , int v)
    {
        int x = par(u) , y = par(v);

        if(x==y) return;

        if(s[x]<s[y])
        {
            p[x] = y;
            s[y] += s[x];
        }
        else
        {
            p[y] = x;
            s[x] += s[y];
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {

        DS d = new DS(n); int fre = 0 , c = 0;

        for(int i[] : connections)
        {
            if(d.par(i[0])==d.par(i[1]))
            fre++;
            else
            d.size(i[0],i[1]);
        }

        for(int i = 0;i<n;i++)
        if(d.par(i) == i)
        c++;

        return (fre >= c-1) ? c-1 : -1 ;
        
    }
}