package com.example.trabalhoed2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;

public class main extends Application {
    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        //Na hora que for fazer o arquivo, comentar o codigo de leitura, e na hora de fazer a leitura, comentar o codigo de escrita.
        //Se não seguir esses passos, vai dar erro pq o arquivo vai se reescrever com bugs e não achará nada.
        //Caminho para o arquivo em disco
//
//        String path = "E:\\Workspaces\\ws-java\\AulasFaculdade\\texto.txt";
//        String path2 = "E:\\Workspaces\\ws-java\\AulasFaculdade\\texto.txt";
//        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
//        BufferedReader br = new BufferedReader(new FileReader(path2));

        int[] arrayLarge = new int[100], arrayLarger = new int[1000], arrayLargest = new int[10000];
        int max = 1000, min = 1;
        int range = max - min + 1;

        Arrays.fill(arrayLarge, 0);
        Arrays.fill(arrayLarger, 0);
        Arrays.fill(arrayLargest, 0);

//
//        //Escreve os arquivos em disco com um valor randomico de 1 a 1000
//        for (int i = 0; i < 1000; i++) {
//            int temp = (int) (Math.random() * range + min);
//            String tempo = String.valueOf(temp);
//            bw.write(tempo);
//            bw.newLine();
//        }
//        bw.close();
//        //Fazendo a leitura dos arquivos em disco
//        String line;
//        ArrayList<Integer> list = new ArrayList<>();
//
//        while ((line = br.readLine()) != null) {
//            list.add(Integer.valueOf(line));
//        }
//
//        for (int i = list.size() - 1; i > 0; i--) {
//            boolean swapped = false;
//            for (int j = 0; j < i; j++) {
//                if (list.get(j) > list.get(j + 1)) {
//                    int temp = list.get(j);
//                    list.set(j, list.get(j + 1));
//                    list.set(j + 1, temp);
//                    swapped = true;
//                }
//            }
//            if (!swapped) {
//                break;
//            }
//        }
//        br.close();
//
//        System.out.println("Arquivo em disco: " + list);

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
        }

        // Bubble sort, varre o array e ordena em ordem crescente
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
            long time1f = System.nanoTime() - time1;

            long time2 = System.nanoTime();
            for (int j = 0; j < arrayLarger.length - 1; j++) {
                if (arrayLarger[j] > arrayLarger[j + 1]) {
                    int temp = arrayLarger[j];
                    arrayLarger[j] = arrayLarger[j + 1];
                    arrayLarger[j + 1] = temp;
                }
            }
            long time2f = System.nanoTime() - time2;

            long time3 = System.nanoTime();
            for (int j = 0; j < arrayLargest.length - 1; j++) {
                if (arrayLargest[j] > arrayLargest[j + 1]) {
                    int temp = arrayLargest[j];
                    arrayLargest[j] = arrayLargest[j + 1];
                    arrayLargest[j + 1] = temp;
                    swap = true;
                }
            }
            long time3f = System.nanoTime() - time3;

            if (!swap) {
                System.out.println("Processamento finalizado!");
                System.out.println("--------------------------------------------");
                System.out.println("Array de 100: " + Arrays.toString(arrayLarge));
                System.out.println("Tempo de processamento: " + (time1f));
                System.out.println(" ");
                System.out.println("--------------------------------------------");
                System.out.println("Array de 1000: " + Arrays.toString(arrayLarger));
                System.out.println("Tempo de processamento: " + (time2f));
                System.out.println(" ");
                System.out.println("--------------------------------------------");
                System.out.println("Array de 10000: " + Arrays.toString(arrayLargest));
                System.out.println("Tempo de processamento: " + (time3f));
                break;
            }

            // Cria os eixos
            CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Tamanho do Array");
            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("Tempo de Processamento (Nanosegundos)");

            // Cria a série de dados
            XYChart.Series series1 = new XYChart.Series();
            series1.setName("Tempos de Processamento");
            series1.getData().add(new XYChart.Data("100", time1f));
            series1.getData().add(new XYChart.Data("1000", time2f));
            series1.getData().add(new XYChart.Data("10000", time3f));

            // Cria o gráfico
            LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
            lineChart.getData().add(series1);

            // Mostra o gráfico
            Scene scene = new Scene(lineChart, 500, 300);
            stage.setScene(scene);
            stage.show();

        }
    }
}