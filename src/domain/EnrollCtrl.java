package domain;

import java.util.List;
import java.util.Map;

import domain.exceptions.EnrollmentRulesViolationException;

public class EnrollCtrl {
	public void enroll(Student s, List<Course> courses) throws EnrollmentRulesViolationException {
        Transcript transcript = s.getTranscript();
		for (Course o : courses) {
            if(transcript.containsPassedCourse(o))
                throw new EnrollmentRulesViolationException(String.format("The student has already passed %s", o.getName()));

			List<Course> prereqs = o.getPrerequisites();
            Course notPassedPrerequisite = transcript.findNotPassedPrerequisites(prereqs);
            if(notPassedPrerequisite != null)
                throw new EnrollmentRulesViolationException(String.format("The student has not passed %s as a prerequisite of %s", notPassedPrerequisite.getName(), o.getName()));

            for (Course o2 : courses) {
                if (o == o2)
                    continue;
                if (o.getExamDate().equals(o2.getExamDate()))
                    throw new EnrollmentRulesViolationException(String.format("Two offerings %s and %s have the same exam time", o, o2));
                if (o.equals(o2))
                    throw new EnrollmentRulesViolationException(String.format("%s is requested to be taken twice", o.getName()));
            }
		}
		int unitsRequested = 0;
		for (Course o : courses)
			unitsRequested += o.getUnits();
        double gpa = transcript.getGpa();
		if ((gpa < 12 && unitsRequested > 14) ||
				(gpa < 16 && unitsRequested > 16) ||
				(unitsRequested > 20))
			throw new EnrollmentRulesViolationException(String.format("Number of units (%d) requested does not match GPA of %f", unitsRequested, gpa));
		for (Course o : courses)
			s.takeCourse(o);
	}
}