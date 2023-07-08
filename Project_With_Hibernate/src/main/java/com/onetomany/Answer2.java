package com.onetomany;

import com.onetoone.Question;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Answer2
{
    @Id
    private int answerId;
    private String answer;
    @ManyToOne
    // @OneToOne(mappedBy = "answer") - if we use this it will remove the extra question_id column from answer
    // table then we will only have a_id column in question table from the mapping part, rest all the columns will
    // be same
    private Question2 question;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question2 getQuestion() {
        return question;
    }

    public void setQuestion(Question2 question) {
        this.question = question;
    }

    public Answer2(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    public Answer2()
    {
        super();
    }
}
