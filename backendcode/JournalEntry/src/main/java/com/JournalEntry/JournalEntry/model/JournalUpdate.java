package com.JournalEntry.JournalEntry.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID; 

import com.fasterxml.jackson.annotation.JsonProperty;
/*
* Class was used for journal updates for initial in memory database implementation, may be ignored
*/
public class JournalUpdate {
   
    private String title;   
    
    private LocalDate date; 
    private String text;  

    public JournalUpdate(@JsonProperty("title") String title, @JsonProperty("text") String text) {
        this.title = title;
        this.text = text;
        this.date = java.time.LocalDate.now();
    }


    public String getTitle() {
        return title;
    }


    public LocalDate getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
    
}
