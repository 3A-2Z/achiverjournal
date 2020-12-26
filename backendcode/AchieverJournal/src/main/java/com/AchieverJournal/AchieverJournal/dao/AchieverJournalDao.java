package com.AchieverJournal.AchieverJournal.dao;

import java.util.ArrayList;

import com.AchieverJournal.AchieverJournal.model.AchieverJournal;
import com.AchieverJournal.AchieverJournal.model.JournalEntry;
import com.AchieverJournal.AchieverJournal.model.Tag;
/*
* Interface containing all service methods
*/
public interface AchieverJournalDao {
    /*
    * Service method to retrieve Achiver's journal
    */
    ArrayList<JournalEntry> getAllJournalEntries();
}