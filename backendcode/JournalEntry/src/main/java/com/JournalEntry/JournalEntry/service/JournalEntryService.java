package com.JournalEntry.JournalEntry.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID; 

import com.JournalEntry.JournalEntry.dao.JournalEntryDao;
import com.JournalEntry.JournalEntry.model.JournalEntry;
import com.JournalEntry.JournalEntry.model.Tag; 

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;  
/*
* Definition of the JournalEntry's data access object
*/
@Service
public class JournalEntryService {
    private final JournalEntryDao journalEntryDao;      
 
    @Autowired
    public JournalEntryService(@Qualifier("postgres") JournalEntryDao journalEntryDao) {
        this.journalEntryDao = journalEntryDao;
    }

    public int insertJournalEntry(JournalEntry entry) throws SQLException {
        return journalEntryDao.insertJournalEntry(entry);

    }
    public int deleteJournalEntry(String entryID) throws SQLException {
        return journalEntryDao.deleteJournalEntry(entryID);

    }
    public JournalEntry getJournalEntry(UUID entryID) {
        return journalEntryDao.getJournalEntry(entryID);

    }
    public int updateJournalText(UUID entryID,String text,String title) {
        return journalEntryDao.updateJournalText(entryID,text,title);

    }
    public UUID getLastJournalEntryID(){
        return journalEntryDao.getLastJournalEntryID();
    }
    
    
    
}
