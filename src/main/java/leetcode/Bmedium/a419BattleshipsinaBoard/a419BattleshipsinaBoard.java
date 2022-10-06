package leetcode.Bmedium.a419BattleshipsinaBoard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class a419BattleshipsinaBoard {
    @Test
    public void testSol(){
        char[][] board={{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        assertEquals(2, countBattleships(board));
    }

    public int countBattleships(char[][] board) {
        int ans=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='X'){
                    if(i>0&&board[i-1][j]=='X')continue;
                    if(j>0&&board[i][j-1]=='X')continue;
                    ans++;
                }
            }
        }
        return ans;
    }
}
