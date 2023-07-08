package com.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer
{
    @Id
    private int answerId;
    private String answer;
    @OneToOne
    /* - @OneToOne(mappedBy = "answer") - if we use this it will remove the extra question_id column from answer
         table then we will only have a_id column in question table from the mapping part, rest all the columns
         will be same
       - @OneToOne(mappedBy = "answer", fetch = FetchType.EAGER) - it is used to define the fetch type for ex.
         eager or lazy loading
       - Eager will load the data at the same time or on the spot  but in lazy it will only load the data when
         we call it explicitly through getter or size method */
    private Question question;

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    public Answer()
    {
        super();
    }
}
