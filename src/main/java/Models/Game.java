package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private Board board;
    private Queue<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private List<Snake> snake;
    private List<Ladder> ladder;
    private int nextmoveplayerindex;
    private Dice dice;
    public Game(int n, Queue<Player> players, List<Snake> snake, List<Ladder> ladder, int dice) {
        this.board = new Board(n);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameStatus = GameStatus.In_Progress;
        this.snake = snake;
        this.ladder = ladder;
        this.nextmoveplayerindex=0;
        this.dice=new Dice(dice);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Queue<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Snake> getSnake() {
        return snake;
    }

    public void setSnake(List<Snake> snake) {
        this.snake = snake;
    }

    public List<Ladder> getLadder() {
        return ladder;
    }

    public void setLadder(List<Ladder> ladder) {
        this.ladder = ladder;
    }

    public int getNextmoveplayerindex() {
        return nextmoveplayerindex;
    }

    public void setNextmoveplayerindex(int nextmoveplayerindex) {
        this.nextmoveplayerindex = nextmoveplayerindex;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void displayBoard(Game game){
        board.displayboard(game);
    }

    public boolean checkmovepossible(Board board, int newcol){
        if(((newcol/board.getSize())>board.getSize()-1)
                || ((newcol%board.getSize())>board.getSize()-1)){
            System.out.println("move not possible");
            return false;
        }
        return true;
    }
    public boolean checkwin(Board board,Cell cell, int newcol){
        int row=cell.getRow();
        int col= cell.getCol();
        if ((((newcol/board.getSize())==board.getSize()-1)
                &&  ((newcol%board.getSize())==board.getSize()-1))) {

            return true;
        } else if (row== board.getSize()-1 && col== board.getSize()-1) {

            return true;
        }
        return false;
    }
    public Cell checkforladderandsnake(Board board,int newcol,List<Ladder> ladder,List<Snake> snakes){
        int row=newcol/board.getSize();
        int col=newcol%board.getSize();
        for(Ladder l: ladder){
            int lerow=l.getEnd_Cell().getRow();
            int lecol=l.getEnd_Cell().getCol();

            int lsrow=l.getStart_cell().getRow();
            int lscol=l.getStart_cell().getCol();
            if(lerow==row && lecol==col){
               System.out.println("you are taken up in ladder to " + lsrow + " " + lscol);
                Cell cell=board.getBoard().get(lsrow).get(lscol);
                return  cell;
            }
        }
        for(Snake s: snakes){
            int serow=s.getEnd_Cell().getRow();
            int secol=s.getEnd_Cell().getCol();

            int ssrow=s.getStart_cell().getRow();
            int sscol=s.getStart_cell().getCol();
            if(ssrow==row && sscol==col){
                System.out.println("you are bitten by snake you r moved down to " + serow + " " + secol);
                Cell cell=board.getBoard().get(serow).get(secol);
                return  cell;
            }
        }
        Cell cell=board.getBoard().get(newcol/board.getSize()).get(newcol%board.getSize());
        return cell;
    }
    /*public Cell checkforsnake(Board board,int newcol,List<Snake> snakes){
        int row=newcol/board.getSize();
        int col=newcol%board.getSize();
        for(Snake s: snakes){
            int serow=s.getEnd_Cell().getRow();
            int secol=s.getEnd_Cell().getCol();
            //System.out.println(lerow + " " + lecol + " " + row + " "+ col);
            int ssrow=s.getStart_cell().getRow();
            int sscol=s.getStart_cell().getCol();
            if(ssrow==row && sscol==col){
                System.out.println("you are bitten by snake you r moved down to " + serow + " " + secol);
                Cell cell=board.getBoard().get(serow).get(secol);
                return  cell;
            }
        }
        Cell cell=board.getBoard().get(newcol/board.getSize()).get(newcol%board.getSize());
        return cell;
    }*/
    public void makemove(Game game){
        Player currentplayer= players.remove();
        Scanner scn= new Scanner(System.in);
        System.out.println("Enter 1 to Roll the Dice");
        int dicenumber=0;
        int i=scn.nextInt();
        if (i==1){
            dicenumber=dice.rollDice();
            System.out.println(currentplayer.getName() +" has got " + dicenumber);
        }
        int currrow=currentplayer.getPositon().getRow();
        int currcol=currentplayer.getPositon().getCol();
        int newcol=(currrow*board.getSize()+currcol)+dicenumber;

        System.out.println("row: "+newcol/board.getSize()+ " col:" +newcol%board.getSize());

        if(!checkmovepossible(board,newcol)){
            players.add(currentplayer);
            return;
        }
        if(checkwin(board,new Cell(currrow,currcol),newcol)){
            System.out.println(currentplayer.getName() + "has won the game");
            return;
        }
        Cell newcell= checkforladderandsnake(board,newcol,ladder,snake);


        if(checkwin(board,newcell,newcol)){
            System.out.println(currentplayer.getName() + "has won the game");
            return;
        }

        if(currcol!=-1) {     // so that previous symbol is not printed in output only new postion is printed
            Cell currcel = board.getBoard().get(currrow).get(currcol);
            currcel.setCellStatus(CellStatus.Free);
        }

        newcell.setCellStatus(CellStatus.Filled);  //change cell status filled

        Queue<Player> players1=newcell.getPlayer();  // add player
        players1.add(currentplayer);
        newcell.setPlayer(players1);

        currentplayer.setPositon(newcell);      // set player position
        Move move= new Move(newcell,currentplayer);
        moves.add(move);

        players.add(currentplayer);

    }
}
