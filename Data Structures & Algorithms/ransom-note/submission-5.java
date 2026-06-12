class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> freq = new HashMap<>();

        for(Character c : magazine.toCharArray()){
            if(freq.containsKey(c)){
                freq.put(c, freq.get(c) + 1);
            }
            else{
                freq.put(c, 1);
            }
        }

        System.out.print(freq);

        for(Character c : ransomNote.toCharArray()){
            if(freq.containsKey(c) && freq.get(c) > 0)
                freq.put(c, freq.get(c) - 1);
            else
                return false;
        }

        return true;
        
    }
}