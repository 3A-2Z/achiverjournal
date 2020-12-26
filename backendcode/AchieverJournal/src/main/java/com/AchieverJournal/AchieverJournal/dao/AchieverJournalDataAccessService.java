package com.AchieverJournal.AchieverJournal.dao;

import com.AchieverJournal.AchieverJournal.model.AchieverJournal;
import com.AchieverJournal.AchieverJournal.model.JournalEntry;
import com.AchieverJournal.AchieverJournal.model.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.sql.Types;
/*
* Service methods that interact with the database
*/
@Repository("postgres")
public class AchieverJournalDataAccessService implements AchieverJournalDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;
    public AchieverJournalDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    
    @Override
    public ArrayList<JournalEntry> getAllJournalEntries() {

        final String query = "SELECT entryID, title, entryDate FROM journalentry";
        ArrayList<JournalEntry> journals = new ArrayList<JournalEntry>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, new Object[]{});
        for(Map<String, Object> row: rows){

            JournalEntry tmpEntry = new JournalEntry(UUID.fromString((String)row.get("entryID")),(String)row.get("title"),(String)row.get("entryDate"));
            journals.add(tmpEntry);
        }
        return new AchieverJournal(journals).getJournalEntries();

    }
   

}
