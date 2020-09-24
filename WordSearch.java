// TC: n*m+m*n
// SC: O(1)

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        // TC: n*m
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    // TC: m*n
                    if(helper(board, i, j, 0, word))
                        return true;
                }
            }
        }
        return false;
    }
    int[][] directions = new int[][]{{0,-1}, {-1,0}, {0,1}, {1,0}};
    public boolean helper(char[][] grid, int i, int j, int index, String word){
        // make element from 1 -> 0
        if(index >= word.length()-1){
            return true;
        }
        char temp = grid[i][j];
        grid[i][j] = '@';
        for(int[] dir: directions){
            // move up, down, right left
            int r = dir[0]+i;
            int c = dir[1]+j;
            // System.out.println(r+","+c);
            // now check at new index if its one then recurse
            if(r>=0 && r< grid.length && c>=0 && c<grid[r].length && index+1 < word.length() && grid[r][c] == word.charAt(index+1)){
                if(helper(grid, r, c, index+1, word))
                    return true;
            }            
        }
        grid[i][j] = temp;
        return false;
    }
}