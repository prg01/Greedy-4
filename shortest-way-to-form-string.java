//Time Complexity: O(m+n)
//Space Complexity: O(1)
//running on leetcode: yes
class Solution {
    public int shortestWay(String source, String target) {
        if(source == null || source.length() == 0) return -1;
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i=0; i<source.length(); i++) {
            char c = source.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        int i = 0; //pointer in target
        int j = 0; //pointer in source
        int result = 1; //holds the answer
        int sl = source.length();
        int tl = target.length();
        while(i < tl) {
            if(!map.containsKey(target.charAt(i))) return -1;
            List<Integer> list = map.get(target.charAt(i));
            int pos = Collections.binarySearch(list, j);
            if(pos < 0) {
                pos = -pos -1;
            }
            if(pos == list.size()) {
                j = 0;
                result++;
            }
            else {
                j = list.get(pos) + 1;
                i++;
            }
        }
        return result;
    }
}
