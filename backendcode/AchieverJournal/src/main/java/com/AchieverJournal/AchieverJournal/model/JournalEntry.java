package com.AchieverJournal.AchieverJournal.model;

import java.util.ArrayList;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
/*
* This is a partial JournalEntry object with only the attributes relevant in View display 
* of the achiever's entries
*/
public class JournalEntry {
    private final UUID entryID;
    private final String title;
    private final String date;

    public JournalEntry(@JsonProperty("ID") UUID entryID, @JsonProperty("title")String title,  @JsonProperty("date")String date) {
        this.entryID = entryID;
        this.title = title;
        this.date = date;
   }
   public UUID getEntryID(){
       return entryID;
   }
   public String getTitle(){
       return title;
   }
   public String getDate(){
       return date;
   }
    
}
