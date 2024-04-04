package ScoreBoard;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScoreBoardWindow {
    private Stage stage;
    private ScoreBoard scoreBoard;

    public ScoreBoardWindow(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        stage = new Stage();
        stage.setTitle("스코어 보드");
        VBox root = new VBox();
        for (ScoreRecord record : scoreBoard.getRecords()) {
            Label label = new Label(record.toString());
            root.getChildren().add(label);
        }
        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);
    }

    //더미데이터 생성자
    public ScoreBoardWindow(List<ScoreRecord> dummyRecords) {
        this.scoreBoard = new ScoreBoard(dummyRecords);
        stage = new Stage();
        stage.setTitle("스코어 보드");
        VBox root = new VBox();
        for (ScoreRecord record : scoreBoard.getRecords()) {
            Label label = new Label(record.toString());
            root.getChildren().add(label);
        }
        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }
}
