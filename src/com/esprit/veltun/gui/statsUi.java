package com.esprit.veltun.gui;

import com.esprit.veltun.model.RackVelo;
import com.esprit.veltun.model.Station;
import com.esprit.veltun.services.impl.RackVeloImpl;
import com.esprit.veltun.services.impl.StationServiceImpl;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;


public class statsUi extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the pie chart data
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        pieChartData.clear();
        RackVeloImpl rackVeloImpl = new RackVeloImpl();
        StationServiceImpl stationServiceImpl = new StationServiceImpl();

        List<RackVelo> rackVeloList = (List<RackVelo>) rackVeloImpl.list();
        List<Station> stationList = (List<Station>) stationServiceImpl.list();

//            int categoriesN = categories.size();
        for (Station station : stationList) {
            int stationsN = 0;
            for (RackVelo rackVelo : rackVeloList) {
                if (station.getid_station() == rackVelo.getId_station()) {
                    stationsN++;
                }
            }

            PieChart.Data data = new PieChart.Data(station.getnom_station(), stationsN);
            pieChartData.add(data);

        }

        // Create the pie chart and add the data to it
        PieChart pieChart = new PieChart(pieChartData);

        // Create a stack pane to hold the pie chart
        StackPane root = new StackPane();
        root.getChildren().add(pieChart);

        // Create the scene and set the root node
        Scene scene = new Scene(root, 400, 400);

        // Set the stage title and scene, then show the stage
        primaryStage.setTitle("Stats : Number of RackVelos per Station");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
