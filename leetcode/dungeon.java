public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] power = new int[rows][cols];
        
        for (int i = rows - 1; i >= 0; i--)
            for (int j = cols - 1; j >= 0; j--)
                if (i == rows - 1 && j == cols - 1)
                    power[i][j] = Math.max(0, -dungeon[i][j]);
                else if (i == rows - 1)
                    power[i][j] = Math.max(0, power[i][j + 1] - dungeon[i][j]);
                else if (j == cols - 1)
                    power[i][j] = Math.max(0, power[i + 1][j] - dungeon[i][j]);
                else
                    power[i][j] = Math.max(0, Math.min(power[i + 1][j], power[i][j + 1]) - dungeon[i][j]);
        
        return power[0][0] + 1;
    }
}
