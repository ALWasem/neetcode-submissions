class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> rnMap = new HashMap<>();
        HashMap<Character, Integer> mMap = new HashMap<>();

        if(ransomNote.length() > magazine.length())
            return false;

        for(char c : ransomNote.toCharArray()){
            rnMap.put(c, rnMap.getOrDefault(c, 0) + 1);
        }

        for(char c : magazine.toCharArray()){
            mMap.put(c, mMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : rnMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if(!mMap.containsKey(key))
                return false;
            else if(value > mMap.get(key))
                return false;
        }

        return true;
        
    }
}