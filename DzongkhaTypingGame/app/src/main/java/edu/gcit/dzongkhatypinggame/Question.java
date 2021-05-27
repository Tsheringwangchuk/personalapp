package edu.gcit.dzongkhatypinggame;

public class Question {


    public static final String CATEGORY_ONE = "Category_1";
    public static final String CATEGORY_TWO = "Category_2";


    private String question;
    private String answerNr;
    private String category;

    public Question() {

    }
    public Question(String question, String answerNr, String category) {
        this.question = question;
        this.answerNr = answerNr;
        this.category = category;
    }

    public static String getCategoryOne() {
        return CATEGORY_ONE;
    }

    public static String getCategoryTwo() {
        return CATEGORY_TWO;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(String answerNr) {
        this.answerNr = answerNr;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}




