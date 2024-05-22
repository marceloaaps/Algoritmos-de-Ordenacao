package com.entities.mediumHighQtt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Quick {

    private List<Integer> list = new ArrayList<>();
    private long time;
    private int swaps;
    private int comparisons;

    public Quick() {}

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

    public void quickSort(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {
            this.list.add(Integer.valueOf(line));
        }
        br.close();

        Integer[] array = list.toArray(new Integer[0]);

        long startTime = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        long endTime = System.currentTimeMillis();

        this.time = endTime - startTime;

        list = new ArrayList<>(List.of(array));
    }

    private void quickSort(Integer[] array, int low, int high) {
        while (low < high) {
            if (high - low < 16) {
                insertionSort(array, low, high);
                break;
            } else {
                int pi = partition(array, low, high);

                if (pi - low < high - pi) {
                    quickSort(array, low, pi - 1);
                    low = pi + 1;
                } else {
                    quickSort(array, pi + 1, high);
                    high = pi - 1;
                }
            }
        }
    }

    private int partition(Integer[] array, int low, int high) {
        int pivot = medianOfThree(array, low, high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private int medianOfThree(Integer[] array, int low, int high) {
        int mid = low + (high - low) / 2;
        if (array[low] > array[mid]) {
            swap(array, low, mid);
        }
        if (array[low] > array[high]) {
            swap(array, low, high);
        }
        if (array[mid] > array[high]) {
            swap(array, mid, high);
        }
        swap(array, mid, high);
        return array[high];
    }

    private void insertionSort(Integer[] array, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= low && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
                comparisons++;
                swaps++;
            }
            array[j + 1] = key;
        }
    }

    private void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        swaps++;
    }


}
