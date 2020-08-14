package solution.model;

public abstract class Command {
    protected String serviceType;
    protected String questionType;
    protected String responseType;

    public String getServiceType() {
        return serviceType;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getResponseType() {
        return responseType;
    }
}
