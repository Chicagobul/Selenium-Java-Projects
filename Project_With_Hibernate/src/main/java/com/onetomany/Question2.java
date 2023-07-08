package com.onetomany;

import com.onetoone.Answer;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question2
{
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;

    @OneToMany(mappedBy = "question")
    private List<Answer2> answers;

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

    public List<Answer2> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer2> answers) {
        this.answers = answers;
    }

    public Question2(int questionId, String question, List<Answer2> answers) {
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
    }

    public Question2()
    {
        super();
    }
}
