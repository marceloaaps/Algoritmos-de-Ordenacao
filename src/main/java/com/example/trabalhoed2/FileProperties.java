package com.example.trabalhoed2;

import java.io.*;
import java.util.ArrayList;

public class FileProperties{


    private ArrayList<Integer> list = new ArrayList<>();
    private long time;

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

    public void fileWriterDeo(String path, int loopValue) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

        int max = 1000, min = 1;
        int range = max - min + 1;

        for (int i = 0; i < loopValue; i++) { // Alterar a condição caso queira mais valores
            int temp = (int) (Math.random() * range + min);
            String tempo = String.valueOf(temp);
            bw.write(tempo);
            bw.newLine();
        }
        bw.close();
    }

    public void fileWriterCresc(String path,  int loopValue) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

        for (int i = 0; i < loopValue; i++) {
            String tempo = String.valueOf(i);
            bw.write(tempo);
            bw.newLine();
        }
        bw.close();
    }

    public void fileWriterDec(String path,  int loopValue) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

        for (int i = loopValue; i >= 0; i--) {
            String tempo = String.valueOf(i);
            bw.write(tempo);
            bw.newLine();
        }
        bw.close();
    }

}
