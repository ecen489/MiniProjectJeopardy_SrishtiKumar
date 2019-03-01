package com.example.jeopardy1;

import java.util.ArrayList;

public class Question
{
    public ArrayList<Tuple> questionList = new ArrayList<>();

    public ArrayList<Tuple> createQuestionList()
    {
        questionList.add(new Tuple("Texas", "Austin", "True"));
        questionList.add(new Tuple("California", "Sacramento", "True"));
        questionList.add(new Tuple("Florida", "Tallahassee", "True"));
        return questionList;
    }

}
