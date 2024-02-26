package MapPane;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SkillCell extends StackPane {
    private int skillDelay;
    private boolean delaying;
    private Label cooldown;

    public SkillCell(String name, int skillDelay) {
        super();

        //////////////// set value ////////////////
        this.setSkillDelay(skillDelay);

        //////////////// set alignment ////////////////
        this.setPrefHeight(50);
        this.setPrefWidth(50);
        this.setMaxHeight(50);
        this.setMaxWidth(50);

        //////////////// set pane ////////////////
        ImageView imageView = new ImageView(new Image(ClassLoader.getSystemResource(name).toString()));
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        this.setAlignment(Pos.CENTER);
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        this.getChildren().add(imageView);

        Label label = new Label(String.valueOf(skillDelay));
        label.setVisible(false);
        label.setFont(Font.font(20));
        this.setCooldown(label);
        this.getChildren().add(label);
        StackPane.setAlignment(label, Pos.CENTER);
    }

    public void timer() throws InterruptedException {
        //////////////// check can u use skill ////////////////
        if (this.isDelaying()) return;

        this.setDelaying(true);
        visible(true);
        int skillDelay = this.getSkillDelay();
        for (; 0 < skillDelay; skillDelay--) {
            int finalskillDelay = skillDelay;
            Platform.runLater(() -> {
                this.setCooldownTime(finalskillDelay);
            });
            Thread.sleep(1000);
        }
        visible(false);
        this.setDelaying(false);
    }

    public void visible(boolean b) {
        if (b) this.getChildren().get(0).setEffect(new GaussianBlur(10));
        else this.getChildren().get(0).setEffect(null);

        this.getCooldown().setVisible(b);
    }

    public void setCooldownTime(int time) {
        this.getCooldown().setText(String.valueOf(time));
    }

    public int getSkillDelay() {
        return skillDelay;
    }

    public void setSkillDelay(int skillDelay) {
        this.skillDelay = skillDelay;
    }

    public boolean isDelaying() {
        return delaying;
    }

    public void setDelaying(boolean delaying) {
        this.delaying = delaying;
    }

    public Label getCooldown() {
        return cooldown;
    }

    public void setCooldown(Label cooldown) {
        this.cooldown = cooldown;
    }
}
