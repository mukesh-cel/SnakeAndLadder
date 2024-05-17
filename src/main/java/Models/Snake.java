package Models;

public class Snake {
    private Cell start_cell;
    private Cell end_Cell;

    public Snake(Cell start_cell, Cell end_Cell) {
        this.start_cell = start_cell;
        this.end_Cell = end_Cell;
    }

    public Cell getStart_cell() {
        return start_cell;
    }

    public void setStart_cell(Cell start_cell) {
        this.start_cell = start_cell;
    }

    public Cell getEnd_Cell() {
        return end_Cell;
    }

    public void setEnd_Cell(Cell end_Cell) {
        this.end_Cell = end_Cell;
    }
}
