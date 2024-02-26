import Controller.Contro_move;
import MapPane.Cell;
import MapPane.Map;
import MapPane.SkillPane;
import Util.Block;
import Util.Playerview;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ////////////////set value////////////////
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        SkillPane skillPane = new SkillPane();

        Map map = new Map();
        root.getChildren().addAll(skillPane,map);
//        root.setPrefHeight(400);
//        root.setPrefWidth(800);
        Scene scene = new Scene(root);
        Contro_move controMove = new Contro_move(map);
        ////////////////set key for move////////////////
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {
                controMove.turnleft();
            } else if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {
                controMove.turnright();
            } else if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.UP) {
                controMove.turnup();
            } else if (e.getCode() == KeyCode.S || e.getCode() == KeyCode.DOWN) {
                controMove.turndown();
            } else if (e.getCode() == KeyCode.DIGIT1) {
                Thread thread = new Thread(() -> {
                    Platform.runLater(() -> {
                        skillPane.burskill(0);
                    });
                });
                thread.start();
            } else if (e.getCode() == KeyCode.DIGIT2) {
                Thread thread = new Thread(() -> {
                    Platform.runLater(() -> {
                        skillPane.burskill(1);
                    });
                });
                thread.start();
            }
//            map.call();  // check movement
        });
        stage.setScene(scene);
        stage.setTitle("World");
        stage.show();
    }
}