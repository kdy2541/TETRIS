package ScoreBoard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

import static Setting.SizeConstants.*;


public class ScoreBoardWindow {
    private Stage stage;
    private ScoreBoard scoreBoard;


    public ScoreBoardWindow(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        stage = new Stage();
        stage.setTitle("기록");

        TableView<ScoreRecord> table = new TableView<>();
        ObservableList<ScoreRecord> data = FXCollections.observableArrayList(scoreBoard.getRecords());

        TableColumn<ScoreRecord, String> nicknameCol = new TableColumn<>("닉네임");
        nicknameCol.setCellValueFactory(new PropertyValueFactory<>("nickname"));

        TableColumn<ScoreRecord, Integer> scoreCol = new TableColumn<>("점수");
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));

        TableColumn<ScoreRecord, String> timeCol = new TableColumn<>("시간");
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));

        TableColumn<ScoreRecord, Integer> linesCountCol = new TableColumn<>("라인 수");
        linesCountCol.setCellValueFactory(new PropertyValueFactory<>("linesCount"));

        TableColumn<ScoreRecord, String> dateCol = new TableColumn<>("날짜");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        table.getColumns().addAll(nicknameCol, scoreCol, timeCol, linesCountCol, dateCol);
        table.setItems(data);

        VBox root = new VBox(10); // 10px spacing between components
        root.setAlignment(Pos.CENTER); // Aligns VBox contents to the center
        root.getChildren().addAll(new Label("스코어 보드"), table);

        Scene scene = new Scene(root, XMAX + 150, YMAX - SIZE);//Mesh 시점 맞추기 임시 y 에 - size
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }
}
