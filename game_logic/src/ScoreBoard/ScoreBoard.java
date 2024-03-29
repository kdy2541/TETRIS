package ScoreBoard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private List<ScoreRecord> records;

    public ScoreBoard() {
        records = new ArrayList<>();
    }

    public void addRecord(ScoreRecord record) {
        records.add(record);
    }

    public List<ScoreRecord> getRecords() {
        return records;
    }


    // 기타 스코어보드 관련 메서드들을 추가할 수 있음
    public ScoreBoard(List<ScoreRecord> initialRecords) {
        records = new ArrayList<>(initialRecords);
    }
}
