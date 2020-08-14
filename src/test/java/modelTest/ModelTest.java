package modelTest;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import solution.model.Query;
import solution.model.TimeLine;

public class ModelTest {
    @Test()
    public void serviceOutOfBound() {
        Query query = Query.newBuilder()
                .setServiceType("10.1")
                .setQuestionType("10.20.5")
                .setResponseType("P")
                .setFromDate(LocalDate.of(2012, 12,12))
                .setToDate(LocalDate.of(2012, 12, 15))
                .build();
        Assert.assertEquals("10.1", query.getServiceType());
        Assert.assertEquals("10.20.5", query.getQuestionType());
        Assert.assertEquals("P", query.getResponseType());
        Assert.assertEquals(LocalDate.of(2012, 12,12), query.getFromDate());
        Assert.assertEquals(LocalDate.of(2012, 12,15), query.getToDate());
    }

    @Test()
    public void a1() {
        TimeLine timeLine = TimeLine.newBuilder()
                .setServiceType("10.1")
                .setQuestionType("10.20.5")
                .setResponseType("P")
                .setFromDate(LocalDate.of(2012, 12,12))
                .setTime(12)
                .build();
        Assert.assertEquals("10.1", timeLine.getServiceType());
        Assert.assertEquals("10.20.5", timeLine.getQuestionType());
        Assert.assertEquals("P", timeLine.getResponseType());
        Assert.assertEquals(LocalDate.of(2012, 12,12), timeLine.getDate());
        Assert.assertEquals(12, timeLine.getTime());
    }
}
