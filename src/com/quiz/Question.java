package com.quiz;

public class Question {
	 private String questionText;
	    private String[] options;
	    private int correctAnswer; // index (0-based)

	    public Question(String questionText, String[] options, int correctAnswer) {
	        this.questionText = questionText;
	        this.options = options;
	        this.correctAnswer = correctAnswer;
	    }

	    public void displayQuestion() {
	        System.out.println(questionText);
	        for (int i = 0; i < options.length; i++) {
	            System.out.println((i + 1) + ". " + options[i]);
	        }
	    }

	    public boolean checkAnswer(int userAnswer) {
	        return (userAnswer - 1) == correctAnswer;
	    }

	    public String getCorrectOption() {
	        return options[correctAnswer];
	    }

	    public int getCorrectAnswerIndex() {
	        return correctAnswer;
	    }

}
