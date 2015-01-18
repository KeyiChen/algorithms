public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        int head = 0, tail = s.length() - 1;
        
        while (head <= tail && s.charAt(head) == ' ') head++;
        if (head > tail) return false;
        while (head <= tail && s.charAt(tail) == ' ') tail--;
        if (s.charAt(head) == '+' || s.charAt(head) == '-') head++;
        
        boolean exp = false;
        boolean dot = false;
        boolean num = false;
        
        for (int i = head; i <= tail; i++)
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                num = true;
            else if (s.charAt(i) == 'e') {
                if (exp || !num) return false;
                exp = true;
                num = false;
            }
            else if (s.charAt(i) == '.') {
                if (dot || exp) return false;
                dot = true;
            } 
            else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (s.charAt(i - 1) != 'e') return false;
                num = false;
            } 
            else return false;
        
        return num;
    }
}
