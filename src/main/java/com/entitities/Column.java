package com.entitities;

public class Column {
    final int row;
    final int col;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Column(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
