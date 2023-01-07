package domain;
import java.util.HashMap;
import java.util.Map;

public class TermTranscript {
    Term term;
    Map<Course, Double> records;

    public TermTranscript(Term term){
        this.term = term;
        this.records = new HashMap<>();
    }

    public void addRecord(Course course, Double grade){
        records.put(course, grade);
    }

    public Boolean isTermSame(Term term){
        return this.term.equals(term);
    }

    public Boolean containsPassedCourse(Course course) {
        for (Map.Entry<Course, Double> record : records.entrySet())
            if (record.getKey().equals(course) && record.getValue() >= 10)
                return true;
        return false;
    }

    public int getTotalUnits() {
        int totalUnits = 0;
        for (Map.Entry<Course, Double> record : records.entrySet())
            totalUnits += record.getKey().getUnits();
        return totalUnits;
    }

    public double getTotalPoints() {
        double totalPoints = 0;
        for (Map.Entry<Course, Double> record : records.entrySet())
            totalPoints += record.getValue() * record.getKey().getUnits();
        return totalPoints;
    }
}