package com.company.entitities;

import static com.company.Main.professorsAttitudeEnum;

public class Supervisor {
    int row;
    int col;
    double awareness;

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Supervisor() {
        this.awareness = professorsAttitudeEnum.ordinal()*0.23+1;
    }

}
