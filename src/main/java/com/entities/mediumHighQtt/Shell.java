package com.entities.mediumHighQtt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Shell {

    private List<Integer> list = new ArrayList<>();
    private long time;
    private int swaps;
    private int comparisons;

    public Shell() {}

    public List<Integer> getList() {
        return list;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getSwaps() {
        return swaps;
    }

    public void setSwaps(int swaps) {
        this.swaps = swaps;
    }

    public int getComparisons() {
        return comparisons;
    }

    public void setComparisons(int comparisons) {
        this.comparisons = comparisons;
    }

    public void shellSort(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {
            this.list.add(Integer.valueOf(line));
        }
        br.close();

        Integer[] array = list.toArray(new Integer[0]);

        long startTime = System.currentTimeMillis();
        shellSort(array);
        long endTime = System.currentTimeMillis();

        this.time = endTime - startTime;

        list = new ArrayList<>(List.of(array));
    }

    private void shellSort(Integer[] array) {
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    comparisons++;
                    array[j] = array[j - gap];
                    swaps++;
                }
                comparisons++;
                array[j] = temp;
                if (i != j) {
                    swaps++;
                }
            }
        }
    }
}