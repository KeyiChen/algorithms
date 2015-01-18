import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private HashMap<String, HashSet<String>> map;
    private int min_steps;
    private List<List<String>> results;
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        assert(dict != null && start != null && end != null && start.length() == end.length() && !start.equals(end));
        dict.add(start);
        dict.add(end);
        
        map = buildGraph(dict);
        results = getResults(start, end, map);
        
        return results;
    }
    
    private HashMap<String, HashSet<String>> buildGraph(Set<String> dict) {
        HashMap<String, HashSet<String>> graph = new HashMap<String, HashSet<String>>();
        for (String word : dict) {
            if (graph.get(word) == null)
                graph.put(word, new HashSet<String>());
            
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                for (int j = 0; j < 26; j++)
                    if (c - 'a' != j) {
                        chars[i] = (char)('a' + j);
                        String new_word = new String(chars);
                        if (dict.contains(new_word))
                            graph.get(word).add(new_word);
                    }
                chars[i] = c;
            }
        }
        
        return graph;
    }
    
    private List<List<String>> getResults(String start, String end, HashMap<String, HashSet<String>> map) {
        List<List<String>> result = new ArrayList<List<String>>();
        min_steps = Integer.MAX_VALUE;
        
        ArrayList<String> queue = new ArrayList<String>();
        ArrayList<Integer> preceding = new ArrayList<Integer>();
        HashMap<String, Integer> limits = new HashMap<String, Integer>();
        
        queue.add(start);
        preceding.add(-1);
        limits.put(start, 0);
        int head = 0;
        while (head < queue.size()) {
            String cur = queue.get(head);
            for (String next : map.get(cur))
                if (limits.get(next) == null || (limits.get(next) == limits.get(cur) + 1 && limits.get(next) <= min_steps)) {
                    limits.put(next, limits.get(cur) + 1);
                    queue.add(next);
                    preceding.add(head);
                    
                    if (next.equals(end)) {
                        min_steps = limits.get(next);
                        result.add(traceBack(queue.size() - 1, preceding, queue));
                    }
                }
            head++;
        }
        
        return result;
    }
    
    private List<String> traceBack(int index, ArrayList<Integer> preceding, ArrayList<String> queue) {
        List<String> result = new LinkedList<String>();
        while (index != -1) {
            result.add(0, queue.get(index));
            index = preceding.get(index);
        }
        return result;
    }
}
