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

    public Questions(int num) {
        questionNum = num;
        answer = getAnswer(questionNum);
    }

    public boolean getAnswer(int num) {
        if (num == 1) {
            return true;
        } else if (num == 2) {
            return true;
        } else if (num == 3) {
            return false;
        } else if (num == 4) {
            return true;
        } else {
            return false;
        }
    }

    public boolean returnAnswer() {
        return this.answer;
    }

    public static String nextQuestion(int currentNum) {
        if (currentNum >= 0 && currentNum < questions.length) {
            return questions[currentNum];
        }
        return "";
    }
}