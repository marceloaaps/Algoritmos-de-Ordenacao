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

public class Main extends Application {

    static String path = "C:\\Users\\marce\\OneDrive\\Área de Trabalho\\texto1.txt";
    static String path2 = "C:\\Users\\marce\\OneDrive\\Área de Trabalho\\texto2.txt";
    static String path3 = "C:\\Users\\marce\\OneDrive\\Área de Trabalho\\texto3.txt";
    public static void main(String[] args) throws IOException {

//        FileProperties fp = new FileProperties();
//        fp.fileWriterCresc(path, 10000);
//        fp.fileWriterDec(path2, 10000);
//        fp.fileWriterDeo(path3, 10000);

        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        Bubble bub = new Bubble();
        Insertion ins = new Insertion();

        ArrayList<Integer> listCresc, listDec, listDeo, listCrescIns, listDecIns, listDeoIns;
        ArrayList<ArrayList<Integer>> bubbleList = new ArrayList<>();

        bub.bubbleSort(path);
        listCresc = bub.getList();
        bubbleList.add(listCresc);
        long timeCresc = bub.getTime();

        bub.bubbleSort(path2);
        listDec = bub.getList();
        bubbleList.add(listDec);
        long timeDec = bub.getTime();

        bub.bubbleSort(path3);
        listDeo = bub.getList();
        bubbleList.add(listDeo);
        long timeRandom = bub.getTime();

        //------------------------//

        long timeCrescIns = 0;
        long timeDecIns = 0;
        long timeDeoIns = 0;

        for (int i = 0; i<=10; i++){
            ins.insertionSort(path);
            timeCrescIns = ins.getTime();

            ins.insertionSort(path2);
            timeDecIns = ins.getTime();

            ins.insertionSort(path3);
            timeDeoIns += ins.getTime();
        }

        long timeTotal = timeCrescIns / 10;
        long timeTotal2 = timeDecIns / 10;
        long timeTotal3 = timeDeoIns / 10;

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Tamanho do Array");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Tempo de Processamento (Nano9)");
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Tempos de Processamento");
        series1.getData().add(new XYChart.Data("Bubble Crescente", timeCresc));
        series1.getData().add(new XYChart.Data("Bubble Decrescente", timeDec));
        series1.getData().add(new XYChart.Data("Bubble Randomico", timeRandom));
        series1.getData().add(new XYChart.Data("Insert Crescente", timeTotal));
        series1.getData().add(new XYChart.Data("Insert Decrescente", timeTotal2));
        series1.getData().add(new XYChart.Data("Insert Randomico", timeTotal3));

        System.out.println(timeTotal);
        System.out.println(timeTotal2);
        System.out.println(timeTotal3);

        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.getData().add(series1);

        Scene scene = new Scene(lineChart, 500, 300);
        stage.setScene(scene);
        stage.show();
    }
}