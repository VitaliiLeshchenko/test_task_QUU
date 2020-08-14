package serviceTest;

import org.junit.Assert;
import org.junit.Test;
import solution.exceptions.CommandValidationException;
import solution.services.QueryValidator;
import solution.services.impl.IoCContainerImpl;

public class QueryAndTimeLineValidatorsTest {

    private final QueryValidator queryValidator = IoCContainerImpl.getInstance().getQueryValidator();

    // test service_id

    @Test
    public void service_star_value_ok() {
        queryValidator.validateServiceType("*");
    }

    @Test
    public void service_biggest_value_ok() {
        queryValidator.validateServiceType("10.3");
    }

    @Test
    public void service_smallest_value_without_variations_ok() {
        queryValidator.validateServiceType("1");
    }

    @Test
    public void service_expected_behavior() {
        queryValidator.validateServiceType("6.2");
    }

    @Test(expected = CommandValidationException.class)
    public void service_id_out_of_range1() {
        queryValidator.validateServiceType("11");
    }

    @Test(expected = CommandValidationException.class)
    public void service_id_out_of_range2() {
        queryValidator.validateServiceType("0");
    }

    @Test(expected = CommandValidationException.class)
    public void service_id_out_of_range3() {
        queryValidator.validateServiceType("-1");
    }

    @Test(expected = CommandValidationException.class)
    public void service_variation_id_out_of_range1() {
        queryValidator.validateServiceType("10.4");
    }

    @Test(expected = CommandValidationException.class)
    public void service_variation_id_out_of_range2() {
        queryValidator.validateServiceType("10.0");
    }

    // test question_id

    @Test
    public void service_question_value_ok() {
        queryValidator.validateQuestionType("*");
    }

    @Test
    public void question_id_ok1() {
        queryValidator.validateQuestionType("10.20.5");
    }

    @Test
    public void question_id_ok2() {
        queryValidator.validateQuestionType("1.20");
    }

    @Test
    public void question_id_ok3() {
        queryValidator.validateQuestionType("8");
    }

    @Test(expected = CommandValidationException.class)
    public void question_id_smaller() {
        queryValidator.validateQuestionType("-9.1.1");
    }

    @Test(expected = CommandValidationException.class)
    public void question_id_bigger() {
        queryValidator.validateQuestionType("12.1.1");
    }

    @Test(expected = CommandValidationException.class)
    public void question_id_zero() {
        queryValidator.validateQuestionType("0.1.1");
    }

    @Test(expected = CommandValidationException.class)
    public void category_id_smaller() {
        queryValidator.validateQuestionType("1.-1.1");
    }

    @Test(expected = CommandValidationException.class)
    public void category_id_bigger() {
        queryValidator.validateQuestionType("2.21.1");
    }

    @Test(expected = CommandValidationException.class)
    public void category_id_zero() {
        queryValidator.validateQuestionType("1.01.1");
    }

    @Test(expected = CommandValidationException.class)
    public void sub_category_id_smaller() {
        queryValidator.validateQuestionType("1.1.-1");
    }

    @Test(expected = CommandValidationException.class)
    public void sub_category_id_bigger() {
        queryValidator.validateQuestionType("2.20.6");
    }

    @Test(expected = CommandValidationException.class)
    public void sub_category_id_zero() {
        queryValidator.validateQuestionType("10.19.0");
    }

    // test response_type

    @Test
    public void response_type_first() {
        queryValidator.validateResponseType("P");
    }

    @Test
    public void response_type_next() {
        queryValidator.validateResponseType("N");
    }

    @Test(expected = CommandValidationException.class)
    public void response_type_both() {
        queryValidator.validateResponseType("PN");
    }

    @Test(expected = CommandValidationException.class)
    public void response_type_another() {
        queryValidator.validateResponseType("M");
    }

    // test date

    @Test
    public void date_valid() {
        queryValidator.validateDate("11.01.2022");
    }

    @Test(expected = CommandValidationException.class)
    public void date_invalid3() {
        queryValidator.validateDate("0111111111.01.2022191231");
    }

    @Test()
    public void date_invalid1() {
        String actual = queryValidator.validateDate("1.1.2020");
        String expected = "01.01.2020";
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = CommandValidationException.class)
    public void date_invalid2() {
        queryValidator.validateDate("99.99.9999");
    }
}
