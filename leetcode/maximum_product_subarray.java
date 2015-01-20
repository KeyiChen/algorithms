public class Solution {
    public int maxProduct(int[] A) {
        int result = A[0], max_ending_here = A[0], min_ending_here = A[0];
        
        for (int i = 1; i < A.length; i ++) {
            int t = max_ending_here;
            max_ending_here = Math.max(A[i], Math.max(min_ending_here * A[i], max_ending_here * A[i]));
            min_ending_here = Math.min(A[i], Math.min(min_ending_here * A[i], t * A[i]));
            result = Math.max(result, max_ending_here);
        }
        
        return result;
    }
}
