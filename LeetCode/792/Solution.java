/*
 * Author: Minho Kim (ISKU)
 * Date: November 8, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://leetcode.com/problems/number-of-matching-subsequences/
 */

class Solution {
    
    public int numMatchingSubseq(String S, String[] words) {
        List<Integer>[] letters = new ArrayList[26];
        for (int i = 0; i < 26; i++)
            letters[i] = new ArrayList<Integer>() {{ add(-1); }};
        for (int i = 0; i < S.length(); i++)
            letters[S.charAt(i) - 'a'].add(i);
        
        int answer = 0;
        for (String word : words) {
            boolean contains = true;
            int index = 0;
            
            for (int i = 0; i < word.length(); i++) {
                List<Integer> indexes = letters[word.charAt(i) - 'a'];
                int next = lowerBound(indexes, index);
                if (next == -1) {
                    contains = false;
                    break;
                }
                
                index = indexes.get(next) + 1;
            }
            
            if (contains)
                answer++;
        }
        
        return answer;
    }
    
    private int lowerBound(List<Integer> array, int target) {
        int l = 0;
        int r = array.size() - 1;
        
        while (l < r) {
            int mid = (l + r) / 2;
            
            if (array.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        
        return array.get(l) < target ? -1 : l;
    }
}
