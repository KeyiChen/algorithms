public class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        for (int i = 5; n >= i; i *= 5) {
            result += n / i;
            if (Integer.MAX_VALUE / i < 5) break;
        }
        return result;
    }
}
