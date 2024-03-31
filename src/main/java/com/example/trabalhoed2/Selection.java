package com.example.trabalhoed2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Selection {
    private ArrayList<Integer> list = new ArrayList<>();
    private Long time;
    private int count;

    public Selection() {
    }

    public Selection(ArrayList<Integer> list, Long time, int count) {
        this.list = list;
        this.time = time;
        this.count = count;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void selectionSort(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {
            this.list.add(Integer.valueOf(line));
        }

        time = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            int n = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(n)) {
                    n = j;
                }
            }

            int temp = list.get(n);
            list.set(n, list.get(i));
            list.set(i, temp);
        }
        time = System.currentTimeMillis() - time;
        br.close();
    }
}