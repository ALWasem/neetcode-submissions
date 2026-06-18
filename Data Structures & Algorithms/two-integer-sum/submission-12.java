class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> indicies = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if(indicies.containsKey(diff))
                return new int[] {indicies.get(diff), i};

            indicies.put(nums[i], i);
        }

        return null;
        
    }
}
