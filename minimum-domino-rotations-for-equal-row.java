//TC: O(n)
//SC: O(n)
//running on leetcode: yes
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops == null || tops.length ==0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max=-1;
        int aRot = 0, bRot=0;
        for(int i=0; i<tops.length; i++){
            map.put(tops[i], map.getOrDefault(tops[i],0)+1);
            if(map.get(tops[i]) >= tops.length) {
                max = tops[i];
            }
            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0)+1);
            if(map.get(bottoms[i]) >= bottoms.length) {
                max = bottoms[i];
            }
        }
        if(max == -1) {
            return -1;
        }
        for(int i=0; i<tops.length; i++) {
            if(tops[i] != max && bottoms[i] != max) {
                return -1;
            }
            if(tops[i] != max) {
                aRot++;
            }
            if(bottoms[i] != max) {
                bRot++;
            }
        }
        return Math.min(aRot, bRot);
    }
}
