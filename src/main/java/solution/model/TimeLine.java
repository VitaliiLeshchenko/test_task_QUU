package solution.model;

import java.time.LocalDate;

public class TimeLine extends Command {

    private LocalDate date;
    private int time;

    private TimeLine() {

    }

    public LocalDate getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    public static Builder newBuilder() {
        return new TimeLine().new Builder();
    }

    public class Builder {
        
        private Builder() {
        }

        public Builder setServiceType(String serviceType) {
            TimeLine.this.serviceType = serviceType;

            return this;
        }

        public Builder setQuestionType(String questionType) {
            TimeLine.this.questionType = questionType;

            return this;
        }

        public Builder setResponseType(String responseType) {
            TimeLine.this.responseType = responseType;

            return this;
        }

        public Builder setFromDate(LocalDate date) {
            TimeLine.this.date = date;

            return this;
        }

        public Builder setTime(int time) {
            TimeLine.this.time = time;

            return this;
        }

        public TimeLine build() {
            return TimeLine.this;
        }
    }
}
