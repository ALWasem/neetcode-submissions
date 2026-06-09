class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:

        for i in range(len(arr)):

            if i == len(arr) - 1:
                arr[i] = -1
                break

            greatest = 0

            for j in range(i + 1, len(arr)):
                if arr[j] > greatest:
                    greatest = arr[j]
            
            arr[i] = greatest

        return arr
                
        