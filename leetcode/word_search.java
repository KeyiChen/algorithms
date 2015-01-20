public class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
              if (search(board, i, j, 0, word, new boolean[board.length][board[i].length], vector) == true) return true;
        
        return false;
    }
    
    private boolean search(char[][] board, int i, int j, int depth, String word, boolean[][] hash, int[][] vector) {
        if (board[i][j] != word.charAt(depth)) return false;
        if (depth == word.length() - 1) return true;
        hash[i][j] = true;
        
        for (int k = 0; k < vector.length; k++) {
            int next_i = i + vector[k][0];
            int next_j = j + vector[k][1];
            if (next_i >= 0 && next_i < hash.length && next_j >= 0 && next_j < hash[0].length && !hash[next_i][next_j])
                if (search(board, next_i, next_j, depth + 1, word, hash, vector)) return true;
        }
        
        hash[i][j] = false;
        return false;
    }
}
