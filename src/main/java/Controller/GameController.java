package Controller;

import Models.*;

import java.util.List;
import java.util.Queue;

public class GameController {
    public Game startgame(int n, Queue<Player> players, List<Snake> snake, List<Ladder> ladder, int dice){
        Game game= new Game(n,players,snake,ladder,dice);
        return game;
    }
    public void displayBoard(Game game){
        game.displayBoard(game);
    }
    public void makemove(Game game){
        game.makemove(game);
    }
}
