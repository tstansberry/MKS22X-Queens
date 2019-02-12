public class QueenBoard {
  private int sum;

  public static void main(String[] args) {
    QueenBoard  board = new QueenBoard(8);
    System.out.println(board.countSolutions());
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
      for (int y: x) {
        if (y == -1) output += "Q ";
        else output += "_ ";
      }
      output = output.substring(0, output.length() - 1);
      output += "\n";
    }
    return output;
  }

  public boolean solve() {
    return solveHelper(0);
  }

  private boolean solveHelper(int c) {
    if (c >= board.length) return true;
    for (int r = 0; r < board.length; r ++) {
      if (addQueen(r, c)) {
        if (solveHelper(c + 1)) return true;
        removeQueen(r, c);
      }
    }
    return false;
  }


  public int countSolutions() {
    if (board.length == 0) return 0;
    if (board[0][0] != 0){
      throw new IllegalStateException();
    }
    solutionsHelper(0);
    return sum;
  }

  private void solutionsHelper(int r) {
    if (r >= board.length) sum ++;
    else{
      if (r < 0 ){
          throw new IllegalStateException("");
        }
        for (int c = 0; c < board.length; c ++){
            if (addQueen(r,c)){
                solutionsHelper(r + 1);
                removeQueen(r, c);
            }
        }
    }
}

  private boolean addQueen(int r, int c) {
    if (board[r][c] != 0 || r >= board.length || c >= board.length) return false;
    //Horizontal
    for (int x = 0; x < board[r].length; x ++) {
      board[r][x] = board[r][x] + 1;
    }
    //Diagonal up-right
    int x  = c + 1;
    int y = r - 1;
    while (x < board.length && y >= 0) {
      board[y][x]  = board[y][x] + 1;
      x ++;
      y --;
    }
    //Diagonal down-right
    x  = c + 1;
    y = r + 1;
    while (x < board.length && y < board.length) {
      board[y][x] = board[y][x] + 1;
      x ++;
      y ++;
    }
    //Diagonal up-left
    x  = c - 1;
    y = r - 1;
    while (x >= 0 && y >= 0) {
      board[y][x] = board[y][x] + 1;
      x --;
      y --;
    }
    //Diagonal down-left
    x  = c - 1;
    y = r + 1;
    while (x >= 0 && y < board.length) {
      board[y][x] = board[y][x] + 1;
      x --;
      y ++;
    }
    //Vertical
    for (int idx = 0; idx < board.length; idx ++) {
      board[idx][c] = board[idx][c] + 1;
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
    //Diagonal up-right
    int x  = c + 1;
    int y = r - 1;
    while (x < board.length && y >= 0) {
      board[y][x]  = board[y][x] - 1;
      x ++;
      y --;
    }
    //Diagonal down-right
    x  = c + 1;
    y = r + 1;
    while (x < board.length && y < board.length) {
      board[y][x] = board[y][x] - 1;
      x ++;
      y ++;
    }
    //Diagonal up-left
    x  = c - 1;
    y = r - 1;
    while (x >= 0 && y >= 0) {
      board[y][x] = board[y][x] - 1;
      x --;
      y --;
    }
    //Diagonal down-left
    x  = c - 1;
    y = r + 1;
    while (x >= 0 && y < board.length) {
      board[y][x] = board[y][x] - 1;
      x --;
      y ++;
    }
    //Vertical
    for (int idx = 0; idx < board.length; idx ++) {
      board[idx][c] = board[idx][c] - 1;
    }
    board[r][c] = 0;
    return true;
  }


}
