package solution.services;

public interface TimeLineValidator {
    void validateServiceType(String serviceType);
    void validateQuestionType(String questionType);
    void validateResponseType(String responseType);
    String validateDate(String date);
    void validateTime(int time);
}
