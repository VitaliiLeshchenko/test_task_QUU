package solution.services.impl;

import solution.services.AnalyzeService;
import solution.services.GeneralParser;
import solution.services.InputReaderService;
import solution.services.IoCContainer;
import solution.services.OutputWriterService;
import solution.services.QueryParser;
import solution.services.QueryValidator;
import solution.services.TimeLineParser;
import solution.services.TimeLineValidator;

public class IoCContainerImpl implements IoCContainer {

    private static final IoCContainerImpl instance = new IoCContainerImpl();

    private final QueryParser queryParser;
    private final QueryValidator queryValidator;
    private final TimeLineParser timeLineParser;
    private final TimeLineValidator timeLineValidator;
    private final InputReaderService inputReaderService;
    private final OutputWriterService outputWriterService;
    private final GeneralParser generalParser;

    private IoCContainerImpl() {
        timeLineValidator = new TimeLineValidatorImpl();
        timeLineParser = new TimeLineParserImpl(timeLineValidator);
        queryValidator = new QueryValidatorImpl(timeLineValidator);
        queryParser = new QueryParserImpl(queryValidator);
        inputReaderService = new InputReaderServiceTerminal();
        outputWriterService = new OutputWriterServiceTerminal();
        AnalyzeService analyzeService = new AnalyzeServiceImpl();
        generalParser = new GeneralParserImpl(timeLineParser, queryParser, analyzeService);
    }

    public static IoCContainerImpl getInstance(){
        return instance;
    }

    @Override
    public QueryParser getQueryParser() {
        return queryParser;
    }

    @Override
    public QueryValidator getQueryValidator() {
        return queryValidator;
    }

    @Override
    public TimeLineParser getTimeLineParser() {
        return timeLineParser;
    }

    @Override
    public TimeLineValidator getTimeLineValidator() {
        return timeLineValidator;
    }

    @Override
    public InputReaderService getInputReaderService() {
        return inputReaderService;
    }

    public OutputWriterService getOutputWriterService() {
        return outputWriterService;
    }

    @Override
    public GeneralParser getGeneralParser() {
        return generalParser;
    }
}
