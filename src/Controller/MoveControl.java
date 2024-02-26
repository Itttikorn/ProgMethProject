package Controller;

import Util.PlayerView;
import MapPane.Map;

public class MoveControl {
    private Map map;

    public MoveControl(Map map) {
        this.map = map;
    }

    public void turnRight() {

        //////////////// Check can it walk ////////////////
        int position = map.getHeroPosition();
        if (map.getAllCells().get(position + map.getMapSize().getY()).isTransparent()) {
            changeface(PlayerView.RIGHT);
            return;
        }

        //////////////// Check does it hit Map boarder ////////////////
        if (map.getCurrentPosition().getX() + 11 == map.getMapSize().getX()) map.mapExtends(0);

        //////////////// Reposition hero ////////////////
        map.getAllCells().get(position).clear();
        map.setCurrentFacing(PlayerView.RIGHT);
        map.getAllCells().get(position + map.getMapSize().getY()).drawInside(map.getCurrentFacing());
        map.getChildren().clear();
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 11; j++) {
                map.add(map.getAllCells().get(((i + map.getCurrentPosition().getX() - 9) * map.getMapSize().getY()) + j + map.getCurrentPosition().getY() - 5), i, j);
            }
        }
        map.getCurrentPosition().setX(map.getCurrentPosition().getX() + 1);
    }

    public void turnLeft() {

        //////////////// Check can it walk ////////////////
        if (map.getAllCells().get(map.getHeroPosition() - map.getMapSize().getY()).isTransparent()) {
            changeface(PlayerView.LEFT);
            return;
        }

        ////////////////Check does it hit Map boarder////////////////
        boolean exten = true;
        if (map.getCurrentPosition().getX() - 10 == 0) {
            map.mapExtends(1);
            exten = false;
        }

        //////////////// Reposition hero ////////////////
        if (exten) map.getCurrentPosition().setX(map.getCurrentPosition().getX() - 1);
        int position = map.getHeroPosition();
        map.getAllCells().get(position + map.getMapSize().getY()).clear();
        map.setCurrentFacing(PlayerView.LEFT);
        map.getAllCells().get(position).drawInside(map.getCurrentFacing());
        map.getChildren().clear();
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 11; j++) {
                map.add(map.getAllCells().get(((i + map.getCurrentPosition().getX() - 10) * map.getMapSize().getY()) + j + map.getCurrentPosition().getY() - 5), i, j);
            }
        }
    }

    public void turnup() {

        //////////////// Check can it walk ////////////////
        if (map.getAllCells().get(map.getHeroPosition() - 1).isTransparent()) {
            changeface(PlayerView.UP);
            return;
        }

        //////////////// Check does it hit Map boarder ////////////////
        boolean exten = true;
        if (map.getCurrentPosition().getY() - 5 == 0) {
            map.mapExtends(2);
            exten = false;
        }

        //////////////// Reposition hero ////////////////
        if (exten) map.getCurrentPosition().setY(map.getCurrentPosition().getY() - 1);
        int position = map.getHeroPosition();
        map.getAllCells().get(position + 1).clear();
        map.setCurrentFacing(PlayerView.UP);
        map.getAllCells().get(position).drawInside(map.getCurrentFacing());
        map.getChildren().clear();
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 11; j++) {
                map.add(map.getAllCells().get(((i + map.getCurrentPosition().getX() - 10) * map.getMapSize().getY()) + j + map.getCurrentPosition().getY() - 5), i, j);
            }
        }
    }

    public void turndown() {

        //////////////// Check can it walk ////////////////
        if (map.getAllCells().get(map.getHeroPosition() + 1).isTransparent()) {
            changeface(PlayerView.DOWN);
            return;
        }

        //////////////// Check does it hit Map boarder ////////////////
        if (map.getCurrentPosition().getY() + 6 == map.getMapSize().getY()) map.mapExtends(3);

        //////////////// Reposition hero ////////////////
        int position = map.getHeroPosition();
        map.getAllCells().get(position).clear();
        map.setCurrentFacing(PlayerView.DOWN);
        map.getAllCells().get(position + 1).drawInside(map.getCurrentFacing());

        map.getChildren().clear();
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 11; j++) {
                map.add(map.getAllCells().get(((i + map.getCurrentPosition().getX() - 10) * map.getMapSize().getY()) + j + map.getCurrentPosition().getY() - 4), i, j);
            }
        }

        map.getCurrentPosition().setY(map.getCurrentPosition().getY() + 1);
    }

    public void changeface(PlayerView playerview) {
        int position = map.getHeroPosition();
        map.getAllCells().get(position).clear();
        map.setCurrentFacing(playerview);
        map.getAllCells().get(position).drawInside(playerview);
    }
    public void call() {
        //////////////// Debug position ////////////////
        System.out.println("X : " + map.getCurrentPosition().getX() + " Y : " + map.getCurrentPosition().getY());
    }
}
