public class Solution {
    public void solve(char[][] board) {
        assert(board != null);
        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][0] == 'O') makeLabel(i, 0, board);
            if (board[i][board[i].length - 1] == 'O') makeLabel(i, board[i].length - 1, board);
        }
        
        if (board.length > 0)
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') makeLabel(0, i, board);
            if (board[board.length - 1][i] == 'O') makeLabel(board.length - 1, i, board);
        }
        
        for (int i = 0; i < board.length; i ++)
            for (int j = 0; j < board[i].length; j ++)
                if (board[i][j] == '.') 
                    board[i][j] = 'O';
                else if (board[i][j] == 'O') 
                    board[i][j] = 'X';
    }
    
    private static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void makeLabel(int i, int j, char[][] board) {
        int row = board.length;
        int col = board[i].length;
        assert(i >= 0 && i < row && j >= 0 && j < col && board != null);
        
        ArrayList<Integer> queue_i = new ArrayList<Integer>();
        ArrayList<Integer> queue_j = new ArrayList<Integer>();
        board[i][j] = '.';
        queue_i.add(i);
        queue_j.add(j);
        int head = 0;
        
        while (head < queue_i.size()) {
            int cur_i = queue_i.get(head);
            int cur_j = queue_j.get(head);
            for (int k = 0; k < vector.length; k++) {
                int new_i = cur_i + vector[k][0];
                int new_j = cur_j + vector[k][1];
                if (new_i >= 0 && new_i < row && new_j >= 0 && new_j < col && board[new_i][new_j] == 'O') {
                    queue_i.add(new_i);
                    queue_j.add(new_j);
                    board[new_i][new_j] = '.';
                }
            }
            head++;
        }
    }
}

