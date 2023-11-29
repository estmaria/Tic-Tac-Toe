import java.util.InputMismatchException;
import java.util.Scanner;

class HumanPlayer extends Player{
    HumanPlayer(String name, char mark){
        this.name=name;
        this.mark=mark;
    }

    boolean isValidMove (int row, int col){
        if(row>=0 && row<=2 && col>=0 && col<=2){
            if(TicTacToe.board[row][col]==' '){
                return true;
            }
        }
        System.out.println("That position is alredy filled or is off the limits of the board. Try again!");
        return false;
    }
    
    void makeMove(){
        Scanner scan=new Scanner (System.in);
        int row,col;
        boolean validInput=false;
        while (!validInput){
            try{
                do{
                    System.out.print("Enter the row: ");
                    row=(scan.nextInt())-1;
                    System.out.print("Enter the column: ");
                    col=(scan.nextInt())-1;
                } while(!isValidMove(row,col));

                validInput=true;
                TicTacToe.placeMark(row,col,mark);
            }

            catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                scan.nextLine();
            }
        }
        
    }
    
}