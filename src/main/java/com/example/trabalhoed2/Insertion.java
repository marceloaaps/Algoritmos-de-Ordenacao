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
        for (int i = 1; i < list.size(); i++) { // Percorre o array

            int value = list.get(i);
            int j = i-1;
            while (j >= 0 &&  list.get(j) > value ){ // Enquanto value for maior que o valor depois, ele percorre.
                list.set(j + 1, list.get(j));
                j = j-1;
            }
            list.set(j + 1, value);
        }
    }
}