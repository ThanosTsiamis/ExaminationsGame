package com;

import java.io.File;
import java.io.IOException;

public class MonteCarloSimulation {
    public static void main(String[] args) throws IOException {
        File file = new File("Results.xlsx");
        if (!file.exists()) {
            CreateExcel.main(args);
        }
        for (int i = 0; i < 500; i++) {
            Main.main(args);
            System.out.println(i); //progress bar purposes
        }
    }
}
