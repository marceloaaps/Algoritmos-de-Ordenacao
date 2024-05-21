package com.entities.lowQtt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Insertion {
    private ArrayList<Integer> list = new ArrayList<>();
    private long time;
    private int swaps;
    private int comparisons;

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

    public int getSwap() {
        return swaps;
    }

    public void setSwap(int swaps) {
        this.swaps = swaps;
    }

    public int getComparisons() {
        return comparisons;
    }

    public void setComparisons(int comparisons) {
        this.comparisons = comparisons;
    }

    public void insertionSort(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {
            this.list.add(Integer.valueOf(line));
        }

        time = System.currentTimeMillis();
        for (int i = 1; i < list.size(); i++) {
            int value = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j) > value) {
                this.list.set(j + 1, list.get(j));
                j = j - 1;
                this.swaps++;
                this.comparisons++;
            }
            if (j >= 0) {
                this.comparisons++;
            }
            this.list.set(j + 1, value);
        }

        time = System.currentTimeMillis() - time;
        br.close();
    }
}