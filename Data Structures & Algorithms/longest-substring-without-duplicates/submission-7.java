class Solution {
    public int lengthOfLongestSubstring(String s) {

        int longest = 0;

        Queue<Character> seen = new LinkedList<>();

        int i = 0;
        int j = 0;

        while(i < s.length()){
            
            if(!seen.contains(s.charAt(i))){
                seen.offer(s.charAt(i));
                longest = Math.max(longest, seen.size());
                i++;
            }
            else{
                j++;
                seen.poll();
            }
            
        }

        return longest;
        
    }
}
