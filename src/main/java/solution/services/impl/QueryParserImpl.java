package solution.services.impl;

import java.time.LocalDate;
import solution.model.Query;
import solution.services.QueryParser;
import solution.services.QueryValidator;
import static solution.utils.Constants.DASH;
import static solution.utils.Constants.SPACE;
import static solution.utils.Constants.FORMATTER;
import static solution.utils.Constants.SPLIT_COMMAND_DATE_TO_INDEX;
import static solution.utils.Constants.SPLIT_COMMAND_SERVICE_INDEX;
import static solution.utils.Constants.SPLIT_COMMAND_QUESTION_INDEX;
import static solution.utils.Constants.SPLIT_COMMAND_RESPONSE_INDEX;
import static solution.utils.Constants.SPLIT_COMMAND_DATE_INDEX;

public class QueryParserImpl implements QueryParser {

    private final QueryValidator queryValidator;

    public QueryParserImpl(QueryValidator queryValidator) {
        this.queryValidator = queryValidator;
    }

    @Override
    public Query parseQuery(String line) {

        String[] arguments = line.split(SPACE);
        Query.Builder builder = Query.newBuilder();

        if (line.contains(DASH)) {
            line = line.replace(DASH, SPACE);
            arguments = line.split(SPACE);
            String dateToValue = arguments[SPLIT_COMMAND_DATE_TO_INDEX];
            dateToValue = queryValidator.validateDate(dateToValue);
            builder.setToDate(LocalDate.parse(dateToValue, FORMATTER));
        }

        String serviceValue = arguments[SPLIT_COMMAND_SERVICE_INDEX];
        String questionValue = arguments[SPLIT_COMMAND_QUESTION_INDEX];
        String responseTypeValue = arguments[SPLIT_COMMAND_RESPONSE_INDEX];
        String dateValue = arguments[SPLIT_COMMAND_DATE_INDEX];

        queryValidator.validateServiceType(serviceValue);
        queryValidator.validateQuestionType(questionValue);
        queryValidator.validateResponseType(responseTypeValue);
        dateValue = queryValidator.validateDate(dateValue);

        return builder.setServiceType(serviceValue)
                .setQuestionType(questionValue)
                .setResponseType(responseTypeValue)
                .setFromDate(LocalDate.parse(dateValue, FORMATTER))
                .build();
    }
}
