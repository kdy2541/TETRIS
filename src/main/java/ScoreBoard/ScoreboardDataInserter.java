package ScoreBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class ScoreboardDataInserter {

    private static final String URL = "jdbc:mysql://18.183.210.86:3306/tetris?useSSL=false";
    private static final String USER = "ezcho";
    private static final String PASSWORD = "aD$%$#vveW334";

    public static void insertSampleData() {
        String query = "INSERT INTO scoreboard (nickname, score, time, lines_count, date) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
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