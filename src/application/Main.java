package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pane.RootPane;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(RootPane.getRootPane(),650,650);
        stage.setScene(scene);
        stage.setTitle("Monopoly");
        stage.setResizable(false);
        stage.show();
    }
}
