class Solution {
    public int lengthOfLongestSubstring(String s) {

        Queue<Character> window = new LinkedList<>();

        int longest = 0;

        for(int i = 0; i < s.length(); i++){
            if(window.contains(s.charAt(i))){
                window.poll();
                i--;
            }
            else{
                window.add(s.charAt(i));
                longest = Math.max(longest, window.size());
            }
                
        }

        return longest;
        
    }
}
