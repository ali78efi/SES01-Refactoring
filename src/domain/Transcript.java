package domain;
import java.util.ArrayList;
import java.util.List;

public class Transcript {
    private List<TermTranscript> termsTranscript;

    public Transcript(){
        termsTranscript = new ArrayList<>();
    }


    public List<TermTranscript> getTermTranscript(){
        return termsTranscript;
    }
    private TermTranscript findTermTranscript(Term term){
        for(TermTranscript termTranscript: termsTranscript)
            if(termTranscript.isTermSame(term))
                return termTranscript;
        return null;
    }

    public void addTranscriptRecord(Term term, Course course, double grade) {
        TermTranscript termTranscript = findTermTranscript(term);
        if (termTranscript == null) {
            TermTranscript newTermTranscript = new TermTranscript(term);
            newTermTranscript.addRecord(course, grade);
            termsTranscript.add(newTermTranscript);
        } else {
            termTranscript.addRecord(course, grade);
        }
    }

    public Boolean containsPassedCourse(Course course) {
        for (TermTranscript termTranscript : this.termsTranscript)
            if(termTranscript.containsPassedCourse(course))
                return true;
        return false;
    }

    public Course findNotPassedPrerequisites(List<Course> prerequisites) {
        for(Course prerequisite: prerequisites)
            if(!this.containsPassedCourse(prerequisite))
                return prerequisite;
        return null;
    }

    public double getGpa() {
        double points = 0;
        int totalUnits = 0;
        for (TermTranscript termTranscript : this.termsTranscript) {
            points += termTranscript.getTotalPoints();
            totalUnits += termTranscript.getTotalUnits();
        }
        return points / totalUnits;
    }

}