package com.program;

import com.entities.Bubble;
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
        Selection sel = new Selection();

        ArrayList<Integer> listCresc, listDec, listDeo, listCrescIns, listDecIns, listDeoIns, listDecSel, listCrescDel, listDeoSel;
        ArrayList<ArrayList<Integer>> bubbleList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> insertList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> selectionList = new ArrayList<>();

        bub.bubbleSort(path);
        listCresc = bub.getList();
        bubbleList.add(listCresc);
        long timeCrescBub = bub.getTime();

        bub.bubbleSort(path2);
        listDec = bub.getList();
        bubbleList.add(listDec);
        long timeDecBub = bub.getTime();

        bub.bubbleSort(path3);
        listDeo = bub.getList();
        bubbleList.add(listDeo);
        long timeDeoBub = bub.getTime();

        //------------------------//

        ins.insertionSort(path);
        listCrescIns = ins.getList();
        insertList.add(listCresc);
        long timeCrescIns = ins.getTime();

        ins.insertionSort(path2);
        listDecIns = ins.getList();
        insertList.add(listDecIns);
        long timeDecIns = ins.getTime();

        ins.insertionSort(path3);
        listDeoIns = ins.getList();
        insertList.add(listDeoIns);
        long timeDeoIns = ins.getTime();

        //------------------------//

        sel.selectionSort(path);
        listCrescDel = sel.getList();
        selectionList.add(listCrescDel);
        long timeCrescSel = sel.getTime();

        sel.selectionSort(path);
        listDecSel = sel.getList();
        selectionList.add(listDecSel);
        long timeDecSel = sel.getTime();

        sel.selectionSort(path);
        listDeoSel = sel.getList();
        selectionList.add(listDeoSel);
        long timeDeoSel = sel.getTime();

        stage.setTitle("Line Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Quantidade de valores ordenados");
        yAxis.setLabel("Tempo de Processamento (ms)");
        final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

        lineChart.setTitle("Métodos de Ordenação");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Bubble");
        series1.getData().add(new XYChart.Data("0", timeCrescBub));
        series1.getData().add(new XYChart.Data("10", timeDecBub));
        series1.getData().add(new XYChart.Data("100", timeDeoBub));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Insertion");
        series2.getData().add(new XYChart.Data("0", timeCrescIns));
        series2.getData().add(new XYChart.Data("10", timeDecIns));
        series2.getData().add(new XYChart.Data("100", timeDeoIns));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Selection");
        series3.getData().add(new XYChart.Data("0", timeDecSel));
        series3.getData().add(new XYChart.Data("10", timeDecSel));
        series3.getData().add(new XYChart.Data("100", timeDecSel));

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().addAll(series1, series2, series3);

        stage.setScene(scene);
        stage.show();
    }
}
