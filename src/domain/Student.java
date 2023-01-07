package domain;
import java.util.ArrayList;
import java.util.List;

public class Student {
	private String id;
	private String name;
	private Transcript transcript;
	private List<Course> currentTerm;

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
		this.transcript = new Transcript();
		this.currentTerm = new ArrayList<>();
	}
	
	public void takeCourse(Course c) {
		currentTerm.add(c);
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void addTranscriptRecord(Course course, Term term, double grade) {
		transcript.addTranscriptRecord(term, course, grade);
    }

    public List<Course> getCurrentTerm() {
        return currentTerm;
    }

    public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
}