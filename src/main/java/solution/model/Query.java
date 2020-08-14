package solution.model;

import java.time.LocalDate;

public class Query extends Command {

    private LocalDate fromDate;
    private LocalDate toDate;

    private Query() {
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public static Builder newBuilder() {
        return new Query().new Builder();
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Builder setServiceType(String serviceType) {
            Query.this.serviceType = serviceType;

            return this;
        }

        public Builder setQuestionType(String questionType) {
            Query.this.questionType = questionType;

            return this;
        }

        public Builder setResponseType(String responseType) {
            Query.this.responseType = responseType;

            return this;
        }

        public Builder setFromDate(LocalDate fromDate) {
            Query.this.fromDate = fromDate;

            return this;
        }

        public Builder setToDate(LocalDate toDate) {
            Query.this.toDate = toDate;

            return this;
        }

        public Query build() {
            return Query.this;
        }
    }
}
