package Models;

import java.util.Scanner;

public class Player {
    private int Id;
    private String name;
    private char symbol;
    private Cell positon;
    public Player( String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.positon=new Cell(0,-1);
    }

    public Cell getPositon() {
        return positon;
    }

    public void setPositon(Cell positon) {
        this.positon = positon;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
