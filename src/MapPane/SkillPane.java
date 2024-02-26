package MapPane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class SkillPane extends HBox {
    private ArrayList<SkillCell> skillCells;

    public SkillPane() {
        //////////////// set value ////////////////
        super();
        this.setSkillCells(new ArrayList<SkillCell>());

        //////////////// set alignment ////////////////
        this.setPadding(new Insets(5));
        this.setSpacing(10);
        this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setAlignment(Pos.CENTER_LEFT);

        //////////////// add skill ////////////////
        SkillCell skill1 = new SkillCell("FireBall.png", 5);
        SkillCell skill2 = new SkillCell("Poison.png", 10);

        this.getSkillCells().add(skill1);
        this.getSkillCells().add(skill2);
        this.getChildren().addAll(skill1, skill2);
    }


    public void burskill(int skill) {
        //////////////// use skill ////////////////
        Thread thread = new Thread(() -> {
            try {
                this.getSkillCells().get(skill).timer();
            } catch (Exception ignored) {
            }
        });
        thread.start();
    }

    public ArrayList<SkillCell> getSkillCells() {
        return skillCells;
    }

    public void setSkillCells(ArrayList<SkillCell> skillCells) {
        this.skillCells = skillCells;
    }
}
