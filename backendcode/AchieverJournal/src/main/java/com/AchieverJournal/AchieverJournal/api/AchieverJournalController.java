package com.AchieverJournal.AchieverJournal.api;

import java.util.ArrayList;

import com.AchieverJournal.AchieverJournal.model.AchieverJournal;
import com.AchieverJournal.AchieverJournal.model.JournalEntry;
import com.AchieverJournal.AchieverJournal.model.Tag;
import com.AchieverJournal.AchieverJournal.service.JournalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
* Achiever Journal controller contains support for retrieving an achiever's journal (collection of JournalEntry objects)
*/
@RestController
public class AchieverJournalController {
    private final JournalService journalService;
    @Autowired
    public AchieverJournalController(JournalService journalService){
        this.journalService = journalService;


    }
    /*
    * for passing health check in aws
    */
    @RequestMapping("/")
    public String awsHealthCheck(){
        return "app is running just fine";
    }
    /*
    * retrieves an achiever's journal (collection of JournalEntry objects)
    */
    @GetMapping("/api/v1/entries")
        @CrossOrigin(origins = "http://localhost:5000")
   public ArrayList<JournalEntry> getAllJournalEntries(){
       return journalService.getAllJournalEntries();
   } 
    
}
