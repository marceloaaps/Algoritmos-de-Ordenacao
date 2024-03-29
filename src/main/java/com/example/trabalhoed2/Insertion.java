package com.example.trabalhoed2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Insertion {
    private ArrayList<Integer> list = new ArrayList<>();
    private long time;

    public Insertion() {
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void insertionSort(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {
            this.list.add(Integer.valueOf(line));
        }

        time = System.nanoTime();
        for (int i = 1; i < list.size(); i++) {

            int value = list.get(i);
            int j = i-1;
            while (j >= 0 &&  list.get(j) > value ){
                this.list.set(j + 1, list.get(j));
                j = j-1;
            }
            this.list.set(j + 1, value);
        }

        time = System.nanoTime() - time;
        br.close();
    }
}