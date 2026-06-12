class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> indecies = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            indecies.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(indecies.containsKey(diff) && indecies.get(diff) != i)
                return new int[] {i, indecies.get(diff)};
        }
        
        return null;
    }
}
