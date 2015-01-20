public class Solution {
    public int minCut(String s) {
        int result = 0;
        if (s.length() > 1) {
            boolean[][] isPalindrome = getPalindrome(s);
            result = getMinCut(isPalindrome);
        }
        return result;
    }
    
    private boolean[][] getPalindrome(String s) {
        boolean[][] result = new boolean[s.length()][s.length()];
        for (int i = 1; i <= s.length(); i++)
            for (int j = 0; j <= s.length() - i; j++) 
                if (i <= 2) result[j][j + i - 1] = s.charAt(j + i - 1) == s.charAt(j);
                else 
                    result[j][j + i - 1] = (s.charAt(j + i - 1) == s.charAt(j) && result[j + 1][j + i - 2]);

        return result;
    }
    
    private int getMinCut(boolean[][] isPalindrome) {
        int[] f = new int[isPalindrome.length];

        for (int i = 1; i < isPalindrome.length; i++) 
            if (isPalindrome[0][i]) f[i] = 0;
            else {
                f[i] = i;
                for (int j = 1; j <= i; j++)
                    if (isPalindrome[j][i])
                        f[i] = Math.min(f[i], f[j - 1] + 1);
            }
            
        return f[isPalindrome.length - 1];
    }
}
