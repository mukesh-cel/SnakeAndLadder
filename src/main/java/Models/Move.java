package Models;

import java.util.Date;
import java.util.Scanner;

public class Move {
    private Cell cell;
    private Player player;

    public Cell getCell() {
        return cell;
    }

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}
