package solution.services.impl;

import solution.exceptions.CommandValidationException;
import solution.services.TimeLineValidator;
import static solution.utils.Constants.CATEGORY_ID_RANGE_REGEX;
import static solution.utils.Constants.QUESTION_ID_RANGE_REGEX;
import static solution.utils.Constants.SERVICE_ID_RANGE_REGEX;
import static solution.utils.Constants.SUB_CATEGORY_ID_RANGE_REGEX;
import static solution.utils.Constants.VARIATION_ID_RANGE_REGEX;

public class TimeLineValidatorImpl implements TimeLineValidator {

    public static final String SIGN_THAT_SEPARATES_SERVICE_AND_VARIATION = "\\.";

    public static final int SERVICE_TYPE_2_ARGUMENTS = 2;
    public static final int SERVICE_ID_INDEX = 0;
    public static final int VARIATION_ID_INDEX = 1;

    public static final int QUESTION_TYPE_3_ARGUMENTS = 3;
    public static final int QUESTION_ID_INDEX = 0;
    public static final int CATEGORY_ID_INDEX = 1;
    public static final int SUB_CATEGORY_ID_INDEX = 2;

    public static final String FIRST_OR_NEXT_RESPONSE_TYPE_REGEX = "P|N";

    private static final String DATE_REGEX =
            "(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.((19|20)\\d\\d)";
    public static final String ONE_DIGIT_DAY_OR_MONTH_REGEX = "[1-9]";

    /**
     * 1 <= service_id <= 10
     * 1 <= variation_id <= 3
     */
    @Override
    public void validateServiceType(String serviceType) {
        String[] types = serviceType.split(SIGN_THAT_SEPARATES_SERVICE_AND_VARIATION);
        if (types.length == SERVICE_TYPE_2_ARGUMENTS) {
            String variationId = types[VARIATION_ID_INDEX];
            if (!variationId.matches(VARIATION_ID_RANGE_REGEX)) {
                throw new CommandValidationException("variation_id out of range.");
            }
        }
        String serviceId = types[SERVICE_ID_INDEX];
        if (!serviceId.matches(SERVICE_ID_RANGE_REGEX)) {
            throw new CommandValidationException("service_id out of range.");
        }
    }

    /**
     * 1 <= question_id <= 10
     * 1 <= category_id <= 20
     * 1 <= sub-category_id <= 5
     */
    @Override
    public void validateQuestionType(String questionType) {
        String[] types = questionType.split(SIGN_THAT_SEPARATES_SERVICE_AND_VARIATION);
        if (types.length == QUESTION_TYPE_3_ARGUMENTS) {
            String subCategoryId = types[SUB_CATEGORY_ID_INDEX];
            if (!subCategoryId.matches(SUB_CATEGORY_ID_RANGE_REGEX)) {
                throw new CommandValidationException("sub-category_id out of range.");
            }
        }
        if (types.length > 1) {
            String categoryId = types[CATEGORY_ID_INDEX];
            if (!categoryId.matches(CATEGORY_ID_RANGE_REGEX)) {
                throw new CommandValidationException("category_id out of range.");
            }
        }
        String questionId = types[QUESTION_ID_INDEX];
        if (!questionId.matches(QUESTION_ID_RANGE_REGEX)) {
            throw new CommandValidationException("question_id out of range.");
        }
    }

    /**
     * response_type "P" OR "N"
     */
    @Override
    public void validateResponseType(String responseType) {
        if (!responseType.matches(FIRST_OR_NEXT_RESPONSE_TYPE_REGEX)) {
            throw new CommandValidationException("Wrong response type!");
        }
    }

    /**
     * date "dd.MM.yyyy" or "d.M.yyyy"
     */
    @Override
    public String validateDate(String date) {
        if (date.split(SIGN_THAT_SEPARATES_SERVICE_AND_VARIATION)[0].matches(ONE_DIGIT_DAY_OR_MONTH_REGEX)) {
            date = "0" + date;
            // this block handle the problem with single digit day-representation
        }
        if (date.split(SIGN_THAT_SEPARATES_SERVICE_AND_VARIATION)[1].matches(ONE_DIGIT_DAY_OR_MONTH_REGEX)) {
            date = date.replaceFirst(SIGN_THAT_SEPARATES_SERVICE_AND_VARIATION, ".0");
            // this block handle the problem with single digit month-representation
        }
        if (!date.matches(DATE_REGEX)) {
            throw new CommandValidationException("Date don't match format dd.MM.yyyy");
        }
        return date;
    }

    /**
     * time >= 0
     */
    @Override
    public void validateTime(int time) {
        if (time < 0) {
            throw new CommandValidationException("Time can't be below zero.");
        }
    }
}
