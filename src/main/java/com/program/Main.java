package com.program;

import com.entities.Bubble;
import com.entities.Insertion;
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
        Bubble bub = new Bubble();
        Insertion ins = new Insertion();

        ArrayList<Integer> listCresc, listDec, listDeo, listCrescIns, listDecIns, listDeoIns;
        ArrayList<ArrayList<Integer>> bubbleList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> insertList = new ArrayList<>();

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

        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        ModuleLayer.Controller controller = loader.getController();
        Scene scene = new Scene(root);

        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.setScene(scene);

        controller.setStage(primaryStage);
        primaryStage.show();
    }

}