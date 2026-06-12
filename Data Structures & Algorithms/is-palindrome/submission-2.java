class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder rev = new StringBuilder();

        for(Character c : s.toCharArray()){
            if(Character.isLetterOrDigit(c))
                rev.append(Character.toLowerCase(c));
        }

        return rev.toString().equals(rev.reverse().toString());
        
    }
}
