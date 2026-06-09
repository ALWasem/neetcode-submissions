class Solution {
    public boolean isPalindrome(String s) {

        String a = s.toLowerCase();
        String b = a.replaceAll("[^a-zA-Z0-9]","");

        Stack<Character> stack = new Stack<>();

        boolean hasCenter = b.length() % 2 == 1;

        for(int i = 0; i < b.length(); i++){
            if(hasCenter){
                if(i > b.length() / 2){
                    if(b.charAt(i) != stack.pop())
                        return false;
                }
                else if(i == b.length() / 2)
                    continue;
                else
                    stack.add(b.charAt(i));    
            }
            else{
                if(i >= b.length() / 2){
                    if(b.charAt(i) != stack.pop())
                        return false;
                }
                else
                    stack.add(b.charAt(i));
            }
        }

        return true;
        
    }
}
