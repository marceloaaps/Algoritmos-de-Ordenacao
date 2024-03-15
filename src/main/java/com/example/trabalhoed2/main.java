package com.example.trabalhoed2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class main{
    public static void main(String[] args) throws IOException {

        launch(args);

//        FileProperties fp = new FileProperties();
//        fp.fileWriter();
    }
    @Override
    public void start(Stage stage) throws IOException {

        FileProperties fp = new FileProperties();
        fp.fileReader();
        ArrayList<Integer> list = fp.getList();
        long time5f = fp.getTime();

        int[] arrayLarge = new int[100], arrayLarger = new int[1000], arrayLargest = new int[10000];
        int max = 1000, min = 1;
        int range = max - min + 1;

        Arrays.fill(arrayLarge, 0);
        Arrays.fill(arrayLarger, 0);
        Arrays.fill(arrayLargest, 0);
        ArrayList<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            if (arrayLarge[99] == 0) {
                arrayLarge[i] = (int) (Math.random() * range) + min;
            }
            if (arrayLarger[999] == 0) {
                arrayLarger[i] = (int) (Math.random() * range) + min;
            }
            if (arrayLargest[9999] == 0) {
                arrayLargest[i] = (int) (Math.random() * range) + min;
            }
            int temp = (int) (Math.random() * range) + min;
            list1.add(temp);
        }

        long time1f = 0, time2f = 0, time3f = 0, time4f = 0;

        for (int i = arrayLargest.length - 1; i > 0; i--) {
            boolean swap = false;

            long time1 = System.nanoTime();
            for (int j = 0; j < arrayLarge.length - 1; j++) {
                if (arrayLarge[j] > arrayLarge[j + 1]) {
                    int temp = arrayLarge[j];
                    arrayLarge[j] = arrayLarge[j + 1];
                    arrayLarge[j + 1] = temp;
                }
            }
            time1f = System.nanoTime() - time1;

            long time2 = System.nanoTime();
            for (int j = 0; j < arrayLarger.length - 1; j++) {
                if (arrayLarger[j] > arrayLarger[j + 1]) {
                    int temp = arrayLarger[j];
                    arrayLarger[j] = arrayLarger[j + 1];
                    arrayLarger[j + 1] = temp;
                }
            }
            time2f = System.nanoTime() - time2;

            long time3 = System.nanoTime();
            for (int j = 0; j < arrayLargest.length - 1; j++) {
                if (arrayLargest[j] > arrayLargest[j + 1]) {
                    int temp = arrayLargest[j];
                    arrayLargest[j] = arrayLargest[j + 1];
                    arrayLargest[j + 1] = temp;
                    swap = true;
                }
            }
            time3f = System.nanoTime() - time3;

            long time4 = System.nanoTime();
            for (int j = 0; j < list1.size() - 1; j++) {
                if (list1.get(j) > list1.get(j + 1)) {
                    int temp = list1.get(j);
                    list1.set(j, list1.get(j + 1));
                    list1.set(j + 1, temp);
                    swap = true;
                }
            }
            time4f = System.nanoTime() - time4;

            if (!swap) {
                System.out.println("Processamento finalizado!");
                System.out.println("--------------------------------------------");
                System.out.println("Array de 100: " + Arrays.toString(arrayLarge) + "\nTempo de processamento: " + (time1f));
                System.out.println(" ");
                System.out.println("--------------------------------------------");
                System.out.println("Array de 1000: " + Arrays.toString(arrayLarger) + "\n Tempo de processamento: " + (time2f));
                System.out.println(" ");
                System.out.println("--------------------------------------------");
                System.out.println("Array de 10000: " + Arrays.toString(arrayLargest) + "\nTempo de processamento: " + (time3f));
                System.out.println("--------------------------------------------");
                System.out.println("Lista de 10000: " + Arrays.toString(list1.toArray()) + "\nTempo de processamento: " + (time4f));
                System.out.println(" ");
                System.out.println("--------------------------------------------");
                System.out.println("Arquivo em Disco de 10000: " + Arrays.toString(list.toArray()) + "\nTempo de processamento: " + (time5f));
                break;
            }
        }

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Tamanho do Array");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Tempo de Processamento (Nanosegundos)");

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Tempos de Processamento");
        series1.getData().add(new XYChart.Data("Array 100", time1f));
        series1.getData().add(new XYChart.Data("Array 1000", time2f));
        series1.getData().add(new XYChart.Data("Array 10000", time3f));
        series1.getData().add(new XYChart.Data("Lista", time4f));
        series1.getData().add(new XYChart.Data("Arquivo em Disco", time5f));

        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.getData().add(series1);

        Scene scene = new Scene(lineChart, 500, 300);
        stage.setScene(scene);
        stage.show();
    }
}