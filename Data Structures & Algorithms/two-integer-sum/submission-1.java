class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        //Key - target - num
        //Value - index
        Map<Integer, Integer> track = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            track.put(target - nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            if(track.get(nums[i]) != null && i != track.get(nums[i])){
                result[0] = i;
                result[1] = track.get(nums[i]);
                break;
            }
                
        }

        return result;
            
    }
}
