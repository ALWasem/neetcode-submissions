// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {

        return mergeSortRec(pairs, 0, pairs.size() - 1);

    }

    public List<Pair> mergeSortRec(List<Pair> pairs, int s, int e) {

        if(e - s <= 0){
            return pairs;
        }

        int m = (s + e) / 2;

        mergeSortRec(pairs, s, m);
        mergeSortRec(pairs, m + 1, e);
        merge(pairs, s, m, e);
        

        return pairs;

    }

    public List<Pair> merge(List<Pair> pairs, int s, int m, int e) {

        List<Pair> left = new ArrayList<>(pairs.subList(s, m + 1));
        List<Pair> right = new ArrayList<>(pairs.subList(m + 1, e + 1));

        int l = 0;
        int r = 0;

        int i = s;

        while(l < left.size() && r < right.size()){
            if(left.get(l).key <= right.get(r).key){
                pairs.set(i, left.get(l));
                l++;
            }
            else{
                pairs.set(i, right.get(r));
                r++;
            }
            i++;
        }

        while(l < left.size()){
            pairs.set(i, left.get(l));
            l++;
            i++;
        }
        while(r < right.size()){
            pairs.set(i, right.get(r));
            r++;
            i++;
        }

        return pairs;

    }
}
