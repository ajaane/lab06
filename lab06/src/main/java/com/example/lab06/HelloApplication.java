package com.example.lab06;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.collections.FXCollections;

import java.io.IOException;



public class HelloApplication extends Application {
    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };

    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };


    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        CategoryAxis xAxis  = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart barChart = new BarChart(xAxis, yAxis);

        XYChart.Series<String, Double> series1 = new XYChart.Series<String, Double>();
        XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();

        for (int i = 0; i < avgHousingPricesByYear.length; i++) {
            series1.getData().add(new XYChart.Data(String.valueOf(i),avgHousingPricesByYear[i]));
            series2.getData().add(new XYChart.Data(String.valueOf(i), avgCommercialPricesByYear[i]));
        }


        barChart.getData().addAll(series1, series2);
        barChart.getYAxis().setTickLabelsVisible(false);
        barChart.getYAxis().setOpacity(0);
        barChart.getXAxis().setTickLabelsVisible(false);
        barChart.getXAxis().setOpacity(0);
        barChart.setLayoutX(14);
        barChart.setLayoutY(50);

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        pieChartData = pie();

        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setLayoutX(428);
        pieChart.setLayoutY(50);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(barChart, pieChart);


        Scene scene = new Scene(anchorPane, 900, 496);
        stage.setTitle("Lab06");
        stage.setScene(scene);
        stage.show();
    }

    public ObservableList<PieChart.Data> pie(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (int i = 0; i < ageGroups.length ; i++) {
            pieChartData.add(new PieChart.Data(ageGroups[i], avgHousingPricesByYear[i]));
        }

        return pieChartData;
    }

    public static void main(String[] args) {
        launch();
    }
}