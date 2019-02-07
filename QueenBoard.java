public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size) {

  }

  public String toString() {
    
  }

  public boolean solve() {

  }

  public int countSolutions() {

  }

  private boolean addQueen(int r, int c) {
    if (board[r][c] > 0) return false;
    //Horizontal
    for (int x = 0; x < board[r].length; x ++) {
      board[r][x] = board[r][x] + 1;
    }
    //Diagonal positive
    for (int x = 1; x + r < board.length; x ++) {
      board[r + x][c + x] = board[r + x][c + x] + 1;
    }
    //Diagonal negative
    for (int x = 1; r - x >= 0; x ++) {
      board[r - x][c - x] = board[r - x][c - x] + 1;
    }
    //Vertical
    for (int x = 0; x < board.length; x ++) {
      board[x][c] = board[x][c] + 1;
    }
    board[r][c] = -1;
    return true;
  }

  private boolean removeQueen(int r, int c) {
    if (board[r][c] != -1) return false;
    //Horizontal
    for (int x = 0; x < board[r].length; x ++) {
      board[r][x] = board[r][x] - 1;
    }
    //Diagonal positive
    for (int x = 1; x + r < board.length; x ++) {
      board[r + x][c + x] = board[r + x][c + x] - 1;
    }
    //Diagonal negative
    for (int x = 1; r - x >= 0; x ++) {
      board[r - x][c - x] = board[r - x][c - x] - 1;
    }
    //Vertical
    for (int x = 0; x < board.length; x ++) {
      board[x][c] = board[x][c] - 1;
    }
    board[r][c] = 0;
    return true;
  }


}
