public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if (S == null || L == null) return result;
        HashMap<String, Integer> freq = new HashMap<String, Integer>();
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        
        for (int i = 0; i < L.length; i++)
            if (freq.get(L[i]) == null)
                freq.put(L[i], 1);
            else
                freq.put(L[i], freq.get(L[i]) + 1);
        
        int len = L.length, gap = L[0].length();
        for (int i = 0; i < S.length() - len * gap + 1; i++) {
            count.clear();
            int j = 0;
            for (j = 0; j < len; j++) {
                int pos = i + j * gap;
                String token = S.substring(pos, pos + gap);
                if (freq.get(token) == null) break;
                if (count.get(token) == null)
                    count.put(token, 1);
                else
                    count.put(token, count.get(token) + 1);
                    
                if (count.get(token) > freq.get(token)) break;
            }
            if (j == len) result.add(i);
        }
        
        return result;
    }
        
}
