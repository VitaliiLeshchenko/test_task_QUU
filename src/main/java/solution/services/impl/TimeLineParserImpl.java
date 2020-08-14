package solution.services.impl;

import java.time.LocalDate;
import solution.model.TimeLine;
import solution.services.TimeLineParser;
import solution.services.TimeLineValidator;
import static solution.utils.Constants.FORMATTER;
import static solution.utils.Constants.SPLIT_COMMAND_SERVICE_INDEX;
import static solution.utils.Constants.SPLIT_COMMAND_QUESTION_INDEX;
import static solution.utils.Constants.SPLIT_COMMAND_RESPONSE_INDEX;
import static solution.utils.Constants.SPLIT_COMMAND_DATE_INDEX;
import static solution.utils.Constants.SPACE;
import static solution.utils.Constants.SPLIT_COMMAND_TIME_INDEX;

public class TimeLineParserImpl implements TimeLineParser {

    private final TimeLineValidator timeLineValidator;

    public TimeLineParserImpl(TimeLineValidator timeLineValidator) {
        this.timeLineValidator = timeLineValidator;
    }

    @Override
    public TimeLine parseTimeLine(String line) {

        String[] arguments = line.split(SPACE);
        TimeLine.Builder builder = TimeLine.newBuilder();

        String serviceValue = arguments[SPLIT_COMMAND_SERVICE_INDEX];
        String questionValue = arguments[SPLIT_COMMAND_QUESTION_INDEX];
        String responseTypeValue = arguments[SPLIT_COMMAND_RESPONSE_INDEX];
        String dateValue = arguments[SPLIT_COMMAND_DATE_INDEX];
        int time = Integer.parseInt(arguments[SPLIT_COMMAND_TIME_INDEX]);

        timeLineValidator.validateServiceType(serviceValue);
        timeLineValidator.validateQuestionType(questionValue);
        timeLineValidator.validateResponseType(responseTypeValue);
        timeLineValidator.validateDate(dateValue);
        timeLineValidator.validateTime(time);

        return builder.setServiceType(serviceValue)
                .setQuestionType(questionValue)
                .setResponseType(responseTypeValue)
                .setFromDate(LocalDate.parse(dateValue, FORMATTER))
                .setTime(time)
                .build();
    }
}
