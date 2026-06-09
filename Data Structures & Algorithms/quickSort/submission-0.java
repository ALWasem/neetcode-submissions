// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {

        quickSortRec(pairs, 0, pairs.size() - 1);
        return pairs;

    }

    public void quickSortRec(List<Pair> pairs, int s, int e){

        if (e - s + 1 <= 1)
            return;

        Pair pivot = pairs.get(e);
        int left = s;

        for(int i = s; i < e; i++){
            if(pairs.get(i).key < pivot.key){
                Pair tmp = pairs.get(left);
                pairs.set(left, pairs.get(i));
                pairs.set(i, tmp);
                left++;
            }
        }

        pairs.set(e, pairs.get(left));
        pairs.set(left, pivot);

        quickSortRec(pairs, s, left - 1);
        quickSortRec(pairs, left + 1, e);
    
    }

}
