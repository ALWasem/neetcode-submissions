class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] freqList = new List[nums.length + 1];

        for(int i = 0; i < freqList.length; i++){
            freqList[i] = new ArrayList<>();
        }

        for(int num : nums){
            if(freqMap.containsKey(num))
                freqMap.put(num, freqMap.get(num) + 1);
            else
                freqMap.put(num, 1);
        }

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            freqList[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;

        for(int i = freqList.length - 1; i > 0; i--){

            for(int n : freqList[i]){
                res[index] = n;
                index++;
                if(index == k)
                    return res;
            }     


        }

        return null;
        
    }
}