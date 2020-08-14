package solution.services;

public interface QueryValidator {

    void validateServiceType(String serviceType);
    void validateQuestionType(String questionType);
    void validateResponseType(String responseType);
    String validateDate(String date);
}
