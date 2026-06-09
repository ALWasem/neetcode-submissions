class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();

        dfs(0, nums, target, combo, result);

        return result;
        
    }

    public void dfs(int i, int[] nums, int target, List<Integer> combo, 
        List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList<>(combo));
            return;
        }

        if(target < 0 || i >= nums.length)
            return;

        combo.add(nums[i]);
        dfs(i, nums, target - nums[i], combo, result);
        combo.remove(combo.size() - 1);
        dfs(i + 1, nums, target, combo, result);



    }
}
