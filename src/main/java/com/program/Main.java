package com.program;

import com.entities.Bubble;
import com.entities.FileProperties;
import com.entities.Insertion;
import com.entities.Selection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

//    static String path = "C:\\Users\\Marcelo\\Desktop\\Des100.txt";
//    static String path2 = "C:\\Users\\Marcelo\\Desktop\\Des1000.txt";
//    static String path3 = "C:\\Users\\Marcelo\\Desktop\\Des10000.txt";

    @Override
    public void start(Stage stage) throws IOException {

        ArrayList<String> paths = new ArrayList<>();
        ArrayList<List> arrayBubble = new ArrayList<>();
        paths.add("C:\\Users\\Marcelo\\Desktop\\Crescente100.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Crescente1000.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Crescente10000.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Decrescente100.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Decrescente1000.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Decrescente10000.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Desordenado100.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Desordenado1000.txt");
        paths.add("C:\\Users\\Marcelo\\Desktop\\Desordenado10000.txt");


        ArrayList<XYChart.Series> seriesList = new ArrayList<>();
        ArrayList<Integer> totalComparisons = new ArrayList<>();
        ArrayList<Integer> totalSwaps = new ArrayList<>();
        ArrayList<Long> bubbleTimes = new ArrayList<>();
        ArrayList<Integer> bubbleSwap = new ArrayList<>();
        ArrayList<Integer> bubbleComparisons = new ArrayList<>();
        ArrayList<Long> insertionTimes = new ArrayList<>();
        ArrayList<Integer> insertionSwap = new ArrayList<>();
        ArrayList<Integer> insertComparisons  = new ArrayList<>();
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
                insertComparisons.add(ins.getComparisons());
                selectionTimes.add(sel.getTime());
                selectionSwap.add(sel.getSwap());
                selectionComparisons.add(sel.getComparisons());
        }

        for (int i = 0; i<9; i++){
                if (i<3){
                    totalSwaps.set(i, bubbleSwap.get(i));
                    totalComparisons.set(i, bubbleComparisons.get(i));
                }

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
//        fp.fileWriterDeo(path, 100);
//        fp.fileWriterDeo(path2, 1000);
//        fp.fileWriterDeo(path3, 10000);

        launch(args);
    }


}
