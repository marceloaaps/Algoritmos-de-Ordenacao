package com.entities.mediumHighQtt;

import java.util.ArrayList;

public class Heap {

    private ArrayList<Integer> list = new ArrayList<>();
    private long time;
    private int swaps;
    private int comparisons;

    public  Heap(){}

    public ArrayList<Integer> getList() {
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


}
