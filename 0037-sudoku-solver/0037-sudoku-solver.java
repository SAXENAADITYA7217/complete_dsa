class Solution {
    public void solveSudoku(char[][] board) {
        sudokoslover(board,0,0);
        
    }
    public boolean sudokoslover(char [][] board, int row, int col){
        if(row==9){
            return true;
        }
        int nextrow = row;
        int nextcol = col+1;
        if(col+1==9){
            nextrow = row+1;
            nextcol = 0;
        }
        if(board[row][col]!='.'){
           return sudokoslover(board,nextrow,nextcol);
        }
        for(int digit = 1; digit<=9; digit++){
           char ch = (char) (digit + '0');
            if(issafe(board, row, col, ch )){
                board[row][col] = ch;
                if(sudokoslover(board,row,col)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    public boolean issafe(char [][] board, int row, int col, char digit){
        for(int i = 0; i<=8; i++){
            if(board[i][col]==digit){
                return false;
            }
        }
        for(int j = 0; j<=8; j++){
            if(board[row][j]==digit){
                return false;
            }
        }
        int startrow = (row/3)*3;
        int startcol = (col/3)*3;
        for(int i = startrow; i<startrow+3; i++){
            for(int j = startcol; j<startcol+3; j++){
                if(board[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
}