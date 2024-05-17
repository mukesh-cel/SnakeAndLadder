import Controller.GameController;
import Models.*;

import java.util.*;

public class main {
    public static void main(String[] args) {
        GameController gameController= new GameController();
        int n=5;

        Queue<Player> players= new LinkedList<>();
        players.add(new Player("Mukesh",'X'));
        players.add(new Player("Karthi",'Y'));

        List<Snake> snakes= new ArrayList<>();
        snakes.add(new Snake(new Cell(3,0),new Cell(1,0)));
       // snakes.add(new Snake(new Cell(3,1),new Cell(0,1)));
        snakes.add(new Snake(new Cell(3,2),new Cell(1,2)));
        //snakes.add(new Snake(new Cell(3,3),new Cell(0,3)));
        snakes.add(new Snake(new Cell(3,4),new Cell(1,4)));

        List<Ladder> ladders= new ArrayList<>();

        ladders.add(new Ladder(new Cell(2,0 ),new Cell(0,0)));
        ladders.add(new Ladder(new Cell(2,1),new Cell(1,1)));
        ladders.add(new Ladder(new Cell(2,2),new Cell(0,2)));
        ladders.add(new Ladder(new Cell(4,3),new Cell(1,3)));
        ladders.add(new Ladder(new Cell(4,4),new Cell(0,4)));

        int dice=1;
        Game game= gameController.startgame(n,players,snakes,ladders,dice);

        while (game.getGameStatus()==GameStatus.In_Progress){
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter 1 to printboard");
            int i=scn.nextInt();
            if (i==1){
                gameController.displayBoard(game);
            }
            gameController.makemove(game);

        }
    }
}
