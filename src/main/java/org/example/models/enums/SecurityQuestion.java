package org.example.models.enums;

public enum SecurityQuestion {
    FIRST_PET("What was the name of your first pet?", 1),
    MOTHER_MAIDEN_NAME("What is your mother's maiden name?", 2),
    CHILDHOOD_STREET("What street did you grow up on?", 3),
    FIRST_SCHOOL("What was the name of your first school?", 4),
    FAVORITE_FOOD("What is your favorite food?", 5),
    BIRTH_CITY("In which city were you born?", 6);

    private final String questionText;
    private final int questionNumber;

    SecurityQuestion(String questionText, int questionNumber) {
        this.questionText = questionText;
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public static SecurityQuestion getByNumber(int number) {
        for (SecurityQuestion question : values()) {
            if (question.getQuestionNumber() == number) {
                return question;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return questionNumber + ". " + questionText;
    }
}
