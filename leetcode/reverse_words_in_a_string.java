public class Solution {
    public String reverseWords(String s) {
        StringBuffer result = new StringBuffer("");
        int head;
        int tail = s.length() - 1;
        
        while (tail >= 0) {
            while (tail >= 0 && s.charAt(tail) == ' ') tail--;
            head = tail - 1;
            while (head >= 0 && s.charAt(head) != ' ') head--;
            
            if (tail >= 0)
                result.append(' ').append(s.substring(head + 1, tail + 1));
            
            tail = head - 1;
        }
        
        if (result.length() > 0) result.deleteCharAt(0);
        
        return result.toString();
    }
}
