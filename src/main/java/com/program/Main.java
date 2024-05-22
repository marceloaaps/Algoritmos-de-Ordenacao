package com.program;

import com.entities.mediumHighQtt.Heap;
import com.entities.mediumHighQtt.Merge;
import com.entities.mediumHighQtt.Quick;
import com.properties.FileProperties;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {

//    static String path = "C:\\Users\\Marcelo\\Desktop\\Desordenado1000.txt";
//    static String path2 = "C:\\Users\\Marcelo\\Desktop\\Desordenado10000.txt";
//    static String path3 = "C:\\Users\\Marcelo\\Desktop\\Desordenado100000.txt";

    @Override
    public void start(Stage stage) throws IOException {

        ArrayList<String> paths = new ArrayList<>();
        paths.add("C:\\Users\\Marcelo\\Desktop\\Crescente1000.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Crescente10000.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Crescente100000.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Decrescente1000.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Decrescente10000.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Decrescente100000.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Desordenado1000.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Desordenado10000.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Desordenado100000.txt");

        ArrayList<Long> bubbleTimes = new ArrayList<>();
        ArrayList<Integer> bubbleSwap = new ArrayList<>();
        ArrayList<Integer> bubbleComparisons = new ArrayList<>();
        ArrayList<Long> insertionTimes = new ArrayList<>();
        ArrayList<Integer> insertionSwap = new ArrayList<>();
        ArrayList<Integer> insertionComparisons = new ArrayList<>();
        ArrayList<Long> selectionTimes = new ArrayList<>();
        ArrayList<Integer> selectionSwap = new ArrayList<>();
        ArrayList<Integer> selectionComparisons = new ArrayList<>();

        ArrayList<Long> quickTimes = new ArrayList<>();
        ArrayList<Integer> quickSwap = new ArrayList<>();
        ArrayList<Integer> quickComparisons = new ArrayList<>();
        ArrayList<Long> mergeTimes = new ArrayList<>();
        ArrayList<Integer> mergeSwap = new ArrayList<>();
        ArrayList<Integer> mergeComparisons = new ArrayList<>();
        ArrayList<Long> heapTimes = new ArrayList<>();
        ArrayList<Integer> heapSwap = new ArrayList<>();
        ArrayList<Integer> heapComparisons = new ArrayList<>();

//        for (String path : paths) {
//            Bubble bub = new Bubble();
//            bub.bubbleSort(path);
//
//            Insertion ins = new Insertion();
//            ins.insertionSort(path);
//
//            Selection sel = new Selection();
//            sel.selectionSort(path);
//
//            bubbleTimes.add(bub.getTime());
//            bubbleSwap.add(bub.getSwaps());
//            bubbleComparisons.add(bub.getComparisons());
//            insertionTimes.add(ins.getTime());
//            insertionSwap.add(ins.getSwap());
//            insertionComparisons.add(ins.getComparisons());
//            selectionTimes.add(sel.getTime());
//            selectionSwap.add(sel.getSwap());
//            selectionComparisons.add(sel.getComparisons());
//        }

        for (String path : paths){
            Quick quick = new Quick();
            quick.quickSort(path);
            quickTimes.add(quick.getTime());
            quickComparisons.add(quick.getComparisons());
            quickSwap.add(quick.getComparisons());

            Merge merge = new Merge();
            merge.mergeSort(path);
            mergeTimes.add(merge.getTime());
            mergeComparisons.add(merge.getComparisons());
            mergeSwap.add(merge.getSwaps());

            Heap heap = new Heap();
            heap.heapSort(path);
            heapTimes.add(heap.getTime());
            heapComparisons.add(heap.getComparisons());
            heapSwap.add(heap.getSwaps());

        }

        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                System.out.println("Crescente 100");
            }
            if (i == 1) {
                System.out.println("Crescente 1000");
            }
            if (i == 2) {
                System.out.println("Crescente 10000");
            }
            if (i == 3) {
                System.out.println("Decrescente 100");
            }
            if (i == 4) {
                System.out.println("Decrescente 1000");
            }
            if (i == 5) {
                System.out.println("Decrescente 10000");
            }
            if (i == 6) {
                System.out.println("Desordenado 100");
            }
            if (i == 7) {
                System.out.println("Desordenado 1000");
            }
            if (i == 8) {
                System.out.println("Desordenado 10000");
            }

            System.out.println("Quick Trocas: " + quickSwap.get(i) + " - Merge Comparacoes: " + quickComparisons.get(i) + "Tempo de processamento(ms) " + quickTimes.get(i));
            System.out.println("Merge Trocas: " + mergeSwap.get(i) + " - Merge Comparacoes: " + mergeComparisons.get(i) + "Tempo de processamento(ms) " + mergeTimes.get(i));
            System.out.println("Heap Trocas: " + heapSwap.get(i) + " - Heap Comparacoes: " + heapComparisons.get(i) + "Tempo de processamento(ms) " + heapTimes.get(i));
//            System.out.println("Bubble Trocas: " + bubbleSwap.get(i) + " - Bubble Comparacoes: " + bubbleComparisons.get(i) + " Tempo de Processamento (ms): " + bubbleTimes.get(i));
//            System.out.println("Insertion Trocas: " + insertionSwap.get(i) + " - Insertion Comparacoes: " + insertionComparisons.get(i) + " Tempo de Processamento(ms): " + bubbleTimes.get(i));
//            System.out.println("Selection Trocas: " + selectionSwap.get(i) + " - Selection Comparacoes: " + selectionComparisons.get(i) + " Tempo de Processamento(ms): " + bubbleTimes.get(i));

            System.out.println();
        }

        stage.setTitle("LineChart");
        NumberAxis xAxis = new NumberAxis();
        CategoryAxis yAxis = new CategoryAxis();
        xAxis.setLabel("Tempo de processamento (ms)");
        yAxis.setLabel("Quantidade de valores ordenados");
        final LineChart<String, Number> lineChart = new LineChart<String, Number>(yAxis, xAxis);

        lineChart.setTitle("Métodos de Ordenação");

        String[] methodNames = {"Quick", "Merge", "Heap"};
        String[] dataTypes = {"Crescente", "Decrescente", "Desordenado"};

        for (String method : methodNames) {
            for (String dataType : dataTypes) {
                XYChart.Series series = new XYChart.Series();
                series.setName(method + " " + dataType);
                for (int i = 0; i < 3; i++) {
                    String dataSize = (i == 0) ? "100" : (i == 1) ? "1000" : "10000";
                    long time = 0;
                    if (method.equals("Quick")) {
                        int index = (dataType.equals("Crescente")) ? i : ((dataType.equals("Decrescente")) ? i + 3 : i + 6);
                        time = quickTimes.get(index);
                    } else if (method.equals("Merge")) {
                        int index = (dataType.equals("Crescente")) ? i : ((dataType.equals("Decrescente")) ? i + 3 : i + 6);
                        time = mergeTimes.get(index);
                    } else if (method.equals("Heap")) {
                        int index = (dataType.equals("Crescente")) ? i : ((dataType.equals("Decrescente")) ? i + 3 : i + 6);
                        time = heapTimes.get(index);
                    }
                    series.getData().add(new XYChart.Data(dataSize, time));
                }
                lineChart.getData().add(series);
            }
        }

//        for (String method : methodNames) {
//            for (String dataType : dataTypes) {
//                XYChart.Series series = new XYChart.Series();
//                series.setName(method + " " + dataType);
//                for (int i = 0; i < 3; i++) {
//                    String dataSize = (i == 0) ? "100" : (i == 1) ? "1000" : "10000";
//                    long time = 0;
//                    if (method.equals("Bubble")) {
//                        int index = (dataType.equals("Crescente")) ? i : ((dataType.equals("Decrescente")) ? i + 3 : i + 6);
//                        time = bubbleTimes.get(index);
//                    } else if (method.equals("Insertion")) {
//                        int index = (dataType.equals("Crescente")) ? i : ((dataType.equals("Decrescente")) ? i + 3 : i + 6);
//                        time = insertionTimes.get(index);
//                    } else if (method.equals("Selection")) {
//                        int index = (dataType.equals("Crescente")) ? i : ((dataType.equals("Decrescente")) ? i + 3 : i + 6);
//                        time = selectionTimes.get(index);
//                    }
//                    series.getData().add(new XYChart.Data(dataSize, time));
//                }
//                lineChart.getData().add(series);
//            }
//        }

        Scene scene = new Scene(lineChart, 800, 600);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws IOException {

//        Tirar os comentários abaixo se for utilizar a criação de arquivos.

//        FileProperties fp = new FileProperties();
//        fp.fileWriterCresc(path, 1000);
//        fp.fileWriterCresc(path2, 10000);
//        fp.fileWriterCresc(path3, 100000);
//        fp.fileWriterDec(path, 1000);
//        fp.fileWriterDec(path2, 10000);
//        fp.fileWriterDec(path3, 100000);
//        fp.fileWriterDeo(path, 1000);
//        fp.fileWriterDeo(path2, 10000);
//        fp.fileWriterDeo(path3, 100000);

        launch(args);
        System.out.println("executado");
    }
}
