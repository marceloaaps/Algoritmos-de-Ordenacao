package com.example.trabalhoed2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

    public void insertionSort(String path) throws FileNotFoundException {


        BufferedReader br = new BufferedReader(new FileReader(path));

        String line;


        time = System.nanoTime();
        for (int i = 1; i < list.size(); i++) {

            int value = list.get(i);
            int j = i-1;
            while (j >= 0 &&  list.get(j) > value ){
                list.set(j + 1, list.get(j));
                j = j-1;
            }
            list.set(j + 1, value);
        }
        time = System.nanoTime() - time;
    }
}