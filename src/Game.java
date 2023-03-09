import java.util.*;

public class Game {
    public static void main(String[] args) throws Exception {
        int flag=0;
        Scanner sc = new Scanner(System.in);
        Board board = new Board();        
        board.createBoard();

        Ladder ladder = new Ladder();
        ladder.createLadders(board.getSize());

        Snake snake =  new Snake(ladder.getLadder());
        snake.createSnakes(board.getSize());
        
        System.out.print("Enter the number of players: ");
        int numPlayers = sc.nextInt();
        Player[] players = new Player[numPlayers];
        

        for(int i=0; i<players.length; i++){
            players[i] = new Player();
            players[i].createPlayer();
        }
        System.out.println("\n" + "-------------Game Started-------------" + "\n");
        do{
            for(int i=0; i<players.length; i++){
                int diceVal = players[i].rollDice();
                players[i].setPosition(players[i].getPosition()+diceVal);

                if(players[i].getPosition() == board.getSize()){
                    flag = 1;
                    System.out.println("\n" + players[i].getName() + " has won the game");
                    break;
                }
                else if(players[i].getPosition()>board.getSize()){
                    players[i].setPosition(players[i].getPosition()-diceVal);
                    System.out.println(" your position is: " + players[i].getPosition());
                }
                else{
                    System.out.println(" your position is: " + players[i].getPosition());
                }

                if(snake.checkSnake(players[i].getPosition())){
                    players[i].setPosition(snake.updatePosition(players[i].getPosition()));
                    System.out.println(players[i].getName() + " snake got you OOPS!!!  Your position now is: " + players[i].getPosition());
                }

                if(ladder.checkLadder(players[i].getPosition())){
                    players[i].setPosition(ladder.updatePosition(players[i].getPosition()));
                    System.out.println(players[i].getName() + " you got the ladder Hurrah!!!  Your position now is: " + players[i].getPosition());
                }
            }
            System.out.println();
            System.out.println("-----------------------------------" + "\n");
        }
        while(flag == 0);

        System.out.println("-------------Game Over-------------" + "\n");       
        sc.close();
    }
}
