import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        boolean gameFinished = false;
        String gameStatus = "Player 1 turn";
        String winner = "";
        int move;

        Board board = new Board();
        Snakes snakes = new Snakes();
        Ladders ladders = new Ladders();
        Players players = new Players();

        snakes.initializeSnakePosition();
        ladders.initializeLadderPosition();
        players.initializePlayerOne();
        players.initializePlayerTwo();

        board.instruction();
        scanner.nextLine();
        board.printLine();

        while(!gameFinished){

            board.drawBoard(players, snakes, ladders);
            move = board.rollDice();

            System.out.println();
            if(gameStatus.equals("Player 1 turn")){

                System.out.println("Player 1 turn. Press Enter to roll the dice");
                gameStatus = "Player 2 turn";
                scanner.nextLine();

                System.out.println("Dice outcome: " + move);
                System.out.println(board.movePlayerOne(players, move, snakes, ladders));
                Thread.sleep(1000);

                if(players.playerOnePosition == 100){
                    winner = "Player 1";
                    gameFinished = true;
                }

            }
            else{

                System.out.println("Player 2 turn. Press Enter to roll the dice");
                gameStatus = "Player 1 turn";
                scanner.nextLine();

                System.out.println("Dice outcome: " + move);
                System.out.println(board.movePlayerTwo(players, move, snakes, ladders));
                Thread.sleep(1000);

                if(players.playerTwoPosition == 100){
                    winner = "Player 2";
                    gameFinished = true;
                }
            }
            //System.out.println(players.findPosition(10, 10));
            System.out.print("\033[H\033[2J");
            System.out.flush();

        }
        System.out.println();
        System.out.println("Game finished and winner is " + winner);


    }

}
