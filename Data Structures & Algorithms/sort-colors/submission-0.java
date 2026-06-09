class Solution {
    public void sortColors(int[] nums) {

        int[] colors = new int[3];

        for(int i = 0; i < nums.length; i++){
            colors[nums[i]]++;
        }

        int i = 0;

        for(int j = 0; j < colors.length; j++){
            for(int k = 0; k < colors[j]; k++){
                nums[i] = j;
                i++;
            }
        }
        
    }
}