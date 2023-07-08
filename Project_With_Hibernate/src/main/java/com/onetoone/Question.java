package com.onetoone;

import javax.persistence.*;

@Entity
public class Question
{
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;
    @OneToOne
    @JoinColumn(name = "a_id")
    // renaming the answer column name to a_id same we can do for table by using @JoinTable
    private Answer answer;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Question(int questionId, String question, Answer answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public Question()
    {
        super();
    }
}
