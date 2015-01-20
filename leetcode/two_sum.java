public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (set.get(target - numbers[i]) != null) {
                result[0] = set.get(target - numbers[i]) + 1;
                result[1] = i + 1;
                break;
            }
            set.put(numbers[i], i);
        }
        
        return result;
    }
}
