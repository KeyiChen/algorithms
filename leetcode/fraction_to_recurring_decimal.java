public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuffer result = new StringBuffer("");
        long num = numerator;
        long den = denominator;
        if (num * den != 0 && ((num >>> 63) ^ (den >>> 63)) == 1) result.append('-');
        result.append(Math.abs(num / den));
        num = num % den;
        
        if (num != 0) {
            result.append('.');
            HashMap<Long, Integer> occurence = new HashMap<Long, Integer>();
            num *= 10;
            occurence.put(num, result.length());
            
            while (true) {
                result.append(Math.abs(num / den));
                num = (num % den) * 10;
                if (num == 0) break;
                if (occurence.get(num) != null) {
                    result.insert(occurence.get(num), "(");
                    result.append(')');
                    break;
                } else 
                    occurence.put(num, result.length());
            }
        }
        
        return result.toString();
    }
}

