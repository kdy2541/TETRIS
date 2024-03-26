import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class TetrisWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TetriS");

        BorderPane root = new BorderPane();

        // 로고 생성
        Text logoText = new Text("TetriS");
        logoText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        logoText.setFill(Color.BLACK);
        VBox logoPane = new VBox(logoText);
        logoPane.setPadding(new Insets(10));
        logoPane.setStyle("-fx-background-color: #800080;");

        // 버튼 생성
        VBox buttonPane = new VBox(10);
        buttonPane.setAlignment(Pos.CENTER);
        Button gameStartButton = new Button("게임시작");
        Button scoreBoardButton = new Button("스코어보드");
        Button settingsButton = new Button("설정");
        Button exitButton = new Button("게임종료");
        buttonPane.getChildren().addAll(gameStartButton, scoreBoardButton, settingsButton, exitButton);

        // 설정 창 생성
        SettingsWindow settingsWindow = new SettingsWindow(primaryStage);
        settingsButton.setOnAction(event -> settingsWindow.show());

        // 게임 종료 버튼 동작 설정
        exitButton.setOnAction(event -> primaryStage.close());

        // 버튼에 대한 포커스 설정
        gameStartButton.setFocusTraversable(true);
        scoreBoardButton.setFocusTraversable(true);
        settingsButton.setFocusTraversable(true);
        exitButton.setFocusTraversable(true);

        // 엔터 키로 버튼 선택하기
        gameStartButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // 버튼에 대한 동작 수행
                gameStartButton.fire();
            }
        });

        scoreBoardButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // 버튼에 대한 동작 수행
                scoreBoardButton.fire();
            }
        });

        settingsButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // 버튼에 대한 동작 수행
                settingsButton.fire();
            }
        });

        exitButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // 버튼에 대한 동작 수행
                exitButton.fire();
            }
        });

        root.setTop(logoPane);
        root.setCenter(buttonPane);

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
