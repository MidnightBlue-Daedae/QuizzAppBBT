package com.example.quizzappbbt;

public class Questions {

    private final int questionNum;
    private final boolean answer;
    private static final String[] questions = {
            "True or False: Sheldon Cooper's signature catchphrase after pulling a prank or making a joke is 'Bazinga!'",
            "True or False: The Big Bang Theory had a total of 12 seasons.",
            "True of False: The Big Bang Theory was filmed in front of a live studio audience.",
            "True or False: The main characters work at the California Institute of Technology (Caltech).",
            "True or False: The series was based on a real-life scientific research group."
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
        for (int i = 1; i < answers.length - 1; i++) {
            if (i == num) {
                return answers[i];
            }
        }
        return false;
    }

    public boolean returnAnswer() {
        return this.answer;
    }

    public static String nextQuestion(int currentNum) {
        for (int i = 0; i < questions.length; i++) {
            if (i == currentNum) {
                return questions[i];
            }
        }
        return "";
    }
}