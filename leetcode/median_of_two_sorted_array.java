public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        //assert A,B != null
        int lena = A.length;
        int lenb = B.length;
        int len = lena + lenb;
        double result;
        
        if ((len & 0x1) == 0)
            result = (getKthNumber(A, 0, lena - 1, B, 0, lenb - 1, len/2) + getKthNumber(A, 0, lena - 1, B, 0, lenb - 1, len/2 + 1) ) / 2.0;
        else
            result = getKthNumber(A, 0, lena - 1, B, 0, lenb - 1, len/2 + 1);
        
        return result;
    }
    
    private double getKthNumber(int[] a, int heada, int taila, int[] b, int headb, int tailb, int k) {
        if (taila - heada > tailb - headb)
            return getKthNumber(b, headb, tailb, a, heada, taila, k);
        if (taila < heada)
            return b[headb + k - 1];
        if (k == 1)
            return Math.min(a[heada], b[headb]);
        
        int mida = Math.min(k / 2, taila - heada + 1); int midb = k - mida;
        
        if (a[heada + mida - 1] < b[headb + midb - 1])
            return getKthNumber(a, heada + mida, taila, b, headb, tailb, midb);
        if (a[heada + mida - 1] > b[headb + midb - 1])
            return getKthNumber(a, heada, taila, b, headb + midb, tailb, mida);
        else 
            return a[heada + mida - 1];
    }
}
