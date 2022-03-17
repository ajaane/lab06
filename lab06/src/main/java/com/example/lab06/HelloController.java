package com.example.lab06;

import javafx.fxml.FXML;
import javafx.scene.chart.*;

public class HelloController {
    @FXML
    private BarChart barChart;

    @FXML
    private PieChart pieChart;

    private static final double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };

    private static final double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    private XYChart.Series<String,Number> series1, series2;

    @FXML
    private void initialize() {
        System.out.println("Initialize ran");
        CategoryAxis xAxis  = new CategoryAxis();

        NumberAxis yAxis = new NumberAxis();

        barChart = new BarChart<String,Number>(xAxis, yAxis);

        XYChart.Series<String, Double> series1 = new XYChart.Series<String, Double>();
        XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();

        for (int i = 0; i < avgHousingPricesByYear.length; i++) {
            series1.getData().add(new XYChart.Data<String,Double>(String.valueOf(i),avgHousingPricesByYear[i]));
            System.out.println(avgCommercialPricesByYear[i]);
            series2.getData().add(new XYChart.Data<String,Double>(String.valueOf(i), avgCommercialPricesByYear[i]));
        }

        barChart.getData().addAll(series1,series2);



        System.out.println("Ran initialize");


    }
}