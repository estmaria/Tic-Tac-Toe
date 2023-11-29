abstract class Player{
    String name;
    char mark;

    abstract void makeMove();
    
    abstract boolean isValidMove (int row, int col);
    
    
}