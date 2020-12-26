package com.JournalEntry.JournalEntry.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID; 

import com.JournalEntry.JournalEntry.model.JournalEntry;
import com.JournalEntry.JournalEntry.model.Tag;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;     
/* 
* Interface containing all service methods
*/
public interface JournalEntryDao {
    /*
    * Service method to add new journal entries
    */
    int insertJournalEntry(JournalEntry entry) throws SQLException;
    default int addJournalEntry(JournalEntry entry) throws SQLException {

        return insertJournalEntry(entry);
    }
    /*
    * Service method to retrieve journal entry for the text interface within the view 
    */
    JournalEntry getJournalEntry(UUID entryID);
    /*
    * Service method to update a journal entry's text,tags, and tite
    */
    int updateJournalText(UUID entryID, String text,String title);
    /*
    * Used to send back an entry ID as a response after post request with jounal entry data
    */
    UUID getLastJournalEntryID();
    /*
    *Service to delete journal entry record
    */ 
    int deleteJournalEntry(String entryID) throws SQLException;
}