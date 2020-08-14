package solution.services.impl;

import java.time.LocalDate;
import java.util.List;
import solution.model.Query;
import solution.model.TimeLine;
import solution.services.AnalyzeService;
import static solution.utils.Constants.DASH;
import static solution.utils.Constants.STAR;

public class AnalyzeServiceImpl implements AnalyzeService {

    @Override
    public String analyze(List<TimeLine> timeLineList, Query query) {

        String response;

        int matchesTimelineCount = 0;
        int totalTime = 0;

        for (TimeLine timeLine : timeLineList) {
            if (matchServiceOrQuestionTypes(query.getServiceType(), timeLine.getServiceType())) {
                if (matchServiceOrQuestionTypes(query.getQuestionType(), timeLine.getQuestionType())) {
                    if (matchAnswer(query.getResponseType(), timeLine.getResponseType())) {
                        if (matchDate(query.getFromDate(), query.getToDate(), timeLine.getDate())) {
                            matchesTimelineCount++;
                            totalTime += timeLine.getTime();
                        }
                    }
                }
            }
        }

        if (matchesTimelineCount == 0) {
            response = DASH;
        } else {
            response = String.valueOf(totalTime / matchesTimelineCount);
        }

        return response;
    }

    private boolean matchDate(LocalDate queryDateFrom, LocalDate dateTo, LocalDate date) {
        if (dateTo == null) {
            return queryDateFrom.equals(date);
        } else {
            return !queryDateFrom.isAfter(date) && !dateTo.isBefore(date);
        }
    }

    private boolean matchAnswer(String queryResponseType, String timeLineResponseType) {
        return queryResponseType.equals(timeLineResponseType);
    }

    private boolean matchServiceOrQuestionTypes(String queryType, String timeLineType) {
        if (queryType.equals(STAR)) {
            return true;
        } else {
            if (timeLineType.startsWith(queryType)) {
                String rest = timeLineType.replace(queryType, "");
                return rest.startsWith(".") || rest.equals("");
            }
        }
        return false;
    }
}
