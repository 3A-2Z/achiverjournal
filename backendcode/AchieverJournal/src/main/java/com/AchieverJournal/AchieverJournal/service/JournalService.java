package com.AchieverJournal.AchieverJournal.service;

import java.util.ArrayList;

import com.AchieverJournal.AchieverJournal.dao.AchieverJournalDao;
import com.AchieverJournal.AchieverJournal.model.AchieverJournal;
import com.AchieverJournal.AchieverJournal.model.JournalEntry;
import com.AchieverJournal.AchieverJournal.model.Tag;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/*
* Definition of the Achiever Journal's data access object
*/
@Service
public class JournalService {
    private final AchieverJournalDao achieverJournalDao;
    @Autowired
    public JournalService(@Qualifier("postgres") AchieverJournalDao achieverJournalDao){
        this.achieverJournalDao = achieverJournalDao;
    }


    
    public ArrayList<JournalEntry> getAllJournalEntries() {
        return achieverJournalDao.getAllJournalEntries();

    }
    
    
    
}
