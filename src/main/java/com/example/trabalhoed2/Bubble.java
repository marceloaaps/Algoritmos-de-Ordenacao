package com.example.trabalhoed2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bubble {

    protected ArrayList<Integer> list = new ArrayList<>();

    public Bubble() {
    }

    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public ArrayList<Integer> getList() {
        return list;
    }


    public void bubbleSort(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));

        String line;

        while ((line = br.readLine()) != null) {
            this.list.add(Integer.valueOf(line));
        }

        time = System.nanoTime();
        for (int i = list.size() - 1; i > 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    this.list.set(j, list.get(j + 1));
                    this.list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        time = System.nanoTime() - time;
        br.close();
    }

}
