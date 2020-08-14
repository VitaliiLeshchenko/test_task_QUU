package solution.services.impl;

import solution.services.QueryValidator;
import solution.services.TimeLineValidator;
import static solution.utils.Constants.STAR;


public class QueryValidatorImpl implements QueryValidator {

    private final TimeLineValidator timeLineValidator;

    public QueryValidatorImpl(TimeLineValidator timeLineValidator) {
        this.timeLineValidator = timeLineValidator;
    }

    @Override
    public void validateServiceType(String serviceType) {
        if (!serviceType.equals(STAR)) {
            timeLineValidator.validateServiceType(serviceType);
        }
    }

    @Override
    public void validateQuestionType(String questionType) {
        if (!questionType.equals(STAR)) {
            timeLineValidator.validateQuestionType(questionType);
        }
    }

    @Override
    public void validateResponseType(String responseType) {
        timeLineValidator.validateResponseType(responseType);
    }

    @Override
    public String validateDate(String date) {
        return timeLineValidator.validateDate(date);

    }
}
