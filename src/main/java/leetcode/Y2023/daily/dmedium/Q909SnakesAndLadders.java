package leetcode.Y2023.daily.dmedium;

import java.util.LinkedList;
import java.util.Queue;

public class Q909SnakesAndLadders {

    // Use Breadth First Search to solve finding Shortest Path
    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return -1;

        // Init ints to store default dimensions of the board
        int rows = board.length;
        int cols = board[0].length;
        int endPosition = rows * cols;

        // Init Queue to use for BFS
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);                                     // Add starting position of 1 to the queue

        boolean[] visited = new boolean[endPosition + 1];   // By default all values set to false, rows & cols starting at 1

        int moves = 0;

        // Breadth First Search to find shortest path
        while(!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                int curr = queue.poll();                 // Dequeue top element (curr position of the board)

                // If already visited the current space, check the next
                if (visited[curr])
                {
                    continue;
                }
                visited[curr] = true;

                if (curr == endPosition)
                {
                    return moves;
                }

                for (int dice = 1; (dice <= 6) && (curr + dice <= endPosition); dice++)
                {
                    int next = curr + dice;
                    int val = getCurBoardValue(board, next);

                    if (val > 0)
                    {
                        next = val;
                    }

                    if (!visited[next])
                    {
                        queue.offer(next);
                    }
                }
            }

            // Increment move count
            moves++;
        }

        return -1;
    }

    private int getCurBoardValue(int[][] board, int num) {
        int n = board.length;
        int lastRow = (num - 1) / n;
        int newRow = n - 1 - lastRow;
        int lastCol = (num - 1) % n;
        int newCol = lastRow % 2 == 0 ? lastCol : n - 1 - lastCol;

        return board[newRow][newCol];
    }
}
