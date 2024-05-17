package Models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cell {
    private int row;
    private int col;
    private CellStatus cellStatus;
    private Queue<Player> player;

    public Cell(int row, int col) {
        this.player=new LinkedList<>();
        this.row = row;
        this.col = col;
        this.cellStatus=CellStatus.Free;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public Queue<Player> getPlayer() {
        return player;
    }

    public void setPlayer(Queue<Player> player) {
        this.player = player;
    }
}
