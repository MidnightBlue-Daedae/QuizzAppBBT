package com.example.quizzappbbt;

public class Questions {

    private final int questionNum;
    private final boolean answer;

    // Store R.string IDs (integers) instead of hardcoded Strings
    private static final int[] questions = {
            R.string.q1,
            R.string.q2,
            R.string.q3,
            R.string.q4,
            R.string.q5
    };

    private static final boolean[] answers = {
            true,
            true,
            true,
            true,
            false
    };

    public Questions(int num) {
        this.questionNum = num;
        this.answer = getAnswer(this.questionNum);
    }

    private boolean getAnswer(int num) {
        for (int i = 0; i < answers.length; i++) {
            if (i == num) {
                return answers[i];
            }
        }
        return false;
    }

    public boolean returnAnswer() {
        return this.answer;
    }

    // Return an int (the R.string ID) instead of a String
    public static int nextQuestion(int currentNum) {
        for (int i = 0; i < questions.length; i++) {
            if (i == currentNum) {
                return questions[i];
            }
        }
        return R.string.q1;
    }
}