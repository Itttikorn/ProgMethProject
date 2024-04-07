package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import pane.tiles.*;

public class RootPane extends GridPane {
    private static RootPane instance;
    private static final int SIZE = 8;
    private RootPane(){
        this.setGridLinesVisible(true);
        this.setAlignment(Pos.CENTER);
        //this.setPadding(new Insets(0, 0, 0, 0));
        RowConstraints topRowConstraints = new RowConstraints();
        topRowConstraints.setPrefHeight(100);
        topRowConstraints.setVgrow(Priority.ALWAYS);
        RowConstraints normalRowConstraints = new RowConstraints();
        normalRowConstraints.setPrefHeight(75);
        this.getRowConstraints().add(0,topRowConstraints);
        this.getRowConstraints().add(1,normalRowConstraints);
        this.getRowConstraints().add(2,normalRowConstraints);
        this.getRowConstraints().add(3,normalRowConstraints);
        this.getRowConstraints().add(4,normalRowConstraints);
        this.getRowConstraints().add(5,normalRowConstraints);
        this.getRowConstraints().add(6,normalRowConstraints);
        this.getRowConstraints().add(7,topRowConstraints);
        ColumnConstraints leftColumnConstraints = new ColumnConstraints();
        leftColumnConstraints.setPrefWidth(100);
        leftColumnConstraints.setHgrow(Priority.ALWAYS);
        ColumnConstraints normalColumnConstraints = new ColumnConstraints();
        normalColumnConstraints.setPrefWidth(75);
        this.getColumnConstraints().add(0,leftColumnConstraints);
        this.getColumnConstraints().add(1,normalColumnConstraints);
        this.getColumnConstraints().add(2,normalColumnConstraints);
        this.getColumnConstraints().add(3,normalColumnConstraints);
        this.getColumnConstraints().add(4,normalColumnConstraints);
        this.getColumnConstraints().add(5,normalColumnConstraints);
        this.getColumnConstraints().add(6,normalColumnConstraints);
        this.getColumnConstraints().add(7,leftColumnConstraints);
        this.add(new StartTile(0),7,7);
        this.add(new LocationTile(1, "Bottom"), 6,7);
        this.add(new LocationTile(2, "Bottom"), 5,7);
        this.add(new CardTile(3, "Bottom"), 4,7);
        this.add(new LocationTile(4, "Bottom"), 3,7);
        this.add(new LocationTile(5, "Bottom"), 2,7);
        this.add(new LocationTile(6, "Bottom"), 1,7);
        this.add(new JailTile(7),0,7);
        this.add(new LocationTile(8, "Left").toGroup(), 0,6);
        this.add(new LocationTile(9, "Left").toGroup(), 0,5);
        this.add(new CardTile(10, "Left").toGroup(), 0,4);
        this.add(new LocationTile(11, "Left").toGroup(), 0,3);
        this.add(new LocationTile(12, "Left").toGroup(), 0,2);
        this.add(new LocationTile(13, "Left").toGroup(), 0,1);
        this.add(new FestivalTile(14),0,0);
        this.add(new LocationTile(15, "Top"), 1,0);
        this.add(new LocationTile(16, "Top"), 2,0);
        this.add(new CardTile(17, "Top"), 3,0);
        this.add(new LocationTile(18, "Top"), 4,0);
        this.add(new LocationTile(19, "Top"), 5,0);
        this.add(new LocationTile(20, "Top"), 6,0);
        this.add(new BusTile(21),7,0);
        this.add(new LocationTile(22, "Right").toGroup(), 7,1);
        this.add(new LocationTile(23, "Right").toGroup(), 7,2);
        this.add(new CardTile(24, "Right").toGroup(), 7,3);
        this.add(new LocationTile(25, "Right").toGroup(), 7,4);
        this.add(new LocationTile(26, "Right").toGroup(), 7,5);
        this.add(new LocationTile(27, "Right").toGroup(), 7,6);
        this.add(new CenterTile(), 1,1,6,6);
    }
    public static RootPane getRootPane(){
        if (instance == null)
            instance = new RootPane();
        return instance;
    }

}
