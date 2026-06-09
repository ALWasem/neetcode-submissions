class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        indicies = {}
        for i in range(len(nums)):
            indicies[nums[i]] = i

        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in indicies and indicies[diff] != i:
                return [i, indicies[diff]]
        return false
            
        