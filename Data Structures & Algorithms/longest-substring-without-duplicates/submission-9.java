class Solution {
    public int lengthOfLongestSubstring(String s) {

        Queue<Character> seen = new LinkedList<>();

        int longest = 0;

        int i = 0;
        //int j = 0;

        while(i < s.length()){

            if(!seen.contains(s.charAt(i))){
                seen.offer(s.charAt(i));
                longest = Math.max(longest, seen.size());
                i++;
            }
            else{
                seen.poll();
                //j++;
            }
        }

        return longest;
        
    }
}
