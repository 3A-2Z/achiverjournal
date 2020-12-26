package com.JournalEntry.JournalEntry.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
 
import javax.servlet.http.HttpServletRequest;

import com.JournalEntry.JournalEntry.model.JournalEntry;
import com.JournalEntry.JournalEntry.model.JournalUpdate;
import com.JournalEntry.JournalEntry.model.Tag;
import com.JournalEntry.JournalEntry.service.JournalEntryService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;      
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.json.JSONException; 
import org.json.JSONObject;
/*
* Journal Entry controller contains support for adding,updating, and retrieving journal entries 
*/
@RestController
public class JournalEntryController {
    private final JournalEntryService journalEntryService; 

    @Autowired
    public JournalEntryController(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;

    }
    /*
    * for passing health check in aws
    */
    
    @GetMapping("/")
    public String awsHealthCheck(){
       return "app is running just fine";    
    }  
    
    /*
    * Routing to add a new Journal to the database
    * Returns the inserted jounal's ID for URL link in view portion of component
    */
    
  
   

    @PostMapping("/api/v1/addentry")
    @CrossOrigin(origins = "http://azizaamino.com") 
    public UUID insertJournalEntry(@RequestBody JournalEntry entry) throws SQLException {
         journalEntryService.insertJournalEntry(entry);
         return journalEntryService.getLastJournalEntryID();

    }
    /*
    * Retrieves journal entry with the ID passed in the URL
    */
    @GetMapping("{entryID}")
    @CrossOrigin(origins = "http://azizaamino.com")
    public JournalEntry getJournalEntry(@PathVariable("entryID") String entryID) {
        System.out.println(entryID);
        UUID newEntryID = UUID.fromString(entryID);
        return journalEntryService.getJournalEntry(newEntryID);
    }
    /*
    * Updates the journal entry with the ID  in the URL
    *
    */
    @PutMapping("/put/{entryID}")
    @CrossOrigin(origins = "http://azizaamino.com")
    public int updateJournalText(@PathVariable("entryID") String entryID, @RequestBody JournalUpdate update) {
        
       UUID newEntryID = UUID.fromString(entryID);
        journalEntryService.updateJournalText(newEntryID,update.getText(),update.getTitle());
        return 1;
    }
    /*
    * Deletes journal entry record 
    *
    */
    @DeleteMapping("/del/{entryID}")
    @CrossOrigin(origins = "http://azizaamino.com")
    public int deleteJournalEntry(@PathVariable("entryID") String entryID) throws SQLException {
        
        journalEntryService.deleteJournalEntry(entryID);
        return 1;


    }

    
}
