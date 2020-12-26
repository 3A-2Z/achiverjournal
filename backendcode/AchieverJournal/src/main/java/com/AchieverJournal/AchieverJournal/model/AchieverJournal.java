package com.AchieverJournal.AchieverJournal.model;
import java.util.UUID;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
public class AchieverJournal {

    private ArrayList<JournalEntry> journalEntries;
    
    public AchieverJournal(@JsonProperty("entries")ArrayList<JournalEntry> journalEntries){
        this.journalEntries = journalEntries;
    }
    public ArrayList<JournalEntry> getJournalEntries(){
        return journalEntries;
    }




}
