class Solution {
    public int lengthOfLongestSubstring(String s) {

        int longest = 0;

        Queue<Character> substring = new LinkedList<>();

        //int i = 0;
        //int j = 0;

        for(int i = 0; i < s.length(); i++){

            if(!substring.contains(s.charAt(i))){
                substring.add(s.charAt(i));
                longest = Math.max(longest, substring.size());
            }
            else{
                substring.poll();
                i--;
            }
                
        }

        return longest;
        
    }
}
