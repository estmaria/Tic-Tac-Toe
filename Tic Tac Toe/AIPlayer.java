import java.util.Random;

class AIPlayer extends Player{

    AIPlayer(String name, char mark){
        this.name=name;
        this.mark=mark;
    }

    boolean isValidMove (int row, int col){
        if(row>=0 && row<=2 && col>=0 && col<=2){
            if(TicTacToe.board[row][col]==' '){
                return true;
            }
        }
        return false;
    }

    void makeMove(){
        
        int row,col;
        do{
            Random r=new Random();
            row=r.nextInt(3);
            col=r.nextInt(3);
        } while(!isValidMove(row,col));
        
        TicTacToe.placeMark(row,col,mark);
    }
}
