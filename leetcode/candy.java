public class Solution {
    public int candy(int[] ratings) {
        int result = 0;
        if (ratings.length == 0) return result;

        int[] num = new int[ratings.length];
        
        num[0] = 1;
        for (int i = 1; i < ratings.length; i++)
            if (ratings[i] > ratings[i - 1])
                num[i] = num[i - 1] + 1;
            else 
                num[i] = 1;
        
        result  = num[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                num[i] = Math.max(num[i], num[i + 1] + 1);
            result += num[i];
        }
        
        return result;
    }
}
