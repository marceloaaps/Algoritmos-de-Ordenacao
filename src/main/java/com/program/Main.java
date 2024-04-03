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
        ArrayList<Long> bubbleTimes = new ArrayList<>();
        ArrayList<Long> insertionTimes = new ArrayList<>();
        ArrayList<Long> selectionTimes = new ArrayList<>();
        ArrayList<Integer> bubbleComparisons = new ArrayList<>();
        ArrayList<Integer> bubbleCount = new ArrayList<>();
        ArrayList<Integer> insertionCount = new ArrayList<>();
        ArrayList<Integer> selectionCount = new ArrayList<>();

        for (String path : paths) {

                Bubble bub = new Bubble();
                bub.bubbleSort(path);

                Insertion ins = new Insertion();
                ins.insertionSort(path);

                Selection sel = new Selection();
                sel.selectionSort(path);

                bubbleTimes.add(bub.getTime());
                bubbleCount.add(bub.getSwaps());
                bubbleComparisons .add(bub.getComparisons());
                insertionTimes.add(ins.getTime());
                insertionCount.add(ins.getCount());
                selectionTimes.add(sel.getTime());
                selectionCount.add(sel.getCount());
        }

        stage.setTitle("LineChart");
        NumberAxis xAxis = new NumberAxis();
        CategoryAxis yAxis = new CategoryAxis();
        xAxis.setLabel("Tempo de processamento (ms)");
        yAxis.setLabel("Quantidade de valores ordenados");
        final LineChart<String, Number> lineChart = new LineChart<String, Number>(yAxis, xAxis);

        lineChart.setTitle("Métodos de Ordenação");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Bubble Crescente");
        series1.getData().add(new XYChart.Data("100", bubbleTimes.get(0)));
        series1.getData().add(new XYChart.Data("1000", bubbleTimes.get(1)));
        series1.getData().add(new XYChart.Data("10000", bubbleTimes.get(2)));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Bubble Decrescente");
        series2.getData().add(new XYChart.Data("100", bubbleTimes.get(3)));
        series2.getData().add(new XYChart.Data("1000", bubbleTimes.get(4)));
        series2.getData().add(new XYChart.Data("10000", bubbleTimes.get(5)));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Bubble Desordenado");
        series3.getData().add(new XYChart.Data("100", bubbleTimes.get(6)));
        series3.getData().add(new XYChart.Data("1000", bubbleTimes.get(7)));
        series3.getData().add(new XYChart.Data("10000", bubbleTimes.get(8)));

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("Insertion Crescente");
        series4.getData().add(new XYChart.Data("100", insertionTimes.get(0)));
        series4.getData().add(new XYChart.Data("1000", insertionTimes.get(1)));
        series4.getData().add(new XYChart.Data("10000", insertionTimes.get(2)));

        XYChart.Series series5 = new XYChart.Series();
        series5.setName("Insertion Decrescente");
        series5.getData().add(new XYChart.Data("100", insertionTimes.get(3)));
        series5.getData().add(new XYChart.Data("1000", insertionTimes.get(4)));
        series5.getData().add(new XYChart.Data("10000", insertionTimes.get(5)));

        XYChart.Series series6 = new XYChart.Series();
        series6.setName("Insertion Desordenado");
        series6.getData().add(new XYChart.Data("100", insertionTimes.get(6)));
        series6.getData().add(new XYChart.Data("1000", insertionTimes.get(7)));
        series6.getData().add(new XYChart.Data("10000", insertionTimes.get(8)));


        XYChart.Series series7 = new XYChart.Series();
        series7.setName("Selection Crescente");
        series7.getData().add(new XYChart.Data("100", selectionTimes.get(0)));
        series7.getData().add(new XYChart.Data("1000", selectionTimes.get(1)));
        series7.getData().add(new XYChart.Data("10000", selectionTimes.get(2)));

        XYChart.Series series8 = new XYChart.Series();
        series8.setName("Selection Crescente");
        series8.getData().add(new XYChart.Data("100", selectionTimes.get(3)));
        series8.getData().add(new XYChart.Data("1000", selectionTimes.get(4)));
        series8.getData().add(new XYChart.Data("10000", selectionTimes.get(5)));

        XYChart.Series series9 = new XYChart.Series();
        series9.setName("Selection Crescente");
        series9.getData().add(new XYChart.Data("100", selectionTimes.get(6)));
        series9.getData().add(new XYChart.Data("1000", selectionTimes.get(7)));
        series9.getData().add(new XYChart.Data("10000", selectionTimes.get(8)));

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().addAll(series1, series2, series3, series4, series5, series6, series7, series8, series9);

        stage.setScene(scene);
        stage.show();

        System.out.println(bubbleCount.get(6));
        System.out.println(bubbleComparisons.get(6));

    }

    public static void main(String[] args) throws IOException {

//        FileProperties fp = new FileProperties();
//        fp.fileWriterDeo(path, 100);
//        fp.fileWriterDeo(path2, 1000);
//        fp.fileWriterDeo(path3, 10000);

        launch(args);
    }


}
