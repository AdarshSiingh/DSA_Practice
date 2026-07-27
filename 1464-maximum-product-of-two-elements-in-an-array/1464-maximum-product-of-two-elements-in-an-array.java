class Solution {
    public int maxProduct(int[] nums) {

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i: nums)
        q.add(i);

        return ((q.remove()-1) * (q.remove()-1));
        
    }
}