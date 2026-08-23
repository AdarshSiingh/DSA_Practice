class Solution {
    public String removeStars(String st) {
        char[] ch = st.toCharArray();
        Stack<Character> s = new Stack<>();

        for(char c : ch)
        {
            if(c != '*') { s.push(c); continue;}

            if(!s.isEmpty())
            s.pop();

        }
        StringBuilder sb = new StringBuilder();

        for(int i =0;i<s.size();i++)
        sb.append(s.get(i));

        return sb.toString();
        
    }
}