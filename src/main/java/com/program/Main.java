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

    static String path = "C:\\Users\\Marcelo\\Desktop\\texto1.txt";
    static String path2 = "C:\\Users\\Marcelo\\Desktop\\texto2.txt";
    static String path3 = "C:\\Users\\Marcelo\\Desktop\\texto3.txt";

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
        series1.setName("BubbleCresc");
        series1.getData().add(new XYChart.Data("10000", timeCrescBub));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("BubbleDec");
        series2.getData().add(new XYChart.Data("10000", timeDecBub));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("BubbleDeo");
        series3.getData().add(new XYChart.Data("10000", timeDeoBub));

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("InsertionCresc");
        series4.getData().add(new XYChart.Data("10000", timeCrescIns));

        XYChart.Series series5 = new XYChart.Series();
        series5.setName("InsertionDec");
        series5.getData().add(new XYChart.Data("10000", timeDecIns));

        XYChart.Series series6 = new XYChart.Series();
        series6.setName("InsertionDec");
        series6.getData().add(new XYChart.Data("10000", timeDeoIns));

        XYChart.Series series7 = new XYChart.Series();
        series7.setName("SelectionCresc");
        series7.getData().add(new XYChart.Data("100", timeCrescSel));

        XYChart.Series series8 = new XYChart.Series();
        series8.setName("SelectionDec");
        series8.getData().add(new XYChart.Data("1000", timeDecSel));

        XYChart.Series series9 = new XYChart.Series();
        series9.setName("SelectionDeo");
        series9.getData().add(new XYChart.Data("10000", timeDeoSel));

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().addAll(series1, series2, series3, series4, series5, series6, series7, series8, series9);

        stage.setScene(scene);
        stage.show();
    }
}
