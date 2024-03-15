package com.example.trabalhoed2;

import java.io.*;
import java.util.ArrayList;

public class FileProperties {


    protected ArrayList<Integer> list = new ArrayList<>();
    private long time;
    private String path = "C:\\Users\\marce\\OneDrive\\Área de Trabalho\\texto.txt";

    public long getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public FileProperties() {
    }

    public void fileReader() throws IOException {


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

    public void fileWriter() throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

        int max = 1000, min = 1;
        int range = max - min + 1;

        for (int i = 0; i < 1000; i++) {
            int temp = (int) (Math.random() * range + min);
            String tempo = String.valueOf(temp);
            bw.write(tempo);
            bw.newLine();
        }
        bw.close();

    }
}
