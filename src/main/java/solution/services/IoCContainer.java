package solution.services;

public interface IoCContainer {
    QueryParser getQueryParser();
    QueryValidator getQueryValidator();
    TimeLineParser getTimeLineParser();
    TimeLineValidator getTimeLineValidator();
    InputReaderService getInputReaderService();
    OutputWriterService getOutputWriterService();
    GeneralParser getGeneralParser();
}
