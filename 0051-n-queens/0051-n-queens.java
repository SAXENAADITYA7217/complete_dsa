class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        char chess[][] = new char[n][n];
        for(int i = 0; i<chess.length; i++){
            Arrays.fill(chess[i], '.');
        }
        solve(chess,0,ans);
        return ans;
    
    }
    public void solve(char chess[][], int row, List<List<String>> ans){
        if(row==chess.length){
            List<String> list = new ArrayList<>();
            for(int i = 0; i<chess.length; i++){
                StringBuilder str = new StringBuilder();
                for(int j = 0; j<chess.length; j++){
                    str.append(chess[i][j]);
                }
                list.add(str.toString());
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int col = 0; col<chess.length; col++){
            if(issafe(chess, row, col)){
                chess[row][col] = 'Q';
                solve(chess,row+1,ans);
                chess[row][col] = '.';
            }
        }
    }
    public boolean issafe(char chess[][], int row, int col){
        int i = row;
        int j = col;
        while(i>=0 && j>=0){
            if(chess[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }
        i = row;
        j = col;
        while(j<chess.length && i>=0){
            if(chess[i][j]=='Q'){
                return false;
            }
            i--;
            j++;
        }
        i = row;
        while(i>=0){
            if(chess[i][col]=='Q'){
                return false;
            }
            i--;
        }
        return true;

    }
}