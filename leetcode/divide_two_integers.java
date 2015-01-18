public class Solution {
    public int divide(int dividend, int divisor) {
        // check if (divisor == 0) 
        
        boolean negative = ((dividend ^ divisor) >>> 31) == 1;
        int result = 0;
        if (divisor == Integer.MIN_VALUE)
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
            result = 1;
            dividend += (divisor > 0 ? divisor : -divisor);
        }
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (dividend >= divisor) 
            for (int i = divisor, j = 1; i <= dividend; i <<= 1, j <<= 1) {
                result += j;
                dividend -= i;
                if (Integer.MAX_VALUE / i < 2) break;
            }
        
        return (negative ? -result : result);
    }
}
