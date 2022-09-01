package leetcode.Bmedium.a130SurroundedRegions;

public class a130SurroundedRegions {
  public void solve(char[][] board) {
    if(board.length == 0 || board[0].length == 0) return;
    for(int i = 0; i < board.length; i++){
      dfs(board, i, 0);
      dfs(board, i, board[0].length - 1);
    }
    for(int j = 1; j < board[0].length - 1; j++){
      dfs(board, 0, j);
      dfs(board, board.length - 1, j);
    }
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        if(board[i][j] == 'Y') board[i][j] = 'O';
        else board[i][j] = 'X';
      }
    }
  }
  public void dfs(char[][] board, int i, int j){
    if(board[i][j] == 'X' || board[i][j] == 'Y') return;
    board[i][j] = 'Y';
    if(i > 0 && board[i - 1][j] == 'O'){
      dfs(board, i - 1, j);
    }
    if(j > 0 && board[i][j - 1] == 'O'){
      dfs(board, i, j - 1);
    }
    if(i < board.length - 1 && board[i + 1][j] == 'O'){
      dfs(board, i + 1, j);
    }
    if(j < board[0].length - 1 && board[i][j + 1] == 'O'){
      dfs(board, i, j + 1);
    }
  }
}
