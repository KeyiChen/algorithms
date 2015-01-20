public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        dict.add(start);
        dict.add(end);
        HashMap<String, HashSet<String>> map = buildMap(dict);
        
        return getMinSteps(start, end, map);
    }
    
    private HashMap<String, HashSet<String>> buildMap(Set<String> dict) {
        HashMap<String, HashSet<String>> result = new HashMap<String, HashSet<String>>();
        
        for (String word : dict) {
            if (result.get(word) == null)
                result.put(word, new HashSet<String>());
            char[] chars = word.toCharArray();

            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < 26; j++)
                    if (j != word.charAt(i) - 'a') {
                        chars[i] = (char)('a' + j);
                        String candidate = new String(chars);
                        if (dict.contains(candidate))
                            result.get(word).add(candidate);
                    }
                chars[i] = word.charAt(i);
            }
        }
        
        return result;
    }
    
    private int getMinSteps(String start, String end, HashMap<String, HashSet<String>> map) {
        int result = 0;
        ArrayList<String> queue = new ArrayList<String>();
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        queue.add(start);
        hash.put(start, 0);
        int head = 0;
        
        while (head < queue.size()) {
            String cur = queue.get(head);
            for (String word : map.get(cur)) 
                if (hash.get(word) == null) {
                    hash.put(word, hash.get(cur) + 1);
                    queue.add(word);
                    if (word.equals(end)) {
                        result = hash.get(word) + 1;
                        break;
                    }
                }
            
            head++;
        }
        
        return result;
    }
}
