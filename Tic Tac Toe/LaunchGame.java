import java.util.Scanner;

//anadir instrucciones
//anadir algo para salir del juego
//anadir algo para cuando el input no sean 0, 1, 2
//anadir algo tipo not valid move cuando la casilla este ocupada o este fuera del tablero







public class LaunchGame {
    public static void main(String[] args){
        TicTacToe t = new TicTacToe();
        HumanPlayer p1=new HumanPlayer("Player 1", 'X');
        AIPlayer p2=new AIPlayer("AI", 'O');
        HumanPlayer p3=new HumanPlayer("Player 2", 'O');
        Player cp;
        cp=p1;
        //Add instructions
        System.out.println("Welcome to the Tic Tac Toe game!");

        boolean more = true;
        while (more){
            System.out.print("Press I for instructions, 1 for one player mode, 2 for two player mode and Q to quit: ");
            Scanner in = new Scanner (System.in);
            String command = (in.nextLine()).toUpperCase();
            if(command.equals("I")){
                System.out.println("\n\n");
                System.out.println("The goal is to place three of your marks in a row (vertically, horizontally or diagonally). \n" + //
                        "When selected a mode to play press enter to start the turn. Then, if it is a human player,  \n" + //
                                "the user should introduce the row and column they want to place the mark in");
                System.out.println("\n\n");
            }
            else if (command.equals("1")){
                t.displayInitialBoard();
                while(true){
                    System.out.print(cp.name+"'s turn");
                    in.nextLine();
                    cp.makeMove();
                    t.displayBoard();
                    System.out.println("\n");
                    if(TicTacToe.checkColWin()||TicTacToe.checkRowWin()||TicTacToe.checkDiagWin()){
                        System.out.println(cp.name+" has won");
                        break;
                    }
                    else if(TicTacToe.checkDraw()){
                        System.out.println("Game is a draw");
                        break;
                    }
                    else{
                        if(cp==p1){
                            cp=p2;
                        }
                        else{
                            cp=p1;
                        }
                    }
                }
            }
            else if(command.equals("2")){
                t.displayInitialBoard();
                while(true){
                    System.out.println(cp.name+"'s' turn");
                    cp.makeMove();
                    t.displayBoard();
                    System.out.println("\n");
                    if(TicTacToe.checkColWin()||TicTacToe.checkRowWin()||TicTacToe.checkDiagWin()){
                        System.out.println(cp.name+" has won");
                        break;
                    }
                    else if(TicTacToe.checkDraw()){
                        System.out.println("Game is a draw");
                        break;
                    }
                    else{
                        if(cp==p1){
                            cp=p3;
                        }
                        else{
                            cp=p1;
                        }
                    }
                }
            }
            else if(command.equals("Q")){
                System.out.println("Thank you for playing!");
                more=false;
            }
            
            
        }
    }
}