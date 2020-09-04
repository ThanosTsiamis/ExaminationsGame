package com.company.entitities;

public class Walkway {
    boolean columnExists;

    public Walkway(int row,int col) {
        //if they are in a right place then add a column
        if(col%2!=0 && row%9==0) {
            this.columnExists = true;
        }
    }
}
