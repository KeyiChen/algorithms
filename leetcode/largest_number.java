public class Solution {
    public String largestNumber(int[] num) {
        qsort(num, 0, num.length - 1);
        if (num[0] == 0) return "0";
        
        StringBuffer result = new StringBuffer("");
        for (int i = 0; i < num.length; i++) result.append(num[i]);

        return result.toString();
    }
    
    private void qsort(int[] num, int head, int tail) {
        int pivot = num[(head + tail) >>> 1];
        int start = head, end = tail;
        
        while (start <= end) {
            while (start <= end && cmp(num[start], pivot) == 1) start++;
            while (start <= end && cmp(num[end], pivot) == -1) end--;
            if (start <= end) {
                int t = num[start];
                num[start] = num[end];
                num[end] = t;
                start++;
                end--;
            }
        }
        
        if (start < tail) qsort(num, start, tail);
        if (end > head) qsort(num, head, end);
    }
    
    private int cmp(int i1, int i2) {
        if (i1 != i2) {
            String s1 = Integer.toString(i1) + Integer.toString(i2);
            String s2 = Integer.toString(i2) + Integer.toString(i1);
            
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) > s2.charAt(i)) return 1;
                if (s1.charAt(i) < s2.charAt(i)) return -1;
            }
        }
        return 0;
    }
}
