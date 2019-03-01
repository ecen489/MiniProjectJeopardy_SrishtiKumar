package com.example.jeopardy1;

// Tuple of 3 items: State, Capital, True/False (whether State and Capital pair match)
public class Tuple
{
    String state;
    String capital;
    String answer;

    public Tuple(String aState, String aCapital, String anAnswer)
    {
        this.state = aState;
        this.capital = aCapital;
        this.answer = anAnswer;
    }

    public String getState() {
        return state;
    }

    public String getCapital() {
        return capital;
    }

    public String getAnswer() {
        return answer;
    }
}
