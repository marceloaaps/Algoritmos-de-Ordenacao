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

public class Main extends Application {

    static String path = "C:\\Users\\Marcelo\\Desktop\\textodec.txt";
    static String path2 = "C:\\Users\\Marcelo\\Desktop\\textocresc.txt";

    public static void main(String[] args){

        FileProperties fp = new FileProperties();
//        fp.fileWriterCresc(path, 10000);
//        fp.fileWriterDec(path, 10000);
//        fp.fileWriterDeo(path, 10000);

        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        Bubble bub = new Bubble();

        ArrayList<Integer> listCresc = new ArrayList<>();
        ArrayList<Integer> listDec = new ArrayList<>();

        bub.bubbleReader(path);
        listCresc = bub.getList();
        long timeCresc = bub.getTime();

        bub.bubbleReader(path2);
        listDec = bub.getList();
        long timeDec = bub.getTime();

        ArrayList<Integer> list = bub.getList();

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Tamanho do Array");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Tempo de Processamento (Nanosegundos)");
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Tempos de Processamento");
        series1.getData().add(new XYChart.Data("10000 Crescente", timeCresc));
        series1.getData().add(new XYChart.Data("10000 Decrescente", timeDec));

        System.out.println(listCresc);
        System.out.println(listDec);

        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.getData().add(series1);

        Scene scene = new Scene(lineChart, 500, 300);
        stage.setScene(scene);
        stage.show();
    }
}