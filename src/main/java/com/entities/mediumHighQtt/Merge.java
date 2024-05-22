package com.entities.mediumHighQtt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Merge {

    private List<Integer> list = new ArrayList<>();
    private long time;
    private int swaps;
    private int comparisons;

    public Merge() {}

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

    public void mergeSort(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {
            this.list.add(Integer.valueOf(line));
        }
        br.close();

        Integer[] array = list.toArray(new Integer[0]);

        long startTime = System.currentTimeMillis();
        mergeSort(array, 0, array.length - 1);
        long endTime = System.currentTimeMillis();

        this.time = endTime - startTime;

        list = new ArrayList<>(List.of(array));
    }

    private void mergeSort(Integer[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    private void merge(Integer[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Integer[] leftArray = new Integer[n1];
        Integer[] rightArray = new Integer[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            comparisons++;
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            swaps++;
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
            swaps++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
            swaps++;
        }
    }
}
