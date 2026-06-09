class Solution {
    public int lengthOfLongestSubstring(String s) {

        int longest = 0;

        int i = 0;
        int j = 0;

        Queue<Character> seen = new LinkedList<>();

        while(j < s.length()){

            if(seen.contains(s.charAt(j))){
                i++;
                seen.poll();
            }
            else{
                seen.offer(s.charAt(j));
                longest = Math.max(longest, seen.size());
                j++;
            }

            

        }

        return longest;
        
    }
}
