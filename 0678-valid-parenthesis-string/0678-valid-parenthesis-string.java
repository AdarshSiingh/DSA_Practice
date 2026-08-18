class Solution {
    public boolean checkValidString(String s) {
        char[] c = s.toCharArray();
        int n = c.length , l =0 , h = 0 ;

        for(char ch : c)
        {
            if(ch == '(')
            {
                l++; h++;
            }
            else if(ch == ')')
            {
                l--; h--;
            }
            else
            {
                l--;
                h++;
            }

            if(l<0) l = 0;
            if(h<0) return false;
        }

        return l==0;
        
    }
}