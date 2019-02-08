public class QueenBoard {
  public static void main(String[] args) {
    QueenBoard  board = new QueenBoard(8);
    System.out.println(board.toString());
    board.addQueen(0,0);
    System.out.println(board.toString());
    board.addQueen(3,6);
    System.out.println(board.toString());
    board.removeQueen(0,0);
    System.out.println(board.toString());
  }

  private int[][] board;

  public QueenBoard(int size) {
    board = new int[size][size];
    for (int[] x: board) {
      for (int y: x) {
        y = 0;
      }
    }

  }

  public String toString() {
    String output = "";
    for (int[] x: board) {
      output += "[";
      for (int y: x) {
        if (y == -1) output += "Q, ";
        else output += y + ", ";
      }
      output = output.substring(0, output.length() - 2);
      output += "]\n";
    }
    return output;
  }
/*
  public boolean solve() {

  }

  public int countSolutions() {

  }
*/
  private boolean addQueen(int r, int c) {
    if (board[r][c] != 0) return false;
    //Horizontal
    for (int x = 0; x < board[r].length; x ++) {
      board[r][x] = board[r][x] + 1;
    }
    //Diagonal positive
    int diff1 = Math.abs(r - c);
    int diffX = c - diff1;
    int diffY = r - diff1;
    if (diffX < 0) diffX = 0;
    if (diffY < 0) diffX = 0;
    for (int x = 0; c - diff1 + x < board[r].length && r + diff1 - x >= 0; x ++) {
      board[r + diff1 - x][c - diff1 + x] = board[r + diff1 - x][c - diff1 + x] + 1;
    }
    //Diagonal negative
    for (int x = 0; diffX + x < board[r].length && diffY + x >= 0; x ++) {
      board[diffY + x][diffX + x] = board[diffY + x][diffX + x] + 1;
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
    int diff1 = Math.abs(r - c);
    int diffX = c - diff1;
    int diffY = r - diff1;
    if (diffX < 0) diffX = 0;
    if (diffY < 0) diffX = 0;
    for (int x = 0; c - diff1 + x < board[r].length && r + diff1 - x >= 0; x ++) {
      board[r + diff1 - x][c - diff1 + x] = board[r + diff1 - x][c - diff1 + x] - 1;
    }
    //Diagonal negative
    for (int x = 0; diffX + x < board[r].length && diffY + x >= 0; x ++) {
      board[diffY + x][diffX + x] = board[diffY + x][diffX + x] - 1;
    }
    //Vertical
    for (int x = 0; x < board.length; x ++) {
      board[x][c] = board[x][c] - 1;
    }
    board[r][c] = 0;
    return true;
  }


}
