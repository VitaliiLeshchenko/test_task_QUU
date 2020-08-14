package solution.utils;

import java.time.format.DateTimeFormatter;

public class Constants {
    public static final String STAR = "*";
    public static final String DASH = "-";
    public static final String SPACE = " ";
    public static final String TIME_LINE_COMMAND = "C";
    public static final String QUERY_COMMAND = "D";

    public static final int SPLIT_COMMAND_SERVICE_INDEX = 1;
    public static final int SPLIT_COMMAND_QUESTION_INDEX = 2;
    public static final int SPLIT_COMMAND_RESPONSE_INDEX = 3;
    public static final int SPLIT_COMMAND_DATE_INDEX = 4;
    public static final int SPLIT_COMMAND_DATE_TO_INDEX = 5;
    public static final int SPLIT_COMMAND_TIME_INDEX = 5;
    public static final int MAX_COUNT_OF_ALL_LINES = 100000;
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static final String SERVICE_ID_RANGE_REGEX = "[1-9]|10";
    public static final String VARIATION_ID_RANGE_REGEX = "[1-3]";
    public static final String QUESTION_ID_RANGE_REGEX = "[1-9]|10";
    public static final String CATEGORY_ID_RANGE_REGEX = "^([1]?\\d|20)$";
    public static final String SUB_CATEGORY_ID_RANGE_REGEX = "[1-5]";
}