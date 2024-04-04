package ScoreBoard;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;

public class ScoreboardDataInserter {
    private static final Properties props = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream input = ScoreboardDataInserter.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("application.properties를 찾을 수 없습니다.");
            }
            props.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("application.properties를 로드하는데 실패했습니다.", ex);
        }
    }

    public static void insertSampleData() {
        String query = "INSERT INTO scoreboard (nickname, score, time, lines_count, date) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(props.getProperty("database.url"), props.getProperty("database.user"), props.getProperty("database.password"));
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // 샘플 데이터 삽입
            pstmt.setString(1, "PlayerOne");
            pstmt.setInt(2, 1500);
            pstmt.setString(3, "00:05:30");
            pstmt.setInt(4, 10);
            pstmt.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
            pstmt.executeUpdate();

            System.out.println("Sample data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}