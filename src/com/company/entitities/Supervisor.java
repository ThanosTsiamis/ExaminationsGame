package com.company.entitities;

import static com.company.Main.professorsAttitudeEnum;

public class Supervisor {
    int row;
    int col;
    double awareness;

    public Supervisor() {
        this.awareness = professorsAttitudeEnum.ordinal() * 0.23 + 1;
    }

    public void moveSupervisor(int row, int col) {
        this.row = row;
        this.col = col;
    }

}
