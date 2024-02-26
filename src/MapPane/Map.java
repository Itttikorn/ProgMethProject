package MapPane;

import Util.Block;
import Util.PlayerView;
import Util.Position;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Map extends GridPane {
    private ArrayList<Cell> allCells;
    private Position currentPosition;
    private Position mapSize;
    private PlayerView currentFacing;

    public Map() {
        super();

        //////////////// set value ////////////////
        this.setAllCells(new ArrayList<Cell>());
        this.setCurrentFacing(PlayerView.RIGHT);

        this.setCurrentPosition(new Position(10, 5));
        this.setMapSize(new Position(21, 11));

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
                    this.allCells.add(new Cell(Block.GRASS));
                    this.getAllCells().get((i * 11) + j).drawInside(PlayerView.RIGHT);
                }
                this.add(allCells.get((i * 11) + j), i, j);
            }
        }
    }

    public PlayerView getCurrentFacing() {
        return currentFacing;
    }

    public void setCurrentFacing(PlayerView currentFacing) {
        this.currentFacing = currentFacing;
    }

    public int getHeroPosition() {
        return this.getCurrentPosition().getX() * this.getMapSize().getY() + this.getCurrentPosition().getY();
    }

    public void mapExtends(int num) {
        ////////////////       extend map      ////////////////
        //////////////// case 0 = extend RIGHT ////////////////
        //////////////// case 1 = extend LEFT  ////////////////
        //////////////// case 2 = extend UP    ////////////////
        //////////////// case 3 = extend DOWN  ////////////////
        switch (num) {
            case 0:
//                System.out.println(0);
                for (int loop = 0; loop < this.getMapSize().getY(); loop++) {
                    this.getAllCells().add(new Cell(Block.randomBlock()));
                }
                this.getMapSize().setX(this.getMapSize().getX() + 1);
                break;
            case 1:
//                System.out.println(1);
                for (int loop = 0; loop < this.getMapSize().getY(); loop++) {
                    this.getAllCells().add(0, new Cell(Block.randomBlock()));
                }
                this.getMapSize().setX(this.getMapSize().getX() + 1);
                break;
            case 2:
//                System.out.println(2);
                for (int loop = 0; loop < this.getMapSize().getX(); loop++) {
                    this.getAllCells().add(loop * this.getMapSize().getY() + loop, new Cell(Block.randomBlock()));
                }
                this.getMapSize().setY(this.getMapSize().getY() + 1);
                break;
            case 3:
//                System.out.println("3");
                for (int loop = 0; loop < this.getMapSize().getX(); loop++) {
                    this.getAllCells().add((loop + 1) * this.getMapSize().getY() + loop, new Cell(Block.randomBlock()));
                }
                this.getMapSize().setY(this.getMapSize().getY() + 1);
                break;
        }
    }

    public ArrayList<Cell> getAllCells() {
        return allCells;
    }

    public void setAllCells(ArrayList<Cell> allCells) {
        this.allCells = allCells;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position getMapSize() {
        return mapSize;
    }

    public void setMapSize(Position mapSize) {
        this.mapSize = mapSize;
    }
}
