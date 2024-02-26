package MapPane;

import Util.Block;
import Util.Playerview;
import Util.Position;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Map extends GridPane {
    private ArrayList<Cell> allCells;
    private Position currentlyposition;
    private Position mapsize;
    private Playerview currentlyface;

    public Map() {
        super();

        //////////////// set value ////////////////
        this.setAllCells(new ArrayList<Cell>());
        this.setCurrentlyface(Playerview.Right);

        this.setCurrentlyposition(new Position(10, 5));
        this.setMapsize(new Position(21, 11));

        //////////////// set alignment ////////////////
        this.setPadding(new Insets(8));
        this.setAlignment(Pos.CENTER);
//        this.setPrefWidth(500);
        this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        //////////////// fill board ////////////////
        Random random = new Random();
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 11; j++) {
                if (i != 10 || j != 5) {
                    this.allCells.add(new Cell(Block.randomBlock()));
                } else {
                    //////////////// draw base hero ////////////////
                    this.allCells.add(new Cell(Block.Grass));
                    this.getAllCells().get((i * 11) + j).drawinside(Playerview.Right);
                }
                this.add(allCells.get((i * 11) + j), i, j);
            }
        }
    }

    public Playerview getCurrentlyface() {
        return currentlyface;
    }

    public void setCurrentlyface(Playerview currentlyface) {
        this.currentlyface = currentlyface;
    }

    public int getcurrentposition() {
        return this.getCurrentlyposition().getX() * this.getMapsize().getY() + this.getCurrentlyposition().getY();
    }

    public void mapextends(int num) {
        ////////////////       extend map      ////////////////
        //////////////// case 0 = extend right ////////////////
        //////////////// case 1 = extend left  ////////////////
        //////////////// case 2 = extend up    ////////////////
        //////////////// case 3 = extend down  ////////////////
        switch (num) {
            case 0:
//                System.out.println(0);
                for (int loop = 0; loop < this.getMapsize().getY(); loop++) {
                    this.getAllCells().add(new Cell(Block.randomBlock()));
                }
                this.getMapsize().setX(this.getMapsize().getX() + 1);
                break;
            case 1:
//                System.out.println(1);
                for (int loop = 0; loop < this.getMapsize().getY(); loop++) {
                    this.getAllCells().add(0, new Cell(Block.randomBlock()));
                }
                this.getMapsize().setX(this.getMapsize().getX() + 1);
                break;
            case 2:
//                System.out.println(2);
                for (int loop = 0; loop < this.getMapsize().getX(); loop++) {
                    this.getAllCells().add(loop * this.getMapsize().getY() + loop, new Cell(Block.randomBlock()));
                }
                this.getMapsize().setY(this.getMapsize().getY() + 1);
                break;
            case 3:
//                System.out.println("3");
                for (int loop = 0; loop < this.getMapsize().getX(); loop++) {
                    this.getAllCells().add((loop + 1) * this.getMapsize().getY() + loop, new Cell(Block.randomBlock()));
                }
                this.getMapsize().setY(this.getMapsize().getY() + 1);
                break;
        }
    }

    public ArrayList<Cell> getAllCells() {
        return allCells;
    }

    public void setAllCells(ArrayList<Cell> allCells) {
        this.allCells = allCells;
    }

    public Position getCurrentlyposition() {
        return currentlyposition;
    }

    public void setCurrentlyposition(Position currentlyposition) {
        this.currentlyposition = currentlyposition;
    }

    public Position getMapsize() {
        return mapsize;
    }

    public void setMapsize(Position mapsize) {
        this.mapsize = mapsize;
    }
}
