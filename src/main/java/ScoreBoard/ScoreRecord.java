package ScoreBoard;

import java.time.LocalDate;

public class ScoreRecord {
    private String nickname;
    private int score;
    private String time; // 게임을 완료하는 데 걸린 시간
    private int linesCount; // 제거한 라인 수
    private LocalDate date; // 기록 날짜

    // 기본 생성자
    public ScoreRecord(String nickname, int score, String time, int linesCount, LocalDate date) {
        this.nickname = nickname;
        this.score = score;
        this.time = time;
        this.linesCount = linesCount;
        this.date = date;
    }

    // Getter 메서드들
    public String getNickname() {
        return nickname;
    }

    public int getScore() {
        return score;
    }

    public String getTime() {
        return time;
    }

    public int getLinesCount() {
        return linesCount;
    }

    public LocalDate getDate() {
        return date;
    }


}
