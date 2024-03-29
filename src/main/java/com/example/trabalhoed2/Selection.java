package com.example.trabalhoed2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Selection {
    private ArrayList<Integer> list = new ArrayList<>();
    private Long time;

    public void selectionSort(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {
            this.list.add(Integer.valueOf(line));
        }


    }
}
