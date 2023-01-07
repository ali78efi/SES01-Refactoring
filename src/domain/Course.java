package domain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Course {
	private String id;
	private String name;
	private int units;
	private int section;
	private Date examDate;
	private List<Course> prerequisites;

	public Course(String id, String name, int units, int section, Date examDate) {
		this.id = id;
		this.name = name;
		this.units = units;
		this.section = section;
		this.examDate = examDate;
		this.prerequisites = new ArrayList<Course>();
	}


	
	public void addPre(Course c) {
		getPrerequisites().add(c);
	}

	public Course withPre(Course... pres) {
		prerequisites.addAll(Arrays.asList(pres));
		return this;
	}

	public List<Course> getPrerequisites() {
		return prerequisites;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append("- " + section);
		sb.append(" {");
		for (Course pre : getPrerequisites()) {
			sb.append(pre.getName());
			sb.append(", ");
		}
		sb.append("}");
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public int getUnits() {
		return units;
	}

	public String getId() {
		return id;
	}

	public int getSection() { return section; }

	public Date getExamDate() { return examDate; }

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public boolean equals(Object obj) {
		if(obj instanceof Course) {
			Course other = (Course) obj;
			return id.equals(other.id);
		}
		return false;
	}
}