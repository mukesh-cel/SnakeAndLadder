package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int n){
        this.size=n;
        this.board=new ArrayList<>();

        for(int i=0;i<n;i++){
            board.add(new ArrayList<>());
            for(int j=0;j<n;j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void displayboard(Game game){
        int n=game.getBoard().getSize();
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                Cell cell=board.get(i).get(j);
                if(cell.getCellStatus()==CellStatus.Filled) {
                    Queue<Player> players = cell.getPlayer();
                    for (Player p : players) {
                        System.out.print("| " + p.getSymbol()+"|");
                    }
                } else if (cell.getCellStatus()==CellStatus.Free) {
                    System.out.print("| " + " |");
                }
            }
            System.out.println();
        }
    }
}
