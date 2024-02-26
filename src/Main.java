import Controller.MoveControl;
import MapPane.Map;
import MapPane.SkillPane;
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
        MoveControl moveControl = new MoveControl(map);
        ////////////////set key for move////////////////
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {
                moveControl.turnLeft();
            } else if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {
                moveControl.turnRight();
            } else if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.UP) {
                moveControl.turnUp();
            } else if (e.getCode() == KeyCode.S || e.getCode() == KeyCode.DOWN) {
                moveControl.turnDown();
            } else if (e.getCode() == KeyCode.DIGIT1) {
                Thread thread = new Thread(() -> {
                    Platform.runLater(() -> {
                        skillPane.useSkill(0);
                    });
                });
                thread.start();
            } else if (e.getCode() == KeyCode.DIGIT2) {
                Thread thread = new Thread(() -> {
                    Platform.runLater(() -> {
                        skillPane.useSkill(1);
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