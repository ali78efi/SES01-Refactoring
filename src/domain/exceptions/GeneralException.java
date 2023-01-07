package domain.exceptions;

import java.util.ArrayList;
import java.util.List;

public class GeneralException extends Exception {
    private List<EnrollmentRulesViolationException> exceptionsList;

    public GeneralException() {
        super("General Exception");
        exceptionsList = new ArrayList<>();
    }

    public void addException(EnrollmentRulesViolationException newException){
        exceptionsList.add(newException);
    }

    public List<EnrollmentRulesViolationException> getAllExceptions(){
        return exceptionsList;
    }
}
