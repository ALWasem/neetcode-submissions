class Solution {
    public int removeElement(int[] nums, int val) {

        int k = 0;

        for(int i = 0; i < nums.length; i++){

            nums[k] = nums[i];

            if(nums[i] != val){
                k++;
            }
        }

        return k;

    }
}