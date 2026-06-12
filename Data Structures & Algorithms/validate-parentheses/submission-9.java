class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()){
            if(c == '{')
                stack.add('}');
            else if(c == '(')
                stack.add(')');
            else if(c == '[')
                stack.add(']');
            else if(!stack.isEmpty() && stack.pop() == c)
                continue;
            else
                return false;
        }

        return stack.isEmpty();
        
    }
}
