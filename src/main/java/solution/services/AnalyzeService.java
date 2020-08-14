package solution.services;

import java.util.List;
import solution.model.Query;
import solution.model.TimeLine;

public interface AnalyzeService {
    String analyze(List<TimeLine> timeLineList, Query query);
}
