package com.program;

import com.entities.Bubble;
import com.entities.FileProperties;
import com.entities.Insertion;
import com.entities.Selection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    static String path = "C:\\Users\\marce\\OneDrive\\Área de Trabalho\\Crescente100.txt";
    static String path2 = "C:\\Users\\marce\\OneDrive\\Área de Trabalho\\Crescente1000.txt";
    static String path3 = "C:\\Users\\marce\\OneDrive\\Área de Trabalho\\Crescente10000.txt";

    @Override
    public void start(Stage stage) throws IOException {

        ArrayList<String> paths = new ArrayList<>();
        paths.add("C:\\Users\\marce\\OneDrive\\Área de Trabalho\\Crescente100.txt");
        paths.add("C:\\Users\\marce\\OneDrive\\Área de Trabalho\\Crescente1000.txt");
        paths.add("C:\\Users\\marce\\OneDrive\\Área de Trabalho\\Crescente10000.txt");
        paths.add("C:\\Users\\marce\\OneDrive\\Área de Trabalho\\Decrescente100.txt");
        paths.add("C:\\Users\\marce\\OneDrive\\Área de Trabalho\\Decrescente1000.txt");
        paths.add("C:\\Users\\marce\\OneDrive\\Área de Trabalho\\Decrescente10000.txt");
        paths.add("C:\\Users\\marce\\OneDrive\\Área de Trabalho\\Des100.txt");
        paths.add("C:\\Users\\marce\\OneDrive\\Área de Trabalho\\Des1000.txt");
        paths.add("C:\\Users\\marce\\OneDrive\\Área de Trabalho\\Des10000.txt");


        ArrayList<Long> bubbleTimes = new ArrayList<>();
        ArrayList<Integer> bubbleSwap = new ArrayList<>();
        ArrayList<Integer> bubbleComparisons = new ArrayList<>();
        ArrayList<Long> insertionTimes = new ArrayList<>();
        ArrayList<Integer> insertionSwap = new ArrayList<>();
        ArrayList<Integer> insertionComparisons = new ArrayList<>();
        ArrayList<Long> selectionTimes = new ArrayList<>();
        ArrayList<Integer> selectionSwap = new ArrayList<>();
        ArrayList<Integer> selectionComparisons = new ArrayList<>();

        for (String path : paths) {
            Bubble bub = new Bubble();
            bub.bubbleSort(path);

            Insertion ins = new Insertion();
            ins.insertionSort(path);

            Selection sel = new Selection();
            sel.selectionSort(path);

            bubbleTimes.add(bub.getTime());
            bubbleSwap.add(bub.getSwaps());
            bubbleComparisons.add(bub.getComparisons());
            insertionTimes.add(ins.getTime());
            insertionSwap.add(ins.getSwap());
            insertionComparisons.add(ins.getComparisons());
            selectionTimes.add(sel.getTime());
            selectionSwap.add(sel.getSwap());
            selectionComparisons.add(sel.getComparisons());
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
            System.out.println("Bubble Trocas: " + bubbleSwap.get(i) + " - Bubble Comparacoes: " + bubbleComparisons.get(i) + " Tempo de Processamento (ms): " + bubbleTimes.get(i));
            System.out.println("Insertion Trocas: " + insertionSwap.get(i) + " - Insertion Comparacoes: " + insertionComparisons.get(i) + " Tempo de Processamento(ms): " + bubbleTimes.get(i));
            System.out.println("Selection Trocas: " + selectionSwap.get(i) + " - Selection Comparacoes: " + selectionComparisons.get(i) + "T empo de Processamento(ms): " + bubbleTimes.get(i));

            System.out.println();
        }

        stage.setTitle("LineChart");
        NumberAxis xAxis = new NumberAxis();
        CategoryAxis yAxis = new CategoryAxis();
        xAxis.setLabel("Tempo de processamento (ms)");
        yAxis.setLabel("Quantidade de valores ordenados");
        final LineChart<String, Number> lineChart = new LineChart<String, Number>(yAxis, xAxis);

        lineChart.setTitle("Métodos de Ordenação");

        String[] methodNames = {"Bubble", "Insertion", "Selection"};
        String[] dataTypes = {"Crescente", "Decrescente", "Desordenado"};

        for (String method : methodNames) {
            for (String dataType : dataTypes) {
                XYChart.Series series = new XYChart.Series();
                series.setName(method + " " + dataType);
                for (int i = 0; i < 3; i++) {
                    String dataSize = (i == 0) ? "100" : (i == 1) ? "1000" : "10000";
                    long time = 0;
                    if (method.equals("Bubble")) {
                        int index = (dataType.equals("Crescente")) ? i : ((dataType.equals("Decrescente")) ? i + 3 : i + 6);
                        time = bubbleTimes.get(index);
                    } else if (method.equals("Insertion")) {
                        int index = (dataType.equals("Crescente")) ? i : ((dataType.equals("Decrescente")) ? i + 3 : i + 6);
                        time = insertionTimes.get(index);
                    } else if (method.equals("Selection")) {
                        int index = (dataType.equals("Crescente")) ? i : ((dataType.equals("Decrescente")) ? i + 3 : i + 6);
                        time = selectionTimes.get(index);
                    }
                    series.getData().add(new XYChart.Data(dataSize, time));
                }
                lineChart.getData().add(series);
            }
        }

        Scene scene = new Scene(lineChart, 800, 600);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws IOException {

//        FileProperties fp = new FileProperties();
//        fp.fileWriterCresc(path, 100);
//        fp.fileWriterCresc(path2, 1000);
//        fp.fileWriterCresc(path3, 10000);
///
       launch(args);
    }
}
