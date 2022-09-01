## Leetcode 37. Sudoku Solver (Hard)
I can be honest initially matrix, or any form of 2d problems seems very
complicated for me usually. 
 
Trust me this question seems like ROCK CLIMB to me at first. After getting through  explanation 
of how to tackle this question,IT SEEMS WAYYYYYYY easier than it actually looks.

### Leetcode Question explanation

[`Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.
`]
<hr>
<img src="https://raw.githubusercontent.com/Fas96/T-images-repo/main/sudoku-solver.png">
<hr>

### Explanation
The above image, simple indicates given cells of a NxN size 
your goal is to fill the empty spots with numbers such that each number does not repeat 
in the COLUMN,ROW or CELL AREA (3*3)

### Tackle
With this specification given we need to make sure we have 
the three conditions check.


| case      | method            | explanation                                                        |
|-----------|-------------------|--------------------------------------------------------------------|
| row       | isNumInRow        | This method checks if our number to keep in this row is valid      |
| column    | isNumInColumn     | This also helps to check if we can place the number at that column |
| cell area | isNumInBox (3*3)  | Checks if we have this number to be places in any area of the cell |


### ROW CHECK

```java
private boolean isNumInRow(char[][] board,char number,int row){
    for (int i = 0; i < board.length; i++) {
      if(board[row][i]==number)return true;
    }
    return false;
  }
```
<br>

### COLUMN CHECK

<br>

```java

  private boolean isNumInColumn(char[][] board,char number,int col){
    for (int i = 0; i < board.length; i++) {
      if(board[i][col]==number)return true;
    }
    return false;
  }
```

<br>

### CELL AREA CHECK

```java
 private boolean isNumInBox(char[][] board,char number,int row,int col){
    int localRow=row-row%3;
    int localCol=col-col%3;
    for (int i = localRow; i < localRow+3; i++) {
      for (int j = localCol; j < localCol+3; j++) {
        if(board[i][j]==number)return true;
      }
    }
    return false;
  }
```
<hr>

### Valid if our check is all Valid

One other thing we cannot miss is to make sure all THESE ABOVE conditions are meet for any placement


| case                            | method            | explanation                                    |
|---------------------------------|-------------------|------------------------------------------------|
| current row and column of board | isValidPlacement  | Check all the conditions of cell , col and row |

<hr>


```java
private boolean isValidPlacement(char[][] board,char number,int row,int col){
    return !isNumInRow(board, number,row) &&
        !isNumInColumn( board, number, col)&&
      !isNumInBox(board,number,row,col);
  }
```

This definitely makes it easy to know if we are making the placement right. 
### ₪ Back Track

Well our placement could be right at that cell but what happens if the previous placement prevents the 
current placement validity? 🧐

Well so, in our solver we need to make sure we check this condition of being able to erase previous changes 
if it prevents current placement to be valid. This we can do with

```java
if(isValidPlacement(board,tryNum,i,j)){
              board[i][j]=  tryNum;
              if(solveSudoku(board,N)){
                return true;
              }else{
                board[i][j]='.';
              }
}
```

This implies if the current solved is not     `true` then reset to default cell value.

<hr>


### Recursion 
We do this repeatedly until we have all our board filled. We kept trying placement of numbers
and checking if the placement was valid.


```java
if (board[i][j] == '.'){
          for (char tryNum = '1'; tryNum <= '9'; tryNum++) {
            if(isValidPlacement(board,tryNum,i,j)){
              board[i][j]=  tryNum;
              if(solveSudoku(board,N)){
                return true;
              }else{
                board[i][j]='.';
              }
            }
          }
          return false;

        }
```


If all the placement is valid and all board is filled we can then return true indicating we actually did
the placement all right.
<br>

```java

class Solution {
    public void solveSudoku(char[][] board) {
       solveSudoku(board,board.length);
  }
  public boolean solveSudoku(char[][] board,int N) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == '.'){
          for (char tryNum = '1'; tryNum <= '9'; tryNum++) {
            if(isValidPlacement(board,tryNum,i,j)){
              board[i][j]=  tryNum;
              if(solveSudoku(board,N)){
                return true;
              }else{
                board[i][j]='.';
              }
            }
          }
          return false;

        }
      }
    }
    return true;
  }
}
```
<br>

[LeetCode Solution](https://leetcode.com/submissions/detail/781309764/)

### Summary
From the solution, we can see how easy just three conditions + just backtrack and recursions helps us
achieve the solution. I would say there are definitely  good ways to optimize this solution.
But as a beginner sometimes the logic behind the complexity could be little hard to comprehend
always choose the easy ways to understand concepts. 
