public class Solution {
    public int atoi(String str) {
        int result  = 0;
        int coef = 1;
        int start = 0;
        while (start < str.length() && str.charAt(start) == ' ') start++;
        
        if (start < str.length() && (str.charAt(start) == '-' || str.charAt(start) == '+')) {
            coef = (str.charAt(start) == '-' ? -1 : 1);
            start++;
        }
        
        for (int i = start; i < str.length(); i++) 
            if ((str.charAt(i) <= '9' && str.charAt(i) >= '0')) {
                int new_result = result * 10 + coef * (str.charAt(i) - '0');
                
                if (result != 0 && new_result / result < 10) // check over flow
                    return (coef == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
                
                result = new_result;
            } else return result;
        
        return result;
    }
}
