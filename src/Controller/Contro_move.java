package Controller;

import Util.Playerview;
import MapPane.Map;

public class Contro_move {
    private Map map;

    public Contro_move(Map map) {
        this.map = map;
    }

    public void turnright() {

        //////////////// Check can it walk ////////////////
        int position = map.getcurrentposition();
        if (map.getAllCells().get(position + map.getMapsize().getY()).isTransparent()) {
            changeface(Playerview.Right);
            return;
        }

        //////////////// Check does it hit Map boarder ////////////////
        if (map.getCurrentlyposition().getX() + 11 == map.getMapsize().getX()) map.mapextends(0);

        //////////////// Reposition hero ////////////////
        map.getAllCells().get(position).clear();
        map.setCurrentlyface(Playerview.Right);
        map.getAllCells().get(position + map.getMapsize().getY()).drawinside(map.getCurrentlyface());
        map.getChildren().clear();
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 11; j++) {
                map.add(map.getAllCells().get(((i + map.getCurrentlyposition().getX() - 9) * map.getMapsize().getY()) + j + map.getCurrentlyposition().getY() - 5), i, j);
            }
        }
        map.getCurrentlyposition().setX(map.getCurrentlyposition().getX() + 1);
    }

    public void turnleft() {

        //////////////// Check can it walk ////////////////
        if (map.getAllCells().get(map.getcurrentposition() - map.getMapsize().getY()).isTransparent()) {
            changeface(Playerview.Left);
            return;
        }

        ////////////////Check does it hit Map boarder////////////////
        boolean exten = true;
        if (map.getCurrentlyposition().getX() - 10 == 0) {
            map.mapextends(1);
            exten = false;
        }

        //////////////// Reposition hero ////////////////
        if (exten) map.getCurrentlyposition().setX(map.getCurrentlyposition().getX() - 1);
        int position = map.getcurrentposition();
        map.getAllCells().get(position + map.getMapsize().getY()).clear();
        map.setCurrentlyface(Playerview.Left);
        map.getAllCells().get(position).drawinside(map.getCurrentlyface());
        map.getChildren().clear();
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 11; j++) {
                map.add(map.getAllCells().get(((i + map.getCurrentlyposition().getX() - 10) * map.getMapsize().getY()) + j + map.getCurrentlyposition().getY() - 5), i, j);
            }
        }
    }

    public void turnup() {

        //////////////// Check can it walk ////////////////
        if (map.getAllCells().get(map.getcurrentposition() - 1).isTransparent()) {
            changeface(Playerview.Up);
            return;
        }

        //////////////// Check does it hit Map boarder ////////////////
        boolean exten = true;
        if (map.getCurrentlyposition().getY() - 5 == 0) {
            map.mapextends(2);
            exten = false;
        }

        //////////////// Reposition hero ////////////////
        if (exten) map.getCurrentlyposition().setY(map.getCurrentlyposition().getY() - 1);
        int position = map.getcurrentposition();
        map.getAllCells().get(position + 1).clear();
        map.setCurrentlyface(Playerview.Up);
        map.getAllCells().get(position).drawinside(map.getCurrentlyface());
        map.getChildren().clear();
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 11; j++) {
                map.add(map.getAllCells().get(((i + map.getCurrentlyposition().getX() - 10) * map.getMapsize().getY()) + j + map.getCurrentlyposition().getY() - 5), i, j);
            }
        }
    }

    public void turndown() {

        //////////////// Check can it walk ////////////////
        if (map.getAllCells().get(map.getcurrentposition() + 1).isTransparent()) {
            changeface(Playerview.Down);
            return;
        }

        //////////////// Check does it hit Map boarder ////////////////
        if (map.getCurrentlyposition().getY() + 6 == map.getMapsize().getY()) map.mapextends(3);

        //////////////// Reposition hero ////////////////
        int position = map.getcurrentposition();
        map.getAllCells().get(position).clear();
        map.setCurrentlyface(Playerview.Down);
        map.getAllCells().get(position + 1).drawinside(map.getCurrentlyface());

        map.getChildren().clear();
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 11; j++) {
                map.add(map.getAllCells().get(((i + map.getCurrentlyposition().getX() - 10) * map.getMapsize().getY()) + j + map.getCurrentlyposition().getY() - 4), i, j);
            }
        }

        map.getCurrentlyposition().setY(map.getCurrentlyposition().getY() + 1);
    }

    public void changeface(Playerview playerview) {
        int position = map.getcurrentposition();
        map.getAllCells().get(position).clear();
        map.setCurrentlyface(playerview);
        map.getAllCells().get(position).drawinside(playerview);
    }
    public void call() {
        //////////////// Debug position ////////////////
        System.out.println("X : " + map.getCurrentlyposition().getX() + " Y : " + map.getCurrentlyposition().getY());
    }
}
