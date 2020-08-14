package serviceTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import solution.model.Query;
import solution.model.TimeLine;
import solution.services.AnalyzeService;
import solution.services.impl.AnalyzeServiceImpl;

public class AnalyzeServiceTest {

    private AnalyzeService analyzeService;
    private TimeLine timeLine1;
    private TimeLine timeLine2;
    private Query query;
    private Query queryWrongDate;

    @Before
    public void initialize() {
        analyzeService = new AnalyzeServiceImpl();
        timeLine1 = TimeLine.newBuilder()
                .setServiceType("10.1")
                .setQuestionType("10.19.5")
                .setResponseType("P")
                .setFromDate(LocalDate.of(2012, 12,12))
                .setTime(13)
                .build();
        timeLine2 = TimeLine.newBuilder()
                .setServiceType("10.1")
                .setQuestionType("10.19")
                .setResponseType("P")
                .setFromDate(LocalDate.of(2012, 12,13))
                .setTime(23)
                .build();
        query = Query.newBuilder()
                .setServiceType("10")
                .setQuestionType("10.19")
                .setResponseType("P")
                .setFromDate(LocalDate.of(2012, 12,12))
                .setToDate(LocalDate.of(2012, 12, 15))
                .build();
        queryWrongDate = Query.newBuilder()
                .setServiceType("10")
                .setQuestionType("10.1")
                .setResponseType("P")
                .setFromDate(LocalDate.of(2011, 12,12))
                .setToDate(LocalDate.of(2011, 12, 15))
                .build();
    }

    @Test
    public void analyzeTest_ok() {
        List<TimeLine> timeList = new ArrayList<>();
        timeList.add(timeLine1);
        timeList.add(timeLine2);
        String actual = analyzeService.analyze(timeList, query);
        String expected = "18";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void analyze_missing_query() {
        List<TimeLine> timeList = new ArrayList<>();
        timeList.add(timeLine1);
        timeList.add(timeLine2);
        String actual = analyzeService.analyze(timeList, queryWrongDate);
        Assert.assertEquals("-", actual);
    }
}
