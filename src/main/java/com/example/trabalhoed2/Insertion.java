package com.example.trabalhoed2;

import java.util.ArrayList;

public class Insertion {
    private ArrayList<Integer> list = new ArrayList<>();
    private Integer time;

    public Insertion() {
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public void insertionSort() {
        for (int i = 0; i < list.size() + 1; i++) {

            int value = list.get(i);

            while (value > 0 && value > list.get(i - 1)) {
                value = list.get(i-1);
                list.set(i-1, value);
                list.set(i, value);
            }
        }
    }
}