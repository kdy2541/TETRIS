package ScoreBoard;

public class ScoreRecord {
    private String name;
    private int score;

    public ScoreRecord(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // getter와 setter 메서드 생략

    @Override
    public String toString() {
        return name + ": " + score;
    }
}
