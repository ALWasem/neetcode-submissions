class Solution {
    public int removeElement(int[] nums, int val) {

        int k = nums.length;

        if(k == 0){
            return k;
        }

        if(nums[nums.length - 1] == val){
            nums[nums.length - 1] = -1;
            k--;
        }
        
        for(int i = 0; i < nums.length; i++){

            if(nums[i] == val){
                k--;
                for(int j = i + 1; j < nums.length; j++){
                    nums[j - 1] = nums[j];
                }
                i--;
            }     

        }

        return k;

    }
}