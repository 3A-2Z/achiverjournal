package com.JournalEntry.JournalEntry.dao;

import com.JournalEntry.JournalEntry.model.JournalEntry;
import com.JournalEntry.JournalEntry.model.Tag;
import com.JournalEntry.JournalEntry.datasource.PostgresDatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID; 
import java.time.LocalDate; 
/*
* Service methods that interact with the database
*/

@Repository("postgres") 
public class JournalEntryDataAccessService implements JournalEntryDao { 

    private UUID lastID;

    @Autowired
    private final JdbcTemplate jdbcTemplate;
    public JournalEntryDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;  
    }

    @Override
    public int insertJournalEntry(JournalEntry journalEntry) throws SQLException {
        final String query = "insert into journalentry(entryID, title, entryDate, textData, tags) values(?, ?, ?, ?, ?);";
        Object[] params = { journalEntry.getEntryID(), journalEntry.getTitle(), journalEntry.getDate(),
                journalEntry.getText(),journalEntry.getEntryTags() };
        int[] types = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.update(query, params, types);
        lastID = journalEntry.getEntryID();// keeps track of the last inserted journal entry id
       
        return 1;
    }
    @Override
    public int deleteJournalEntry(String entryID) throws SQLException {
        final String query = "DELETE FROM journalentry WHERE entryID = ?";
        Object[] params = {entryID};
        int[] types = { Types.VARCHAR};
        jdbcTemplate.update(query, params, types);
        
        return 1;
    }

    @Override
    public JournalEntry getJournalEntry(UUID entryID) {
        
        JournalEntry entry = jdbcTemplate.queryForObject("Select entryID, title, entryDate, textData FROM journalentry WHERE entryID = ?",
                (rs, rowNum) -> new JournalEntry(entryID,LocalDate.parse(rs.getString("entryDate")), rs.getString("title"),rs.getString("textData")),
        new Object[]{entryID.toString()}


        
        );
        return entry;
   
    }
    @Override
    public int updateJournalText(UUID entryID, String text,String title) {
        final String query = "UPDATE journalentry SET title = ? , entryDate = ?, textData = ?, tags = ? WHERE entryID = ?";
        JournalEntry tmpEntry = new JournalEntry(entryID, title, text);
        Object[] params = {title,tmpEntry.getDate(),text, tmpEntry.getEntryTags(), entryID };
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        
        jdbcTemplate.update(
            query,params,types
                );
            
       
        return 1;
        

    }
    @Override
    public UUID getLastJournalEntryID(){
        return lastID;
    }

   

}
