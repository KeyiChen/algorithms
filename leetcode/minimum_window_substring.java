public class Solution {
    public String minWindow(String S, String T) {
        String result = "";
        
        if (S.length() >= T.length()) {
            int start = 0;
            int end = 0;
            int[] freq = new int[256];
            int[] count = new int[256];
            int size = 0;
            
            for (int i = 0; i < T.length(); i++) freq[(int)T.charAt(i)]++;
            
            while (end < S.length()) {
                count[S.charAt(end)]++;
                
                if (freq[S.charAt(end)] > 0) {
                    if (count[S.charAt(end)] <= freq[S.charAt(end)]) size += 1;
                    if (size == T.length()) {
                        while (count[S.charAt(start)] > freq[S.charAt(start)]) {
                            count[S.charAt(start)] -= 1;
                            start ++;
                        }
                        
                        if (result.equals("") || end - start + 1 < result.length())
                            result = S.substring(start, end + 1);
                    }
                }
                
                end ++;
            }
        }
        
        return result;
    }
}
