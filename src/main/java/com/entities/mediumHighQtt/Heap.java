package com.entities.mediumHighQtt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Heap {

    private List<Integer> list = new ArrayList<>();
    private long time;
    private int swaps;
    private int comparisons;

    public Heap() {}

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

    public void heapSort(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {
            this.list.add(Integer.valueOf(line));
        }
        br.close();

        Integer[] array = list.toArray(new Integer[0]);

        long startTime = System.currentTimeMillis();
        heapSort(array);
        long endTime = System.currentTimeMillis();

        this.time = endTime - startTime;

        list = new ArrayList<>(List.of(array));
    }

    private void heapSort(Integer[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);

            heapify(array, i, 0);
        }
    }

    private void heapify(Integer[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        comparisons++;
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        comparisons++;
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);

            heapify(array, n, largest);
        }
    }

    private void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        swaps++;
    }
}
