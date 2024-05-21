package com.entities.lowQtt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bubble {

    private ArrayList<Integer> list = new ArrayList<>();
    private long time;
    private int swaps;
    private int comparisons;

    public Bubble() {
    }

    public Bubble(ArrayList<Integer> list, long time, int swaps, int comparisons) {
        this.list = list;
        this.time = time;
        this.swaps = swaps;
        this.comparisons = comparisons;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public int getSwaps() {
        return swaps;
    }

    public void setSwaps(int count) {
        this.swaps = count;
    }

    public int getComparisons() {
        return comparisons;
    }

    public void setComparisons(int comparisons) {
        this.comparisons = comparisons;
    }

    public void bubbleSort(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));

        String line;

        while ((line = br.readLine()) != null) {
            this.list.add(Integer.valueOf(line));
        }

        time = System.currentTimeMillis();
        for (int i = list.size() - 1; i > 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                this.comparisons++;
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    this.list.set(j, list.get(j + 1));
                    this.list.set(j + 1, temp);
                    swapped = true;
                    this.swaps++;
                }
            }
            if (!swapped) {
                break;
            }
        }
        time = System.currentTimeMillis() - time;
        br.close();
    }

}
