class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> magCount = new HashMap<>();
        //HashMap<Character, Integer> rnCount = new HashMap<>();

        for(char c : magazine.toCharArray()){
            if(magCount.containsKey(c))
                magCount.put(c, magCount.get(c) + 1);
            else
                magCount.put(c, 1);
        }

        for(char c : ransomNote.toCharArray()){
            if(magCount.containsKey(c) && magCount.get(c) > 0)
                magCount.put(c, magCount.get(c) - 1);
            else
                return false;
        }

        return true;
        
    }
}