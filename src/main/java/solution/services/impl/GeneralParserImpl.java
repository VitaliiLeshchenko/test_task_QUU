package solution.services.impl;

import java.util.ArrayList;
import java.util.List;
import solution.exceptions.CommandValidationException;
import solution.model.Query;
import solution.model.TimeLine;
import solution.services.AnalyzeService;
import solution.services.GeneralParser;
import solution.services.QueryParser;
import solution.services.TimeLineParser;
import static solution.utils.Constants.TIME_LINE_COMMAND;
import static solution.utils.Constants.QUERY_COMMAND;

public class GeneralParserImpl implements GeneralParser {

    private final TimeLineParser timeLineParser;
    private final QueryParser queryParser;
    private final AnalyzeService analyzeService;

    public GeneralParserImpl(TimeLineParser timeLineParser, QueryParser queryParser, AnalyzeService analyzeService) {
        this.timeLineParser = timeLineParser;
        this.queryParser = queryParser;
        this.analyzeService = analyzeService;
    }

    @Override
    public List<String> parse(List<String> lines) {
        List<TimeLine> timeLineList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();

        for (String line : lines) {
            if (line.startsWith(TIME_LINE_COMMAND)) {
                TimeLine timeLine = timeLineParser.parseTimeLine(line);
                timeLineList.add(timeLine);
            } else if (line.startsWith(QUERY_COMMAND)) {
                Query query = queryParser.parseQuery(line);
                resultList.add(analyzeService.analyze(timeLineList, query));
            } else {
                throw new CommandValidationException("Wrong input data");
            }
        }
        return resultList;
    }
}
